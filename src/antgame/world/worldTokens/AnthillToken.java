package antgame.world.worldTokens;

import antgame.ant.color.Color;
import antgame.model.FoodStack;
import antgame.model.Position;
import java.util.Stack;

/**
 *
 * @author ItsTheRai
 */
public class AnthillToken extends TerrainToken{

    public AnthillToken(Position p,Color color){
        //not sure if need food stack for anthill
        
        super(false,p,new FoodStack(),true,color);
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
