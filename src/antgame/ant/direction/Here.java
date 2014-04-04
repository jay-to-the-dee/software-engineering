/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antgame.ant.direction;

import antgame.model.Position;
import antgame.model.TerrainToken;
import antgame.model.World;

/**
 *
 * @author Main User
 */
public class Here implements Direction{

    @Override
    public TerrainToken getTileInDirection(World world, Position position,int direction) {
        return (TerrainToken)world.getTokenAt(position.getXlocation(), position.getYlocation());
    }


    
}
