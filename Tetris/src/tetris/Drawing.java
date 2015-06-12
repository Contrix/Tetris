/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author Jirka
 */
public class Drawing {
    
    private final Game gm = new Game();
    
    private final int posunX = 25;
    private final int posunY = 25;
    private int px = 25;
    
    
    
    public void drawAll(GraphicsContext gc, double width, double height){
        drawBackGround(gc, width, height);
        drawObjects(gc);
        //drawPanel(gc);
    }
    
    public void drawObjects(GraphicsContext gc){
        if (!gm.getGameOver()){
                gm.newObject();
                gm.setGameOver();
            }
        for (Object obj : gm.getObjects()){
            gc.setFill(obj.getColor());
            for (int i = 0; i < obj.getArray().length; i++){
                for (int j = 0; j < obj.getArray()[0].length; j++){
                    if (obj.getArray()[i][j] != Color.TRANSPARENT){
                        gc.fillRect((obj.getPoint().getX() + j) * px + posunX, (obj.getPoint().getY() + i) * px + posunY, px, px);
                    }
                }
            }
            
        }
    }
    
    public void drawBackGround(GraphicsContext gc, double width, double height){
        gc.setFill(Color.GREEN);
        gc.fillRect(0, 0, width, height);
        
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 20; j++){
                gc.setFill(Color.GREEN);
                gc.fillRect(i * px + posunX, j * px + posunY, px, px);
                gc.setFill(Color.LIGHTGREEN);
                gc.fillRect(i * px + posunX, j * px + posunY, px-1, px-1);
            }
        }
    }
    
    public void drawPanel(GraphicsContext gc){
        //score, level, lines, next, (time), 
    }
    
}
