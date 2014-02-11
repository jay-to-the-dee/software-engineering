/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package worldparser;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Main User
 */
public class ParserImp implements Parser{
    List<Token> world = new ArrayList<>();
    public List<Token> parse(String input) throws SomeException{
        
        //clean up
        List<Token> returnTokens = world;
        world.clear();
        return returnTokens;
}
}
