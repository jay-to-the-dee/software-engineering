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
public class AntPosition {
    private int xlocation;
    private int ylocation;
    public AntPosition(int x, int y){
        xlocation = x;
        ylocation = y;
    }

    public int getXlocation() {
        return xlocation;
    }

    public int getYlocation() {
        return ylocation;
    }

    public void setXlocation(int xlocation) {
        this.xlocation = xlocation;
    }
    

    public void setYlocation(int ylocation) {
        this.ylocation = ylocation;
    }
    
}
