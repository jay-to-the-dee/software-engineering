/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antgame.ant.direction.turndirection;

import antgame.ant.direction.Direction;

/**
 *
 * @author Main User
 */
public class Right implements LeftOrRight{

    @Override
    public int turn(int dir) {
        return (dir+1)%6;
    }
    
}
