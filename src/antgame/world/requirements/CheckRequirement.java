package antgame.world.requirements;

import antgame.world.worldTokens.WorldToken;
import java.util.List;

/**
 *
 * @author ItsTheRai
 */
public interface CheckRequirement {
    
    public abstract boolean checkRequirements(int xsize,int ysize,List<WorldToken> tokens);
}
