/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antgame.ant.direction.turndirection;

import antgame.ant.direction.sensedireciton.Direction;

/**
 *
 * @author ItsTheRai
 */
public class Left implements LeftOrRight{

    @Override
    public int turn(int dir) {
        return (dir+6-1)%6;
    }
    
}
