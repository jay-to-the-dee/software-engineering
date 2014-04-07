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