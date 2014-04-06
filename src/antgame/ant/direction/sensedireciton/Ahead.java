package antgame.ant.direction.sensedireciton;

import antgame.model.Position;
import antgame.world.worldTokens.TerrainToken;
import antgame.model.World;

/**
 *
 * @author ItsTheRai
 */
public class Ahead implements Direction{

    @Override
    public TerrainToken getTileInDirection(World world, Position position,int direction) {
        return world.getAdjacentCell(direction, position);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}