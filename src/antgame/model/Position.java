/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antgame.model;

/**
 *
 * @author Main User
 */
public class Position {
    private final int xlocation;
    private final int ylocation;
    public Position(int x, int y){
        xlocation = x;
        ylocation = y;
    }

    public int getXlocation() {
        return xlocation;
    }

    public int getYlocation() {
        return ylocation;
    }
    public void setXlocation(int x){
        
    }
    
}
