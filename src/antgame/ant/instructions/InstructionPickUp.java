package antgame.ant.instructions;

import antgame.model.Ant;

/**
 *
 * @author ItsTheRai
 */
public class InstructionPickUp extends InstructionSet implements Instruction{
    private final int state1;
    private final int state2;

    /**
     *
     * @param state1 the state used if execution of instruction is possible
     * @param state2 the state used if execution of instruction is not possible
     */
    public InstructionPickUp(int state1, int state2) {
        this.state1 = state1;
        this.state2 = state2;
    }
    
    /**
     *
     * @param ant
     */
    @Override
    public void executeInstruction(Ant ant){
        if (ant.isHasFood()||!ant.getAntLocation().hasFood()){
            ant.setState(state2);
        }
        else {
            ant.getAntLocation().remove1food();
            ant.setHasFood(true);
            ant.setState(state1);
        }
    }
}
