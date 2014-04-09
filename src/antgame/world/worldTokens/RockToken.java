package antgame.world.worldTokens;

import antgame.model.FoodStack;
import antgame.model.Position;

/**
 *
 * @author ItsTheRai
 */
public class RockToken extends TerrainToken{
    //

    /**
     *
     * @param position position of the token in the world
     */
        public RockToken(Position position){
        super(true,position,new FoodStack(),false,null);
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof RockToken){
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
        }
        else return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}