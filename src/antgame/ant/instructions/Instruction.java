package antgame.ant.instructions;

import antgame.model.Ant;

/**
 *
 * @author ItsTheRai
 */
public interface Instruction {

    /**
     * this method Read the instruction from the ants brain, executes it, updates 
     * the state of the ant and the world if needed
     * @param ant the Ant object whose state is to be changed and whose instruction is 
     * //to be executed
     */
    public void executeInstruction(Ant ant);
}
