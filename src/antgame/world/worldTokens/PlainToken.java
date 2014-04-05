package antgame.world.worldTokens;

import antgame.model.Position;
import java.util.Stack;

/**
 *
 * @author ItsTheRai
 */
public class PlainToken extends TerrainToken{
    public PlainToken(Position position,Stack food){
        super(false,position,food,false,null);
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof PlainToken){
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
        }
        else return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }
}