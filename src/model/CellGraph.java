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
    public Cell[][] table;
    private final int cellRow;
    private final int cellCol;
    private int simulations;
    public Boolean[][] copy;
          
    
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
    
    public int getW()
    {
        return this.cellRow;
    }
    
    public int getH()
    {
        return this.cellCol;
    }
    
    public void run()
    {
        this.copy = null;
        this.copy = new Boolean[this.cellRow][this.cellCol];
        for(int i=0; i<this.cellRow;i++)
        {
            for(int n=0; n<this.cellCol; n++)
            {
                this.copy[i][n]=this.table[i][n].isAlive();
            }
        }
       
        for(int i=0; i < this.cellRow; i++)
        {
            for(int n=0; n < this.cellCol; n++)
            {    
               this.decide(i, n);
            }
        }
        
        for(int i=0; i<this.cellRow;i++)
        {
            for(int n=0; n<this.cellCol; n++)
            {
                if(this.copy[i][n]!=this.table[i][n].isAlive())
                {
                    this.table[i][n].changeState();
                }
            }
        }
        
        this.simulations++;
    }
    public void findAlive()
    {
        String s = "";
        for(int i=0; i < this.cellRow; i++)
        {
            for(int n=0; n < this.cellCol; n++)
            {
                if(this.table[i][n].isAlive())
                {
                    String t =i+","+n+"   ";
                    s=s+t;
                }
            }
        }
        System.out.println(s);
    }

    public void decide(int x , int y)
    {
        int neighbours=this.scan(x, y);

        if(this.table[x][y].isAlive())
        {
            if(neighbours>3||neighbours<2)
            {
                this.copy[x][y]=!this.copy[x][y];//dreper cellen
              
            }
        }
        else
        {
            if(neighbours==3)
            {
                this.copy[x][y]=!this.copy[x][y];//gjennopliver celler
            }
        }
    }
    
    public int scan(int x, int y)
    {
        int neighbours=0;
            
        for(int i =-1; i<2; i++)
        {
            for(int n=-1; n<2; n++)
            {
                if(!(n==0&&i==0))
                {
                    if((x+i<0)||(y+n<0)||(y+n>this.cellCol-1)||(x+i>this.cellRow-1))
                    {
                        
                    }
                    else if(this.table[x+i][y+n].isAlive())
                    {
                        neighbours++;
                        
                    }
                }
            }
        }
        return neighbours;

    }
    public void resetGraph()
    {
        for(int i=0; i < this.cellRow; i++)
        {
            for(int n=0; n < this.cellCol; n++)
            {
                if(this.table[i][n].isAlive())
                {
                    this.table[i][n].changeState();
                }
            }
        }
    }
}
