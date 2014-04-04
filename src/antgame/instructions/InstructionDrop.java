package antgame.instructions;

import antgame.model.Ant;

/**
 *
 * @author ItsTheRai
 */
public class InstructionDrop extends InstructionSet implements Instruction{
    private final int nextState;
    
    public InstructionDrop(int state){
        nextState = state;
    }
    
    @Override
    public void executeInstruction(Ant ant) {
        if(ant.isHasFood()){
            ant.getAntLocation().drop1food();
            ant.setHasFood(false);
        }
        ant.setState(nextState);
    }
}
