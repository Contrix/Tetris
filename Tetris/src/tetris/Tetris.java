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
        Scene scene = new Scene(root, 425, 550);
        
        Canvas canvas = new Canvas(scene.getWidth(), scene.getHeight());
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        
        canvas.widthProperty().bind(scene.widthProperty());
        canvas.heightProperty().bind(scene.heightProperty());
        gm.newGame();
        drw.drawAll(gc, canvas.getWidth(), canvas.getHeight());
        
        Timeline timer = new Timeline(new KeyFrame(Duration.millis(1000), (ActionEvent event) -> {
            if(!gm.isGameOver()){
                gm.next();
                gm.setTime();
                drw.drawAll(gc, canvas.getWidth(), canvas.getHeight());
            }
        }));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
        
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent e) -> {
            if(!gm.isGameOver()){
                switch (e.getCode()) {
                    case S:
                        gm.next();
                        drw.drawAll(gc, canvas.getWidth(), canvas.getHeight());
                        break;
                    case A:
                        gm.moveLeft();
                        drw.drawAll(gc, canvas.getWidth(), canvas.getHeight());
                        break;
                    case D:
                        gm.moveRight();
                        drw.drawAll(gc, canvas.getWidth(), canvas.getHeight());
                        break;
                    case Q:
                        gm.rotateLeft();
                        drw.drawAll(gc, canvas.getWidth(), canvas.getHeight());
                        break;
                    case E:
                        gm.rotateRight();
                        drw.drawAll(gc, canvas.getWidth(), canvas.getHeight());
                        break;

                    case NUMPAD2:
                        gm.next();
                        drw.drawAll(gc, canvas.getWidth(), canvas.getHeight());
                        break;
                    case NUMPAD4:
                        gm.moveLeft();
                        drw.drawAll(gc, canvas.getWidth(), canvas.getHeight());
                        break;
                    case NUMPAD6:
                        gm.moveRight();
                        drw.drawAll(gc, canvas.getWidth(), canvas.getHeight());
                        break;
                    case NUMPAD7:
                        gm.rotateLeft();
                        drw.drawAll(gc, canvas.getWidth(), canvas.getHeight());
                        break;
                    case NUMPAD9:
                        gm.rotateRight();
                        drw.drawAll(gc, canvas.getWidth(), canvas.getHeight());
                        break;

                    case DOWN:
                        gm.next();
                        drw.drawAll(gc, canvas.getWidth(), canvas.getHeight());
                        break;
                    case LEFT:
                        gm.moveLeft();
                        drw.drawAll(gc, canvas.getWidth(), canvas.getHeight());
                        break;
                    case RIGHT:
                        gm.moveRight();
                        drw.drawAll(gc, canvas.getWidth(), canvas.getHeight());
                        break;
                    case DELETE:
                        gm.rotateLeft();
                        drw.drawAll(gc, canvas.getWidth(), canvas.getHeight());
                        break;
                    case PAGE_DOWN:
                        gm.rotateRight();
                        drw.drawAll(gc, canvas.getWidth(), canvas.getHeight());
                        break;
                    default:
                        break;
                }
            }
                    
            switch (e.getCode()) {
                case F5:
                    gm.newGame();
                    drw.drawAll(gc, canvas.getWidth(), canvas.getHeight());
                    break;
                case R:
                    gm.newGame();
                    drw.drawAll(gc, canvas.getWidth(), canvas.getHeight());
                    break;
                    
                case ESCAPE:
                    primaryStage.close();
                    break;
                case P:
                    if(gm.pause()){
                        timer.pause();
                    }
                    else{
                        timer.play();
                    }
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
