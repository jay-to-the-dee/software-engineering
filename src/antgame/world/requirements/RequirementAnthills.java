package antgame.world.requirements;

import antgame.world.worldTokens.TerrainToken;
import antgame.parsers.exceptions.SomeException;
import antgame.world.worldTokens.WorldToken;
import java.util.List;

/**
 *
 * @author ItsTheRai
 */
public class RequirementAnthills implements CheckRequirement{

    private static int numberOfAnthills = 2;
    private static int anthillSideLength = 7;
    
    
    public RequirementAnthills(int numberOfAnthills,int anthillSideLength) {
        this.numberOfAnthills = numberOfAnthills;
        this.anthillSideLength = anthillSideLength;
    }
    @Override
    public boolean checkRequirements(int xsize, int ysize, List<WorldToken> tokens) throws SomeException {
        boolean match = true;
        int i =0;
        while(match && i<xsize*ysize){
            if(true){
                if(!(tokens.get(i)  instanceof TerrainToken)||tokens.get(i) instanceof TerrainToken &&!((TerrainToken)tokens.get(i)).isRocky()){
                    throw new SomeException();
                }
            }
            i++;
        }
        return match;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}