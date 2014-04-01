/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antgame.ant.direction;

import antgame.model.TerrainToken;
import antgame.model.World;

/**
 *
 * @author Main User
 */
public class Ahead implements Direction{

    public String getTileInDirection(World world) {
        return null;
        
    }

    @Override
    public TerrainToken getTileInDirection(World world, int position) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
