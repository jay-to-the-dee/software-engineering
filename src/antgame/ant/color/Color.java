package antgame.ant.color;

import antgame.ant.instructions.InstructionSet;
import mainPackage.GameFile;

/**
 *
 * @author ItsTheRai
 */
public interface Color {

    /**
     *
     * @return Returns the Color object of the oposite color
     */
    public Color otherColor();

    /**
     *
     * @param f GameFile object that contains all ant brains
     * @return Returns ant brain with the specified color
     */
    public InstructionSet[] getBrain(GameFile f);

    @Override
    public boolean equals(Object obj);
    
    @Override
    public int hashCode();
    
}
