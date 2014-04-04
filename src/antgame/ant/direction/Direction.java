/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antgame.ant.direction;

import antgame.model.AntPosition;
import antgame.model.Position;
import antgame.model.TerrainToken;
import antgame.model.World;

/**
 *
 * @author Main User
 */
public interface Direction {
    public abstract TerrainToken getTileInDirection(World world, Position position,int direction);
}
