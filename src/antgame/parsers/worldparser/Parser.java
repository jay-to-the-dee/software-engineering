package antgame.parsers.worldparser;

import antgame.parsers.exceptions.SomeException;
import antgame.parsers.exceptions.SymbolNotFoundException;
import antgame.parsers.exceptions.TokenSizeMismatchException;
import antgame.world.worldTokens.WorldToken;
import java.util.List;

/**
 *
 * @author ItsTheRai
 */
public interface Parser {
    public List<WorldToken> parse (String input) throws SomeException, SymbolNotFoundException,TokenSizeMismatchException;
}
