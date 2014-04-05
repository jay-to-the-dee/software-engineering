package antgame.world.requirements;

import antgame.parsers.exceptions.SomeException;
import antgame.parsers.worldparser.WorldToken;
import java.util.List;

/**
 *
 * @author ItsTheRai
 */
public class RequirementDimension implements CheckRequirement{
    private int xsize;
    private int ysize;
    public RequirementDimension(int xsize,int ysize){
        this.xsize=xsize;
        this.ysize=ysize;
    }

    /**
     *
     * @param xsize
     * @param ysize
     * @param tokens
     * @return
     */
    @Override
    public boolean checkRequirements(int xsize,int ysize,List<WorldToken> tokens) throws SomeException{
        if (this.xsize!=xsize ||this.ysize!=ysize){
            System.out.println("validation error");
            return false;
        }
        return true;
        
    }
}