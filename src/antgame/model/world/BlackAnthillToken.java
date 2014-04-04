package antgame.model.world;

import antgame.model.Position;
import antgame.parsers.worldparser.GetType;

/**
 *
 * @author Main User
 */
public class BlackAnthillToken extends AnthillToken{

    public BlackAnthillToken(Position p) {
        //Color c= new ColorBlack();
        //ColorBlack c = new Color();
        super(p, new ColorBlack());
    }

    
}
