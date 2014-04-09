package antgame.parsers.worldparser;

import antgame.world.requirements.CheckRequirement;
import antgame.model.World;
import java.util.List;

/**
 *
 * @author ItsTheRai
 */
public interface Verifier {

    /**
     *
     * @param world a World file
     * @param requirements a List of Requirements 
     * @return world if matches requirements, throws exception otherwise
     * @throws Exception default exception
     */
    public World verify(World world,List<CheckRequirement> requirements)throws Exception;
}
