package antgame.model;

import java.util.Stack;

/**
 * Each TerrainToken(except RockToken) has this object
 * its size represents the number of food particles in the location
 * @author ItsTheRai
 */
public class FoodStack extends Stack{

    public FoodStack() {
    }

    @Override
    public synchronized int hashCode() {
        return super.hashCode();
    }

    @Override
    public synchronized boolean equals(Object o) {
        if (o instanceof FoodStack){
            if(((FoodStack)o).size()==this.size()){
                return true;
            }
        }
        return false;
    }
}
