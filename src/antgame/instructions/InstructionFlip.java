package antgame.instructions;

import antgame.model.Ant;

/**
 *
 * @author ItsTheRai
 */
public class InstructionFlip extends InstructionSet implements Instruction{
    private int state1;
    private int state2;
    private int n;

    public InstructionFlip(int state1, int state2, int n) {
        this.state1 = state1;
        this.state2 = state2;
        this.n = n;
    }

    @Override
    public void executeInstruction(Ant ant) {
        //TODO
    }
    
    
    
}
