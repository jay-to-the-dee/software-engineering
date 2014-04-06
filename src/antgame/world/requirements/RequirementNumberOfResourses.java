package antgame.world.requirements;

import antgame.world.worldTokens.WorldToken;
import java.util.List;

/**
 *
 * @author ItsTheRai
 */
public class RequirementNumberOfResourses implements CheckRequirement{

    private  int numberOfAntHills;// = 2;
    private int numberOfRocks;// = 14;
    private int numberOfFoodBlobs;// = 11;
    private int foodBlobSize;// = 5;
    private int foodInParticle;// = 5;

    public RequirementNumberOfResourses(int numberOfAntHills, int numberOfRocks, int numberOfFoodBlobs, int foodBlobSize, int foodInParticle) {
        this.numberOfAntHills = numberOfAntHills;
        this.numberOfRocks = numberOfRocks;
        this.numberOfFoodBlobs = numberOfFoodBlobs;
        this.foodBlobSize = foodBlobSize;
        this.foodInParticle = foodInParticle;
    }

  
   
    
    
    @Override
    public boolean checkRequirements(int xsize, int ysize, List<WorldToken> tokens){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
