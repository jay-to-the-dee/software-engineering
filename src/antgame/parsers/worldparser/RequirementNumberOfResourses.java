/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antgame.parsers.worldparser;

import java.util.List;

/**
 *
 * @author Main User
 */
public class RequirementNumberOfResourses implements CheckRequirement{

    private static  int numberOfAntHills = 2;
    private static int numberOfRocks = 14;
    private static int numberOfFoodBlobs = 11;
    private static int foodBlobSize = 5;
    private static int foodInParticle = 5;
    
    
    @Override
    public boolean checkRequirements(int xsize, int ysize, List<WorldToken> tokens) throws SomeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
