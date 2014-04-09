/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antgame.world.requirements;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ItsTheRai
 */
public class TournamentRequirements {
    private final List<CheckRequirement> requirements;

    /**
     * Use this to verify world for tournaments
     */
    public TournamentRequirements() {
        //initialise all tournament requirements
        requirements = new ArrayList<>();
        requirements.add(new RequirementAnthills(2,5));
        requirements.add(new RequirementBorder(1));
        requirements.add(new RequirementDimension(150,150));
        requirements.add(new RequirementNumberOfResourses(2,14,11,5,5));
    }

    public List<CheckRequirement> getRequirements() {
        return requirements;
    }
    
    
    
}
