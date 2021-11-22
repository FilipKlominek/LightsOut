package cz.educanet.lights.out.domain;

import cz.educanet.lights.out.domain.interfaces.ILightsOut;

import java.util.Random;

public class Game implements ILightsOut {
    private boolean[][] grid = new boolean[5][5];

    public Game() {
        Random rn = new Random();
        boolean[][] initialClicks = new boolean[5][5]; //randomizing every cell individually could end up in an unsolvable state
        for (int i = 0; i < initialClicks.length; i++) {
            for (int j = 0; j < initialClicks[i].length; j++) {
                initialClicks[i][j] = rn.nextBoolean();
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (initialClicks[i][j]) this.makeMove(j, i);
            }
        }
    }

    private int moveCount = 0;

    @Override
    public int getMoveCount() {
        return this.moveCount;
    }

    public void addMove() {
        this.moveCount++;
    }  //putting this in makeMove would count moves made when randomizing

    @Override
    public boolean isGameOver() {
        for (int i = 0; i < getGrid().length; i++) {
            for (int j = 0; j < getGrid()[i].length; j++) {
                if (!getGrid()[i][j]) return false;
            }
        }
        return true;
    }

    @Override
    public boolean[][] getGrid() {
        return this.grid;
    }

    @Override
    public void makeMove(int x, int y) {
        if (this.getGrid()[x][y]) this.grid[x][y] = false; //center
        else this.grid[x][y] = true;

        if (x > 0) { //left
            if (this.grid[x-1][y]) this.grid[x-1][y] = false;
            else this.grid[x-1][y] = true;
        }

        if (x < 4) { //right
            if (this.grid[x+1][y]) this.grid[x+1][y] = false;
            else this.grid[x+1][y] = true;
        }

        if (y > 0) { //top
            if (this.grid[x][y-1]) this.grid[x][y-1] = false;
            else this.grid[x][y-1] = true;
        }

        if (y < 4) { //bottom
            if (this.grid[x][y+1]) this.grid[x][y+1] = false;
            else this.grid[x][y+1] = true;
        }


    }
}
