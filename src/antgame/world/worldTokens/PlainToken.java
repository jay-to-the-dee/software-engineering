package antgame.world.worldTokens;

import antgame.model.FoodStack;
import antgame.model.Position;

/**
 *
 * @author ItsTheRai
 */
public class PlainToken extends TerrainToken{

    /**
     *
     * @param position coordinates in the world
     * @param food FoodStack object to be put in the token
     */
    public PlainToken(Position position,FoodStack food){
        super(false,position,food,false,null);
    }
    
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}