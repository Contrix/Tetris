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
public class Object5 extends Object{
    private final Color color = Color.BLUE;
    private Color[][] arrayy = {{t, c, t}, {t, c, t}, {c, c, t}};
    
    public Object5(){
        array = this.arrayy;
        c = this.color;
    }
}
