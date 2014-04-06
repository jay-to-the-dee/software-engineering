package antgame.world.worldTokens;

import antgame.ant.color.Color;
import antgame.ant.color.ColorRed;
import antgame.model.Position;

/**
 *
 * @author ItsTheRai
 */
public class RedAnthillToken extends AnthillToken{

    public RedAnthillToken(Position p) {
        super(p, new ColorRed());
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof RedAnthillToken){
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
        }
        else return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

}
