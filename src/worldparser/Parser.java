/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package worldparser;

import java.util.List;

/**
 *
 * @author Main User
 */
public interface Parser {
    public List<Token> parse (String input) throws SomeException;
}
