package antgame.world.worldTokens;

import antgame.parsers.worldparser.WorldToken;

/**
 *
 * @author ItsTheRai
 */
public class MapSizeToken extends WorldToken{
    private String size;
    public MapSizeToken(String size){
        this.size = size;
    }
        public void getType() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        public int getSizeAsInt(){
            return Integer.parseInt(size);
        }
    
}
