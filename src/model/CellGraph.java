/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author lars
 */
public class CellGraph {
    private Cell[][] table;
    private int cellRow;
    private int cellCol;
    private int simulations;
    
    
    public CellGraph(int dX, int dY)
    {
        this.cellRow=dX;
        this.cellCol=dY;
        this.table = new Cell[dX][dY];
        this.simulations=0;
        for(int i=0; i < dX; i++)
        {
            for(int n=0; n < dY; n++)
            {
               this.table[i][n] = new Cell(i, n);
            }
        }
    }
    public void run()
    {
        for(int i=0; i < this.cellRow; i++)
        {
            for(int n=0; n < this.cellCol; n++)
            {
               if(!this.table[i][n].isAlive()&&this.table[i][n].scan(this.table))
               {
                   this.table[i][n].changeState();
               }
               else if(this.table[i][n].isAlive()&&!this.table[i][n].scan(this.table))
               {
                   this.table[i][n].changeState();
               }
               
            }
        }
        this.simulations++;
    }
}
