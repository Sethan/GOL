/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.Timer;
import java.util.TimerTask;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import model.CellGraph;
import model.Paint;
import model.FileHandler;
import model.DimensionHandler;
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
       timer.scheduleAtFixedRate(task, 500, 500);
       
        
    }
    @FXML private Button startBtn;
    @FXML private Button stopBtn;
    @FXML private Button resetBtn;
    @FXML private Canvas mainCanvas;
    @FXML private Slider speedSlider;
    private static boolean play=false;
    CellGraph test=new CellGraph(70,40);
    Timer timer = new Timer(true);
    RunTimer task = new RunTimer();
    
    double zoom = 1;
    
    //user events
    
    public void canvasClick(MouseEvent event)
    {
        Paint.toggleSquare((int)event.getX(), (int)event.getY(), mainCanvas, test, zoom);
        GraphicsContext gc = mainCanvas.getGraphicsContext2D();
        Paint.drawSquares(gc, mainCanvas, test, test.getSimulations());
        Paint.drawGrid(gc, mainCanvas, test);
    }

    public void speedIncreased(MouseEvent event)
    {
        int delay = 350-30*(int)Math.sqrt(speedSlider.getValue());
        task.cancel();
        task = new RunTimer();
        timer.scheduleAtFixedRate(task, 250, delay);
    }

    public void zoomIn(ActionEvent event)
    {
        zoom=zoom*2;
        GraphicsContext gc = mainCanvas.getGraphicsContext2D();
        gc.scale(2,2);
        Paint.cleanCanvas(gc, mainCanvas);
        Paint.drawSquares(gc, mainCanvas, test, test.getSimulations());
        Paint.drawGrid(gc, mainCanvas, test);
    }

    public void zoomOut(ActionEvent event)
    {
        if(zoom>1)
        {
            zoom=zoom*0.5;
            GraphicsContext gc = mainCanvas.getGraphicsContext2D();
            gc.scale(0.5,0.5);
            Paint.cleanCanvas(gc, mainCanvas);
            Paint.drawSquares(gc, mainCanvas, test, test.getSimulations());
            Paint.drawGrid(gc, mainCanvas, test);
        }
    }
    
    public void stopButton(ActionEvent event)
    {
	play=false;	
    }
    
    public void resetButton(ActionEvent event)
    {
        test.resetGraph();
        GraphicsContext gc = mainCanvas.getGraphicsContext2D();
        Paint.drawSquares(gc, mainCanvas, test, test.getSimulations());
        Paint.drawGrid(gc, mainCanvas, test);
        
    }
    
    public void loadEvent(ActionEvent event)
    {
        play=false;
        FileHandler.loadFile(test);
        GraphicsContext gc = mainCanvas.getGraphicsContext2D();
        Paint.drawSquares(gc, mainCanvas, test, test.getSimulations());
        Paint.drawGrid(gc, mainCanvas, test);
    }
    
    public void saveEvent(ActionEvent event)
    {
        play=false;
        FileHandler.saveFile(test);
        
    }
   
    public void startButton(ActionEvent event)
    {
        play=true;
    }
    
    public void changeDimensions(ActionEvent event)
    {
        play=false;
        test = DimensionHandler.createDialog();
        GraphicsContext gc = mainCanvas.getGraphicsContext2D();
        Paint.drawSquares(gc, mainCanvas, test, test.getSimulations());
        Paint.drawGrid(gc, mainCanvas, test);
    }
    
    private class RunTimer extends TimerTask
    {
        @Override 
        public void run()
        {
            if(play)
            {
                test.run();
                GraphicsContext gc = mainCanvas.getGraphicsContext2D();
                Paint.drawSquares(gc, mainCanvas, test, test.getSimulations());
                Paint.drawGrid(gc, mainCanvas, test);
            }
        }
    }
}
