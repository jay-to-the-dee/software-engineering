package antgame.ant.instructions;

import antgame.ant.markers.Marker;
import antgame.model.Ant;

/**
 *
 * @author ItsTheRai
 */
public class InstructionMark extends InstructionSet implements Instruction{
    private final Marker marker;
    private final int nextState;
    
    /**
     *
     * @param marker the Marker object used by the ant to mark a TerrainToken
     * @param state the next state the ant has to take
     */
    public InstructionMark(Marker marker, int state){
        this.marker = marker;
        nextState = state;
    }
    
    public void executeInstruction(Ant ant){
        marker.mark(ant.getAntLocation(),ant.getColour());
        ant.setState(nextState);
    }
}