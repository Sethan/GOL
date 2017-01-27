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
}
