package antgame.parsers.worldparser;

import antgame.world.worldTokens.WorldToken;
import antgame.world.requirements.CheckRequirement;
import antgame.model.World;
import java.util.List;

/**
 *
 * @author ItsTheRai
 */
public class VerifierImp implements Verifier{

    @Override
    public World verify(World world,List<CheckRequirement> requirements) throws Exception{
        
        //if success 
        //make sure this always works
        //int xsize = ((MapSizeToken)world.get(0)).getSize();
        //int ysize = ((MapSizeToken)world.get(1)).getSize();
        //////////////////////////////
        for(CheckRequirement req:requirements){
            try {
                req.checkRequirements(world);
            } catch (Exception ex) {
                System.out.println("verifier error");
            }
        }
        return null;//new World();//xsize,ysize,l);
        //else trow exception
    }
}
