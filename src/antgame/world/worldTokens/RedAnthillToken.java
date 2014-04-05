package antgame.world.worldTokens;

import antgame.model.Position;
import antgame.ant.color.Color;

/**
 *
 * @author ItsTheRai
 */
public class RedAnthillToken extends AnthillToken{

    public RedAnthillToken(Position p) {
        super(p, new Color());
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
