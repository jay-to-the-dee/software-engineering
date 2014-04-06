package antgame.parsers.worldparser;

import antgame.world.worldTokens.WorldToken;
import antgame.world.worldTokens.MapSizeToken;
import antgame.world.worldTokens.Token;
import antgame.world.requirements.CheckRequirement;
import antgame.model.World;
import antgame.parsers.exceptions.ColumnNumberException;
import antgame.parsers.exceptions.RowDoesntStartWithWhitespaceException;
import antgame.parsers.exceptions.RowNumberException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ItsTheRai
 */
public class ParseAndValidate {
    Parser p = new ParserImp();
    Verifier v = new VerifierImp();
    
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