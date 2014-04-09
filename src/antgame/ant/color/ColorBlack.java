package antgame.ant.color;

import antgame.ant.instructions.InstructionSet;
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
    public InstructionSet[] getBrain(GameFile f) {
        return f.getBlackBrain();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ColorBlack;
    }

    @Override
    public int hashCode() {
        int hashCode = 32432;
        return hashCode;
    }
    
    
}
