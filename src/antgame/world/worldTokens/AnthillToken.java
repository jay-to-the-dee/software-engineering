package antgame.world.worldTokens;

import antgame.ant.color.Color;
import antgame.model.FoodStack;
import antgame.model.Position;

/**
 *
 * @author ItsTheRai
 */
public class AnthillToken extends TerrainToken{

    /**
     *
     * @param p of anthill in the world
     * @param color Color of anthill
     */
    public AnthillToken(Position p,Color color){
        //not sure if need food stack for anthill
        
        super(false,p,new FoodStack(),true,color);
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
