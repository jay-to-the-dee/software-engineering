package antgame.world.tokens;

import antgame.model.TerrainToken;
import antgame.parsers.worldparser.GetType;

/**
 *
 * @author Main User
 */
public class RockToken extends TerrainToken implements GetType{

    public RockToken(){
        super(true);
    }
    @Override
    public void getType() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
