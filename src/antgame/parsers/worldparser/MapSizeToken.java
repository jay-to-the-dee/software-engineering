package antgame.parsers.worldparser;

/**
 *
 * @author Main User
 */
public class MapSizeToken extends Token{
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
