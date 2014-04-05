package antgame.world.worldTokens;

import antgame.model.Position;
import java.util.Stack;

/**
 *
 * @author ItsTheRai
 */
public class RockToken extends TerrainToken{
    //
    public RockToken(Position position, Stack food){
        super(true,position,food,false,null);
    }
}
