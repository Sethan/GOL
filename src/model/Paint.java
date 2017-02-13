/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
//import java.awt.Color;
import java.awt.Image;
import java.awt.Graphics;
import javax.swing.SwingUtilities;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import model.CellGraph;
import javafx.scene.paint.Color;


/**
 *
 * @author lars
 */
public class Paint {
    
    public static void drawGrid(GraphicsContext gc, Canvas mC, CellGraph cellG)
    {
        gc = mC.getGraphicsContext2D();
        gc.setFill(javafx.scene.paint.Color.GREY);

        for(int t=1 ; t<cellG.getW(); t++)
        {   
            int x=t *(int)(mC.getWidth())/(cellG.getW());
            gc.fillRect(x,0,1,mC.getHeight());
        }
        
        for(int t=1 ; t<cellG.getH(); t++)
        {   
            int y=t *(int) mC.getHeight()/cellG.getH();
            gc.fillRect(0,y,mC.getWidth(),1);
        }
    }
    
    public static void drawSquares(GraphicsContext gc, Canvas mC, CellGraph cellG)
    {
        gc = mC.getGraphicsContext2D();
        int maxB = 255/cellG.getW();
        int maxG = 255/cellG.getH();
        
        
        gc.setFill(javafx.scene.paint.Color.WHITESMOKE);
        gc.fillRect(0, 0, mC.getWidth(), mC.getHeight());
        for(int i = 0; i<cellG.getH();i++)
        {
            for(int n=0; n<cellG.getW();n++)
            {
                if(cellG.table[n][i].isAlive())
                {

                    gc.setFill(Color.rgb(150, maxG*i, maxB*n));
                  
   
                    int x=n*(int)mC.getWidth()/cellG.getW();
                    int y=i*(int)mC.getHeight()/cellG.getH();
                    gc.fillRect(x,y, mC.getWidth()/cellG.getW(), mC.getHeight()/cellG.getH());
                }
            }
        }
    }
    public static void toggleSquare(int x, int y, Canvas mC, CellGraph cellG)
    {
        int n=(x*cellG.getW())/(int)mC.getWidth();
        int i=(y*cellG.getH())/(int)mC.getHeight();
        cellG.table[n][i].changeState();
    }    
}
