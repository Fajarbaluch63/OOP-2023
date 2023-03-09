package ie;

import processing.core.PApplet;

public class LifeBoard {
    boolean[][] board;

    private int size;
    PApplet p;

    public LifeBoard(int size, PApplet p)
    {
        this.size = size;
        board = new boolean [size][size];
        this.p = p;
    }

    public void randomise()
    {
        for (int row=0; row<size; row++)
        {
            for(int col=0; col<size; col++)
            {
                float dice = p.random(0,1);
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
}
