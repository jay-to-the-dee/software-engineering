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
        List<WorldToken> tokens = p.parse(input);
        int xsize= ((MapSizeToken) tokens.get(0)).getSize();
        int ysize = ((MapSizeToken)tokens.get(1)).getSize();
        List<WorldToken>list = new LinkedList<>();
        for (int i=2;i<tokens.size();i++){
            list.add((WorldToken)tokens.get(i));
        }
        v.verify(xsize, ysize, list, req);
        //sucess, so create world
        return new World(xsize,ysize,list);
    }
}