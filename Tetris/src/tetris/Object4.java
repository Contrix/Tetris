/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import javafx.scene.paint.Color;

/**
 *
 * @author Jirka
 */
public class Object4 extends Object{
    private final Color color = Color.ORANGE;
    private Color[][] arrayy = {{c, t}, {c, t}, {c, c}};
    
    public Object4(){
        array = this.arrayy;
        c = this.color;
    }
}
