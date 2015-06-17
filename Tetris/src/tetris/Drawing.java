/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Jirka
 */
public class Drawing {
    private final Game gm = new Game();
    private final int posunX = 25;
    private final int posunY = 25;
    private int px = 25;
    private final Color primary = Color.LIGHTGREY;
    private final Color secondary = Color.GREY;
    
    public void drawAll(GraphicsContext gc, double width, double height){
        drawBackGround(gc, width, height);
        drawObjects(gc);
        drawPanel(gc);
    }
    
    public void drawObjects(GraphicsContext gc){
        for (Object obj : gm.getObjects()){
            gc.setFill(obj.getColor());
            drawObject(gc, obj);            
        }
    }
    
    private void drawObject(GraphicsContext gc, Object obj){
        gc.setFill(obj.getColor());
        for (int i = 0; i < obj.getArray().length; i++){
            for (int j = 0; j < obj.getArray()[0].length; j++){
                if (obj.getArray()[i][j] != Color.TRANSPARENT){
                    if ((obj.getPoint().getY()) + i <= 19){
                        gc.fillRect((obj.getPoint().getX() + j) * px + posunX, (obj.getPoint().getY() + i) * px + posunY, px, px);
                    }
                }
            }
        }
    }
    
    public void drawBackGround(GraphicsContext gc, double width, double height){
        gc.setFill(secondary);
        gc.fillRect(0, 0, width, height);
        
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 20; j++){
                if(j <3){
                    gc.setFill(Color.BEIGE);
                }
                else{
                    gc.setFill(primary);
                }
                gc.fillRect(i * px + posunX, j * px + posunY, px-1, px-1);
            }
        }
    }
    
    public void drawPanel(GraphicsContext gc){
        gc.setFill(primary);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
        
        gc.fillText(String.format("Time"), 325 + posunX, 25 + posunY);
        gc.fillText(String.format("Next"), 325 + posunX, 125 + posunY);
        gc.fillText(String.format("Level"), 325 + posunX, 325 + posunY);
        gc.fillText(String.format("Lines"), 325 + posunX, 425 + posunY);
        
        gc.setFont(Font.font("Verdana", FontWeight.BOLD, 22));
        gc.fillText(String.format("%2d :%2d", gm.getTime()[1], gm.getTime()[0]), 325 + posunX, 60 + posunY);
        gc.fillText(String.format("%d", gm.getLevel()), 325 + posunX, 360 + posunY);
        gc.fillText(String.format("%d", gm.getLines()), 325 + posunX, 460 + posunY);
        
        gc.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
        gc.setTextAlign(TextAlignment.RIGHT);
        gc.fillText(String.format("© Jiří Hanák"), 415, 540);
        gc.setTextAlign(TextAlignment.LEFT);
        gc.fillText(String.format("v 0.9"), 10, 540);
        
        drawObject(gc, gm.getNextObejct());
    }
}
