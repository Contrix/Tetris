/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Jirka
 */
public class Tetris extends Application {
    
    private final Drawing drw = new Drawing();
    private final Game gm = new Game();
    
    @Override
    public void start(Stage primaryStage) {
        
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 600, 600);
        
        Canvas canvas = new Canvas(scene.getWidth(), scene.getHeight());
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        
        canvas.widthProperty().bind(scene.widthProperty());
        canvas.heightProperty().bind(scene.heightProperty());
        
        drw.drawAll(gc, canvas.getWidth(), canvas.getHeight());
        
        Timeline timer = new Timeline(new KeyFrame(Duration.millis(1000), (ActionEvent event) -> {
            drw.drawAll(gc, canvas.getWidth(), canvas.getHeight());
        }));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
        
        
        
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent e) -> {
            switch (e.getCode()) {
                case W:
                    gm.getObject().rotateRight();
                    drw.drawAll(gc, canvas.getWidth(), canvas.getHeight());
                    break;
                case S:
                    gm.getObject().rotateLeft();
                    drw.drawAll(gc, canvas.getWidth(), canvas.getHeight());
                    break;
                case A:
                    gm.getObject().moveLeft();
                    drw.drawAll(gc, canvas.getWidth(), canvas.getHeight());
                    break;
                case D:
                    gm.getObject().moveRight();
                    drw.drawAll(gc, canvas.getWidth(), canvas.getHeight());
                    break;
                    
                case NUMPAD8:
                    //gm.setKey(0);
                    break;
                case NUMPAD2:
                    //gm.setKey(1);
                    break;
                case NUMPAD4:
                    //gm.setKey(2);
                    break;
                case NUMPAD6:
                    //gm.setKey(3);
                    break;
                    
                case UP:
                    //gm.setKey(0);
                    break;
                case DOWN:
                    //gm.setKey(1);
                    
                    break;
                case LEFT:
                    //gm.setKey(2);
                    break;
                case RIGHT:
                    //gm.setKey(3);
                    break;
                    
                case F5:
                    if (gm.getGameOver()){
                        //gm.reset();
                    }
                    break;
                case R:
                    if (gm.getGameOver()){
                        //gm.reset();
                    }
                    break;
                    
                case ESCAPE:
                    primaryStage.close();
                    break;
                case P:
                    /*if(gm.pause()){
                        timer.pause();
                        timer1.pause();
                        timer2.pause();
                        timer3.pause();
                        timer4.pause();
                        timer5.pause();
                    }
                    else{
                        timer.play();
                        timer1.play();
                        timer2.play();
                        timer3.play();
                        timer4.play();
                        timer5.play();
                    }*/
                    break;
                default:
                    break;
            }
        });
        
        
        
        
        
        
        root.getChildren().add(canvas);
        primaryStage.setTitle("Tetris");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
