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
public class Object6 extends Object{
    private final Color color = Color.LIGHTGREEN;
    private Color[][] arrayy = {{t, c, c}, {c, c, t}, {t, t, t}};
    
    public Object6(){
        array = this.arrayy;
        c = this.color;
    }
}
