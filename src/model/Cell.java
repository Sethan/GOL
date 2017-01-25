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
public class Cell {
    private boolean alive;
    private int xLocation;
    private int yLocation;
    
    public Cell(int xLoc, int yLoc)
    {
        this.xLocation=xLoc;
        this.yLocation=yLoc;
        this.alive=false;
    }
    
    public void changeState()
    {
        this.alive=!this.alive;
    }
    
    public boolean isAlive()
    {
        return this.alive;
    }
    public boolean scan(Cell[][] table)
    {
        int t=0;
        
        for(int i =-1; i<2; i++)
        {
            for(int n=-1; n<2; n++)
            {
                if(!(n==0&&i==0))
                {
                    if(table[this.xLocation+i][this.yLocation+n].isAlive())
                    {
                        t=t+1;
                    }
                }
            }
        }
        
        
        if(t==3)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
