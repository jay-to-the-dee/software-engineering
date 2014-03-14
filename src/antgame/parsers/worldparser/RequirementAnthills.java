/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antgame.parsers.worldparser;

import antgame.model.TerrainToken;
import java.util.List;

/**
 *
 * @author Main User
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