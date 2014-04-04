package antgame.instructions;

import antgame.ant.markers.Marker;
import antgame.model.Ant;

/**
 *
 * @author ItsTheRai
 */
public class InstructionMark {
    private final Marker marker;
    private final int nextState;
    
    public InstructionMark(Marker marker, int state){
        this.marker = marker;
        nextState = state;
    }
    
    public void executeInstruction(Ant ant){
        marker.mark(ant.getAntLocation(),ant.getColour());
        ant.setState(nextState);
    }
}