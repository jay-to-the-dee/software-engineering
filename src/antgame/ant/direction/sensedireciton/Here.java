package antgame.ant.direction.sensedireciton;

import antgame.model.Position;
import antgame.world.worldTokens.TerrainToken;
import antgame.model.World;

/**
 *
 * @author ItsTheRai
 */
public class Here implements Direction{

    @Override
    public TerrainToken getTileInDirection(World world, Position position,int direction) {
        return world.getTokenAt(position.getXlocation(), position.getYlocation());
    }


    
}
