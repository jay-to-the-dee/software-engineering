package antgame.model;

import antgame.parsers.worldparser.WorldToken;
import antgame.parsers.worldparser.GetType;

/**
 *
 * @author Main User
 */
public class TerrainToken extends WorldToken implements GetType{
    private /*final???*/ boolean rocky;
    private boolean ant;
    public TerrainToken (){
        rocky=false;
    }
        public void getType() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean isRocky() {
        return rocky;
    }

    public boolean isAnt() {
        return ant;
    }

    public void setRocky() {
        rocky=true;
    }

    public void setAnt(boolean ant) {
        this.ant = ant;
    }
    
    
}
