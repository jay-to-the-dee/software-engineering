package antgame.model.world;

import antgame.model.Position;
import antgame.model.TerrainToken;
import antgame.parsers.worldparser.GetType;
import java.util.Stack;

/**
 *
 * @author Main User
 */
public class RockToken extends TerrainToken{
    //
    public RockToken(Position position, Stack food){
        super(true,position,food,false,null);
    }
}
