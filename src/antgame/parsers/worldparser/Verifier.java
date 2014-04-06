package antgame.parsers.worldparser;

import antgame.world.worldTokens.WorldToken;
import antgame.world.requirements.CheckRequirement;
import antgame.model.World;
import java.util.List;

/**
 *
 * @author ItsTheRai
 */
public interface Verifier {
    public World verify(int xsize,int ysize,List<WorldToken> world,List<CheckRequirement> requirements)throws Exception;
}
