/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package antgame.parsers.worldparser;

/**
 *
 * @author rg293
 */
public class ParseAndValidate {
    Parser p = new ParserImp();
    Verifier v = new VerifierImp();
    public World parseAndValidate(String input,WorldRequirements req)throws SomeException, SymbolNotFoundException{
        return v.verify(p.parse(input), req); 
    }
}
