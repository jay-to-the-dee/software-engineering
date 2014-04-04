package antgame.ant.direction;

import antgame.model.Position;
import antgame.model.TerrainToken;
import antgame.model.World;

/**
 *
 * @author ItsTheRai
 */
public class Here implements Direction{

    @Override
    public TerrainToken getTileInDirection(World world, Position position,int direction) {
        return (TerrainToken)world.getTokenAt(position.getXlocation(), position.getYlocation());
    }


    
}
