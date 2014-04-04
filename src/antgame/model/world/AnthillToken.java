/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package antgame.model.world;

import antgame.model.world.Color;
import antgame.model.Position;
import antgame.model.TerrainToken;
import java.util.Stack;

/**
 *
 * @author Main User
 */
public class AnthillToken extends TerrainToken{

    public AnthillToken(Position p,Color color){
        //not sure if need food stack for anthill
        
        super(false,p,new Stack(),true,color);
    }
        public void getType() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
