package antgame.ant.direction.sensedireciton;

import antgame.model.Position;
import antgame.world.worldTokens.TerrainToken;
import antgame.model.World;

/**
 *
 * @author ItsTheRai
 */
public class RightAhead implements Direction{

    @Override
    public TerrainToken getTileInDirection(World world, Position position,int direction) {
        return world.getAdjacentCell((direction+1)%6, position);
    }



    
}
