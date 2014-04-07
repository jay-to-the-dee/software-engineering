package antgame.ant.instructions;

import antgame.ant.direction.sensedireciton.Ahead;
import antgame.model.Ant;
import antgame.world.worldTokens.TerrainToken;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ItsTheRai
 */
public class InstructionMove extends InstructionSet implements Instruction{
    private final int state1;
    private final int state2;
    private final int RESTING = 14;

    public InstructionMove(int state1, int state2) {
        this.state1 = state1;
        this.state2 = state2;
    }

    @Override
    public void executeInstruction(Ant ant){
        
                TerrainToken t = ant.senseTile(new Ahead());
                if(t.isRocky()||t.getAnt()!=null){
                    ant.setState(state2);
                }
                else{
                    try {
                        t.putAnt(ant);
                    } catch (Exception ex) {
                        Logger.getLogger(InstructionMove.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    ant.getAntLocation().removeAnt();
                    ant.setPosition(ant.senseTile(new Ahead()).getPosition().getXlocation()
                                   ,ant.senseTile(new Ahead()).getPosition().getYlocation());
                    ant.setResting(RESTING);
                    // not sure wether to use terraint token of position
                    ant.checkForSurroundedAnts(t.getPosition());
                
                }
    }
}
