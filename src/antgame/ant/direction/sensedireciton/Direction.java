package antgame.ant.direction.sensedireciton;

import antgame.model.Position;
import antgame.world.worldTokens.TerrainToken;
import antgame.world.worldTokens.World;

/**
 *
 * @author ItsTheRai
 */
public interface Direction {
    public abstract TerrainToken getTileInDirection(World world, Position position,int direction);
}
