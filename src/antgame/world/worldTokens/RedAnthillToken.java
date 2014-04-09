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
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
