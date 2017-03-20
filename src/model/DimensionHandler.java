/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.Optional;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.StageStyle;
import javafx.util.Pair;

/**
 *
 * @author ZuraH
 */
public class DimensionHandler {
    public static CellGraph createDialog()
    {
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Dimension Editor");
        dialog.initStyle(StageStyle.UTILITY);
        
        ButtonType confirmButton = new ButtonType("Confirm", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(confirmButton);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        TextField xcor = new TextField();
        xcor.setPromptText("Width");
        TextField ycor = new TextField();
        ycor.setPromptText("Height");

        grid.add(xcor, 0, 0);
        grid.add(ycor, 1, 0);

        dialog.getDialogPane().setContent(grid);
        
        Optional<Pair<String, String>> result = dialog.showAndWait();
        if (result.isPresent()){
            int x = Integer.valueOf(xcor.getText());
            int y = Integer.valueOf(ycor.getText());
            CellGraph cg = new CellGraph(x,y);
            return cg;
        };
        
        return null;
    }
}
