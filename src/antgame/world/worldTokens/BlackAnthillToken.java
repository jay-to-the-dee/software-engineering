package antgame.world.worldTokens;

import antgame.model.Position;
import antgame.ant.color.ColorBlack;

/**
 *
 * @author ItsTheRai
 */
public class BlackAnthillToken extends AnthillToken{

    public BlackAnthillToken(Position p) {
        //Color c= new ColorBlack();
        //ColorBlack c = new Color();
        super(p, new ColorBlack());
    }

    
}
