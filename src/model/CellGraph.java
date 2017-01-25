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
    }
}
