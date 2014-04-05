package antgame.instructions;

import antgame.ant.direction.turndirection.LeftOrRight;
import antgame.model.Ant;

/**
 *
 * @author ItsTheRai
 */
public class InstructionTurn extends InstructionSet implements Instruction{
    private LeftOrRight lor;
    private int state;
    
    public InstructionTurn(LeftOrRight lor, int state){
        this.lor = lor;
        this.state = state;
    }

    @Override
    public void executeInstruction(Ant ant) {
            ant.setDirection(lor.turn(ant.getDirection()));
    }
}