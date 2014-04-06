package antgame.world.requirements;

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
    public boolean checkRequirements(int xsize, int ysize, List<WorldToken> tokens){
        boolean match = true;
        int i =0;
        while(match && i<xsize*ysize){
            if(true){
                if(!(tokens.get(i)  instanceof TerrainToken)||tokens.get(i) instanceof TerrainToken &&!((TerrainToken)tokens.get(i)).isRocky()){
                    //throw new SomeException();
                }
            }
            i++;
        }
        return match;
    }
}