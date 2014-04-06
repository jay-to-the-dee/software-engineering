package antgame.parsers.worldparser;

import antgame.world.requirements.CheckRequirement;
import antgame.model.World;
import java.util.List;

/**
 *
 * @author ItsTheRai
 */
public interface Verifier {
    public World verify(World world,List<CheckRequirement> requirements)throws Exception;
}
