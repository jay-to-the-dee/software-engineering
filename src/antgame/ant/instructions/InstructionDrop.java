package antgame.ant.instructions;

import antgame.ant.color.ColorRed;
import antgame.model.Ant;

/**
 *
 * @author ItsTheRai
 */
public class InstructionDrop extends InstructionSet implements Instruction{
    private final int nextState;
    
    /**
     *
     * @param state the next state the ant should be put in
     */
    public InstructionDrop(int state){
        nextState =0;
                //= state;
    }
    
    @Override
    public void executeInstruction(Ant ant) {
        if(ant.isHasFood()){
            if(ant.getAntLocation().isAnthill()){
                //if(ant.getColour() instanceof ColorRed){
                //    if(ant.getAntLocation().getAnthillColor() instanceof ColorRed){
                //    ant.getAntLocation().fetchFood(new ColorRed());
                //    ant.setHasFood(false);
                //}
                
                //does not appear to be working
                if(ant.getColour().equals(ant.getAntLocation().getAnthillColor())){
                    ant.getAntLocation().fetchFood(ant.getColour());
                    ant.setHasFood(false);
                }
            }
            else{
            ant.getAntLocation().drop1food();
            ant.setHasFood(false);
            }
        }
        ant.setState(nextState);
    }
}
