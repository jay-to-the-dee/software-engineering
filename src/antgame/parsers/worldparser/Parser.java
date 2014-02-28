package antgame.parsers.worldparser;

import java.util.List;

/**
 *
 * @author Main User
 */
public interface Parser {
    public List<Token> parse (String input) throws SomeException, SymbolNotFoundException;
}
