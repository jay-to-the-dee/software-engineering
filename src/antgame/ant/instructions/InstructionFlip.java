package antgame.ant.instructions;

import antgame.model.Ant;
import mainPackage.Randomint;

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
        Randomint r = new Randomint();
        //TODO not sure this is right
        if(r.getRandomInt(n)==0){
            ant.setState(state1);
        }
        else ant.setState(state2);
        //TODO
    }
    
    
    
}
