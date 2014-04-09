package antgame.world.requirements;

import antgame.model.World;
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

    /**
     *
     * @param numberOfAntHills Number of ant hills
     * @param numberOfRocks Number of RockToken objects
     * @param numberOfFoodBlobs Number of food blobs
     * @param foodBlobSize Size of food blob
     * @param foodInParticle Number of Food objects in a food particle
     */
    public RequirementNumberOfResourses(int numberOfAntHills, int numberOfRocks, int numberOfFoodBlobs, int foodBlobSize, int foodInParticle) {
        this.numberOfAntHills = numberOfAntHills;
        this.numberOfRocks = numberOfRocks;
        this.numberOfFoodBlobs = numberOfFoodBlobs;
        this.foodBlobSize = foodBlobSize;
        this.foodInParticle = foodInParticle;
    }
    
    @Override
    public boolean checkRequirements(World world){
        return true;
        //TODO implement this method
    }
}

