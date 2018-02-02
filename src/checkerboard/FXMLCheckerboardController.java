/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author nikkihotrabhavananda
 */
public class FXMLCheckerboardController implements Initializable, Startable {
    
    private Stage stage;
    
    private int numRows = 8;
    private int numCols = 8;
    
    private Color[] colors = {Color.RED, Color.BLACK, Color.SKYBLUE, Color.DARKBLUE};
    
    private Color lightColor = colors[0];
    private Color darkColor  = colors[1];
    
    private pane.Checkerboard checkerboard;
    
    private double offsetOfVBox = 51.5;
     
    @FXML
    private VBox vBox; 

    @FXML
    private void handleMenuItemGrid16X16Action(ActionEvent event) {
        System.out.println("16 X 16");
        this.numRows = 16;
        this.numCols = 16;
        refresh();
    }
    
    @FXML
    private void handleMenuItemGrid10X10Action(ActionEvent event) {
        System.out.println("10 X 10");
        this.numRows = 10;
        this.numCols = 10;
        refresh();
    }
    
    @FXML
    private void handleMenuItemGrid8X8Action(ActionEvent event) {
        System.out.println("8 X 8");
        this.numRows = 8;
        this.numCols = 8;
        refresh();
    }
    
    @FXML
    private void handleMenuItemGrid3X3Action(ActionEvent event) {
        System.out.println("3 X 3");
        this.numRows = 3;
        this.numCols = 3;
        refresh();
    }
    
    @FXML
    private void handleMenuItemDefaultColorSchemeAction(ActionEvent event) {
        System.out.println("Default Mode");
        this.lightColor = colors[0];
        this.darkColor  = colors[1];
        refresh();
    }
    
    @FXML
    private void handleMenuItemBlueColorSchemeAction(ActionEvent event) {
        System.out.println("Blue Mode");
        this.lightColor = colors[2];
        this.darkColor  = colors[3];
        refresh();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }   
     
    @Override
    public void start(Stage stage) {
        this.stage = stage;
        
        // Default display before choosing anyhting...
        checkerboard = new pane.Checkerboard(this.numRows, this.numCols, stage.getWidth(), stage.getHeight());
        checkerboard.build(stage.getWidth(), stage.getHeight()-this.offsetOfVBox, this.numRows, this.numCols, this.lightColor, this.darkColor);
        vBox.getChildren().add(checkerboard.getBoard());
        
        
        // Listen for resize events with assigning a lamba expression to a variable that is passing as a parameter
        ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            refresh();
        };
        
        this.stage.widthProperty().addListener(lambdaChangeListener);
        this.stage.heightProperty().addListener(lambdaChangeListener);
        
    }
        
    private void refresh() {
        //Call new Checkerboard
        checkerboard.build(stage.getWidth(), stage.getHeight()-this.offsetOfVBox, this.numRows, this.numCols, this.lightColor, this.darkColor);
    }
}
