/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antgame.ant.color;

/**
 *
 * @author ItsTheRai
 */
public class Color {
    String color;
    public Color(String c){
        color=c;
    }

    public Color() {
        
    }
    public Color otherColor(Color c){
        if(c instanceof ColorBlack){
            return new ColorRed();
        }
        else return new ColorBlack();
    }
    
}
