package antgame.world.requirements;

import antgame.model.World;
import antgame.world.worldTokens.RockToken;
import antgame.world.worldTokens.TerrainToken;

/**
 *
 * @author ItsTheRai
 */
public class RequirementBorder implements CheckRequirement{
    private static TerrainToken borderToken = new RockToken(null);
    private static int borderSize;

    
    public RequirementBorder(int borderSize){
        this.borderSize = borderSize;
    }
    @Override
    public boolean checkRequirements(World world){
        boolean match = true;
        int i =0;
        while(match && i<world.getWorldTokens().length){
            if(     //check left column  
                    i%world.getWidth()<borderSize
                    //check right column
                    ||i%world.getWidth()>world.getWidth()-borderSize - 1
                    //check top row
                    ||i/world.getWidth()<borderSize
                    //check bottom row
                    ||i/world.getWidth()>world.getWidth()-borderSize - 1
                    ){
                if(!(world.getWorldTokens()[i]  instanceof RockToken)||world.getWorldTokens()[i] instanceof TerrainToken &&!((TerrainToken)world.getWorldTokens()[i]).isRocky()){
                    return false;
                }
            }
            i++;
        }
        return match;
    }
}