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

public int countCells(int row, int col)
        {
            for (int j = -1 ; j <= 1 ; j ++)
            {
                if (! (i == 0) && (j == 0))
                if (! (i == 0 && j == 0))
                {
                    if (getCell(i, j))
                    if (getCell(row + i, col + j))
                    {
                        count ++;
                    }
public void applyRules()
                    {
                        next[row][col] = false;
                    }

                }
                else
                {
public void applyRules()
                // dead with 3 neighboiurs comes to life
            }
        }
        boolean[][] temp = board;
        boolean[][] temp;
        temp = board;
        board = next;
        next = temp;
    }
}
