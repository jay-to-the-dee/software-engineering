package antgame.world.worldTokens;

import antgame.model.Position;
import antgame.ant.color.ColorBlack;

/**
 *
 * @author ItsTheRai
 */
public class BlackAnthillToken extends AnthillToken{

    /**
     *
     * @param p of anthill in the world
     */
    public BlackAnthillToken(Position p) {
        super(p, new ColorBlack());
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof BlackAnthillToken){
        return super.equals(obj);
        }
        else return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }
    
    

    
}
