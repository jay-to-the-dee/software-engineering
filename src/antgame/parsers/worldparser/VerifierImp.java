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

    /**
     *
     * @param world World object
     * @param requirements List of Requirements
     * @return return a world object if verified
     * @throws Exception could not verify world
     */
    @Override
    public World verify(World world,List<CheckRequirement> requirements) throws Exception{
        for(CheckRequirement req:requirements){
            try {
                req.checkRequirements(world);
            } catch (Exception ex) {
                System.out.println("verifier error");
            }
        }
        return world;//new World();//xsize,ysize,l)
        //else trow exception
    }
}
