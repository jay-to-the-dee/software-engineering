/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antgame.model;

import java.util.Stack;

/**
 *
 * @author Main User
 */
public class FoodStack extends Stack{

    public FoodStack() {
    }

    @Override
    public synchronized int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public synchronized boolean equals(Object o) {
        if (o instanceof FoodStack){
            if(((FoodStack)o).size()==this.size()){
                return true;
            }
        }
        return false; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
