package antgame.ant.instructions;

import antgame.ant.direction.turndirection.LeftOrRight;
import antgame.model.Ant;

/**
 *
 * @author ItsTheRai
 */
public class InstructionTurn extends InstructionSet implements Instruction{
    private LeftOrRight lor;
    private int nextState;
    
    /**
     *
     * @param lor Represents the direction to be turned to
     * @param state The next state the ant has to take after turning
     */
    public InstructionTurn(LeftOrRight lor, int state){
        this.lor = lor;
        this.nextState = state;
    }

    @Override
    public void executeInstruction(Ant ant) {
            ant.setDirection(lor.turn(ant.getDirection()));
            ant.setState(this.nextState);
    }
}