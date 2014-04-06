package antgame.ant.color;

import antgame.ant.instructions.Instruction;
import mainPackage.GameFile;

/**
 *
 * @author ItsTheRai
 */
public class ColorBlack implements Color{
    public ColorBlack(){
    }

    @Override
    public Color otherColor() {
        return new ColorRed();
    }

    @Override
    public Instruction[] getBrain(GameFile f) {
        return f.getBlackBrain();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ColorBlack){
        return true; //To change body of generated methods, choose Tools | Templates.
    }
        else return false;
    }

    @Override
    public int hashCode() {
        int hashCode = 32432;
        return hashCode; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
