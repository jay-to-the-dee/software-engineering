package antgame.world.requirements;

import antgame.model.World;
import antgame.world.worldTokens.WorldToken;
import java.util.List;

/**
 *
 * @author ItsTheRai
 */

public class RequirementDimension implements CheckRequirement{
    private int xsize;
    private int ysize;

    /**
     *
     * @param xsize width of the world
     * @param ysize height of the world
     */
    public RequirementDimension(int xsize,int ysize){
        this.xsize=xsize;
        this.ysize=ysize;
    }

    @Override
    public boolean checkRequirements(World world){
        if (this.xsize!=xsize ||this.ysize!=ysize){
            System.out.println("validation error");
            return false;
        }
        return true;
        
    }
}