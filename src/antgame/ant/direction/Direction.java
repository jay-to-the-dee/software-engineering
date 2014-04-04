package antgame.ant.direction;

import antgame.model.Position;
import antgame.model.TerrainToken;
import antgame.model.World;

/**
 *
 * @author ItsTheRai
 */
public interface Direction {
    public abstract TerrainToken getTileInDirection(World world, Position position,int direction);
}
