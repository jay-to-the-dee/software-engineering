package antgame.ant.instructions;

import antgame.ant.markers.Marker;
import antgame.model.Ant;

/**
 *
 * @author ItsTheRai
 */
public class InstructionUnmark implements Instruction{
    private final Marker marker;
    private final int nextState;
    
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
