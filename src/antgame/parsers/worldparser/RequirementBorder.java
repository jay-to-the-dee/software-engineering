/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antgame.parsers.worldparser;

import antgame.world.tokens.RockToken;
import antgame.model.TerrainToken;
import java.util.List;

/**
 *
 * @author Main User
 */
public class RequirementBorder implements CheckRequirement{
    private static Token borderToken = new RockToken();
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