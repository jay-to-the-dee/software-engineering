package antgame.parsers.worldparser;

import antgame.model.World;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author rg293
 */
public class ParseAndValidate {
    Parser p = new ParserImp();
    Verifier v = new VerifierImp();
    
    public World parseAndValidate(String input,List<CheckRequirement> req)throws SomeException, SymbolNotFoundException, TokenSizeMismatchException{
        List<Token> tokens = p.parse(input);
        int xsize= ((MapSizeToken) tokens.get(0)).getSizeAsInt();
        int ysize = ((MapSizeToken)tokens.get(1)).getSizeAsInt();
        List<WorldToken>list = new LinkedList<>();
        for (int i=2;i<tokens.size();i++){
            list.add((WorldToken)tokens.get(i));
        }
        v.verify(xsize, ysize, list, req);
        //sucess, so create world
        return new World(xsize,ysize,list);
    }
}