package antgame.ant.color;

import antgame.ant.instructions.InstructionSet;
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
    public InstructionSet[] getBrain(GameFile f) {
        return f.getRedBrain();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ColorRed;
    }

    @Override
    public int hashCode() {
        int hashCode = 32412;
        return hashCode;
    }
}
