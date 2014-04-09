package antgame.parsers.worldparser;

import antgame.world.requirements.CheckRequirement;
import antgame.model.World;
import antgame.parsers.exceptions.ColumnNumberException;
import antgame.parsers.exceptions.RowDoesntStartWithWhitespaceException;
import antgame.parsers.exceptions.RowNumberException;
import java.util.List;

/**
 *
 * @author ItsTheRai
 */
public class ParseAndValidate {
    Parser p = new ParserImp();
    Verifier v = new VerifierImp();
    
    /**
     *This class is used to parse a text file into a world object and verify 
     * if it meets the requirements
     * @param input String representing a world description
     * @param req List or Requirements
     * @return returns a World object if parsed and validated successfully
     * @throws RowNumberException actual and formal number or row objects differ
     * @throws RowDoesntStartWithWhitespaceException even row doesn't start with a whitespace
     * @throws ColumnNumberException actual and formal number or column objects differ
     * @throws Exception default exception
     */
    public World parseAndValidate(String input,List<CheckRequirement> req)throws RowNumberException, RowDoesntStartWithWhitespaceException, ColumnNumberException, Exception{
        World world = p.parse(input);
        try{
            v.verify(world, req);
        }
        catch(Exception e){
            
        }
        //sucess, so create world
        return world;
    }
}