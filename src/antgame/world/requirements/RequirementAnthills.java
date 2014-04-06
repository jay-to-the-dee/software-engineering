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
    
    
    public RequirementAnthills(int numberOfAnthills,int anthillSideLength) {
        this.numberOfAnthills = numberOfAnthills;
        this.anthillSideLength = anthillSideLength;
    }
    @Override
    public boolean checkRequirements(World world){
        boolean match = true;
        int i =0;
        while(match && i<world.getWorldTokens().size()){
            if(true){
                if(!(world.getWorldTokens().get(i)  instanceof TerrainToken)||world.getWorldTokens().get(i) instanceof TerrainToken &&!((TerrainToken)world.getWorldTokens().get(i)).isRocky()){
                    //throw new SomeException();
                }
            }
            i++;
        }
        return match;
    }
}