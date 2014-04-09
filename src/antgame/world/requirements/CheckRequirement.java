package antgame.world.requirements;

import antgame.model.World;
import antgame.world.worldTokens.WorldToken;
import java.util.List;

/**
 *
 * @author ItsTheRai
 */
public interface CheckRequirement {
    
    /**
     *
     * @param world a World object
     * @return true if world meets requirement, false otherwise
     */
    public abstract boolean checkRequirements(World world);
}