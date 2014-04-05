package antgame.world.requirements;

import antgame.parsers.exceptions.SomeException;
import antgame.parsers.worldparser.WorldToken;
import java.util.List;

/**
 *
 * @author ItsTheRai
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
