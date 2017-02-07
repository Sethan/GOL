/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.control.Button;
import model.CellGraph;
import model.Paint;

/**
 *
 * @author lars
 */
public class Controls implements Initializable {
    
    
    
    @Override
    public void initialize(java.net.URL location, java.util.ResourceBundle resources) 
    {
       GraphicsContext gc = mainCanvas.getGraphicsContext2D();
       Paint.drawGrid(gc, mainCanvas, test);
        
    }
    @FXML private Button startBtn;
    @FXML private Button stopBtn;
    @FXML private Button resetBtn;
    @FXML private Canvas mainCanvas;
    @FXML private Slider speedSlider;
    
    CellGraph test=new CellGraph(70,41);
    
    
    
    
    
    
    //user events
    
    public void canvasClick(MouseEvent event)
    {
       
        Paint.toggleSquare((int)event.getX(), (int)event.getY(), mainCanvas, test);
        GraphicsContext gc = mainCanvas.getGraphicsContext2D();
        Paint.drawSquares(gc, mainCanvas, test);
        Paint.drawGrid(gc, mainCanvas, test);
    }

    public void speedIncreased(MouseEvent event)
    {
        System.out.println("Oesf");
    }

    public void stopButton(ActionEvent event)
    {
		
    }
    
    public void resetButton(ActionEvent event)
    {
        
    }
    
    public void startButton(ActionEvent event)
    {
        
    }
     
}
