package antgame.world.requirements;

import antgame.world.worldTokens.RockToken;
import antgame.world.worldTokens.TerrainToken;
import antgame.parsers.exceptions.SomeException;
import antgame.world.worldTokens.Token;
import antgame.world.worldTokens.WorldToken;
import java.util.List;

/**
 *
 * @author ItsTheRai
 */
public class RequirementBorder implements CheckRequirement{
    private static Token borderToken = new RockToken(null);
    private static int borderSize=1;

    
    public RequirementBorder(int borderSize){
        this.borderSize = borderSize;
    }
    @Override
    public boolean checkRequirements(int xsize, int ysize, List<WorldToken> tokens) throws SomeException {
        boolean match = true;
        int i =0;
        while(match && i<xsize*ysize){
            if(i/xsize<borderSize||i/xsize>ysize-borderSize||i%xsize<borderSize||i%xsize>xsize-borderSize){
                if(!(tokens.get(i)  instanceof TerrainToken)||tokens.get(i) instanceof TerrainToken &&!((TerrainToken)tokens.get(i)).isRocky()){
                    throw new SomeException();
                }
            }
            i++;
        }
        return match;
    }
}