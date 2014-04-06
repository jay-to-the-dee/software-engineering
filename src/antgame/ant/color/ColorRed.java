package antgame.ant.color;

import antgame.ant.instructions.Instruction;
import mainPackage.GameFile;

/**
 *
 * @author ItsTheRai
 */
public class ColorRed implements Color{

    public ColorRed() {
    }
    
    @Override
    public Color otherColor() {
        return new ColorBlack();
    }

    @Override
    public Instruction[] getBrain(GameFile f) {
        return f.getRedBrain();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ColorRed){
        return true; //To change body of generated methods, choose Tools | Templates.
    }
        else return false;    
    }

    @Override
    public int hashCode() {
        int hashCode = 32412;
        return hashCode; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
