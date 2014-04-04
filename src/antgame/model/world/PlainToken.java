/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antgame.model.world;

import antgame.model.Position;
import antgame.model.TerrainToken;
import java.util.Stack;

/**
 *
 * @author Main User
 */
public class PlainToken extends TerrainToken{
    public PlainToken(Position position,Stack food){
        super(false,position,food,false,null);
    }
}