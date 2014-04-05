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
}