package antgame.ant.direction;

import antgame.model.Position;
import antgame.model.TerrainToken;
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
