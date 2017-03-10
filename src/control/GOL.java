/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import javafx.scene.image.Image;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage; 
/**
 *
 * @author lars
 */
public class GOL extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/view/GOL.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.getIcons().add(new Image(this.getClass().getResource("icon.png").toString()));
        stage.setTitle("Conways Game of Life" );
        stage.setMaxWidth(1044);        
        stage.setMaxHeight(666);
        stage.setMinHeight(666);
        stage.setMinWidth(1044);
        stage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
