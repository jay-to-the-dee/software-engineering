package antgame.world.worldTokens;

import antgame.model.FoodStack;
import antgame.model.Position;
import java.util.Stack;

/**
 *
 * @author ItsTheRai
 */
public class PlainToken extends TerrainToken{
    public PlainToken(Position position,FoodStack food){
        super(false,position,food,false,null);
    }
    
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}