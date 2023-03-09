package ie;

import processing.core.PApplet;

public class LifeBoard {
    boolean[][] board;
    boolean[][] next;

    private int size;
    PApplet p;

    public LifeBoard(int size, PApplet p) {
        this.size = size;
        board = new boolean[size][size];
        next = new boolean[size][size];
        this.p = p;
    }

    public void randomise() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                float dice = p.random(0, 1);
                board[row][col] = (dice <= 0.5f);
            }
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean getCell(int row, int col) {
        if (row < 0 || row >= size || col < 0 || col >= size) {
            return false;
        }
        return board[row][col];
    }

    public int countNeighbours(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (!(i == 0 && j == 0)) {
                    if (getCell(row + i, col + j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public void applyRules() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int neighbours = countNeighbours(row, col);
                if (board[row][col]) {
                    // live cell
                    if (neighbours == 2 || neighbours == 3) {
                        next[row][col] = true;
                    } else {
                        next[row][col] = false;
                    }
                } else {
                    // dead cell
                    if (neighbours == 3) {
                        next[row][col] = true;
                    } else {
                        next[row][col] = false;
                    }
                }
            }
        }
        // swap current board with next board
        boolean[][] temp = board;
        board = next;
        next = temp;
    }
}
