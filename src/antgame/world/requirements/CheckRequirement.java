package antgame.world.requirements;

import antgame.model.World;
import antgame.world.worldTokens.WorldToken;
import java.util.List;

/**
 *
 * @author ItsTheRai
 */
public interface CheckRequirement {
    
    public abstract boolean checkRequirements(World world);
}