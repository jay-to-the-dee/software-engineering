package antgame.instructions;

import antgame.ant.direction.turndirection.LeftOrRight;
import antgame.model.Ant;

/**
 *
 * @author ItsTheRai
 */
public class InstructionTurn extends InstructionSet implements Instruction{
    private LeftOrRight lor;

    @Override
    public void executeInstruction(Ant ant) {
            ant.setDirection(lor.turn(ant.getDirection()));
    }
}