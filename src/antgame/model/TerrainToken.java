package antgame.model;

import antgame.ant.conditions.checkCondition;
import antgame.parsers.worldparser.GetType;
import antgame.parsers.worldparser.WorldToken;
import java.util.concurrent.locks.Condition;

/**
 *
 * @author Main User
 */
public class TerrainToken extends WorldToken implements GetType{
    private int antNumber;
    private final boolean rocky;
    private boolean ant;
    private boolean food;
    public TerrainToken (boolean predicate){
        rocky=predicate;
    }
        public void getType() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean isRocky() {
        return rocky;
    }

    private boolean hasAnt(){
        if(antNumber>=0){
            return true;
        }
        else return false;
    }
    public int getAnt(){
            return antNumber;
    }

    public void putAnt(int antNumber) {
        this.antNumber = antNumber;
    }

    public boolean hasFood() {
        return food;
    }
}
