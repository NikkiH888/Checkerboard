/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pane;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author nikkihotrabhavananda
 */
public class Checkerboard extends Anchor {
    //Fields
    private Color lightColor;
    private Color darkColor;
    private GridPane gridPane = new GridPane();
    
    public Checkerboard(int numRows, int numCols, double boardWidth, double boardHeight) {
        super(numRows, numCols, boardWidth, boardHeight);
        this.lightColor = Color.RED;
        this.darkColor  = Color.BLACK;
    }
    
    public Checkerboard(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor) {
        super(numRows, numCols, boardWidth, boardHeight);
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }
    
    public Color getLightColor() {
        return this.lightColor; 
    }
    
    public Color getDarkColor() {
        return this.darkColor;
    }
    
    // Build the board UI and returns an AnchorPane as the root object
    @Override
    public AnchorPane build(double boardWidth, double boardHeight, int numRows, int numCols, Color lightColor, Color darkColor) {

        super.build(boardWidth, boardHeight, numRows, numCols, lightColor, darkColor); // set sides of AnchorPane and other elements
        
        clear(); // clear gridPane before using
        
        gridPane.setPrefWidth(boardWidth);
        gridPane.setPrefHeight(boardHeight);
        
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                
                Color currentColor;
                
                int ifEvenNum = (row + col) % 2;
                
                if (ifEvenNum == 0) {
                    currentColor = lightColor;
                }
                else {
                    currentColor = darkColor;
                }
                
                Rectangle rect = new Rectangle(this.rectWidth, this.rectHeight, currentColor);
                
                gridPane.add(rect, row, col);
            }
        }    
        
//        root.getChildren().clear();
        // Put the gridPane into the AnchorPane root
        super.root.getChildren().add(gridPane);
      
        return root;
    }

    public void clear() { //clear the gridPane
        gridPane.getChildren().clear();
    }
}
