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
}
