package antgame.world.requirements;

import antgame.model.World;
import antgame.world.worldTokens.TerrainToken;
import antgame.world.worldTokens.WorldToken;
import java.util.List;

/**
 *
 * @author ItsTheRai
 */
public class RequirementAnthills implements CheckRequirement{

    private static int numberOfAnthills;
    private static int anthillSideLength;
    
    /**
     *
     * @param numberOfAnthills Number of ant hills in the world
     * @param anthillSideLength number of AntHll tokens forming a side of an anthill
     */
    public RequirementAnthills(int numberOfAnthills,int anthillSideLength) {
        this.numberOfAnthills = numberOfAnthills;
        this.anthillSideLength = anthillSideLength;
    }
    @Override
    public boolean checkRequirements(World world){
        boolean match = true;
        int i =0;
        while(match && i<world.getWorldTokens().length){
            if(true){
                if(!(world.getWorldTokens()[i]  instanceof TerrainToken)||world.getWorldTokens()[i] instanceof TerrainToken &&!((TerrainToken)world.getWorldTokens()[i]).isRocky()){
                    //TODO implement requrement checker
                }
            }
            i++;
        }
        return match;
    }
}