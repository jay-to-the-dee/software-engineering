package antgame.ant.direction.sensedireciton;

import antgame.model.Position;
import antgame.world.worldTokens.TerrainToken;
import antgame.model.World;

/**
 *
 * @author ItsTheRai
 */
public interface Direction {

    /**
     *
     * @param world The World object currently in use
     * @param position The position of the ant in the world
     * @param direction the direction the nearest tile should be sensed in
     * @return returns a TerrainToken object in the direction sensed
     */
    public abstract TerrainToken getTileInDirection(World world, Position position,int direction);
}
