package antgame.ant.instructions;

import antgame.ant.markers.Marker;
import antgame.model.Ant;

/**
 *
 * @author ItsTheRai
 */
public class InstructionUnmark extends InstructionSet implements Instruction{
    private final Marker marker;
    private final int nextState;
    
    /**
     *
     * @param marker A Marker to be unmarked
     * @param state The next state the ant has to take after un-marking
     */
    public InstructionUnmark(Marker marker, int state){
        this.marker = marker;
        nextState = state;
    }
    
    @Override
    public void executeInstruction(Ant ant){
        marker.unmark(ant.getAntLocation(),ant.getColour());
        ant.setState(nextState);
    }
}
