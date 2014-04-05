package antgame.parsers.worldparser;

import antgame.parsers.exceptions.TokenSizeMismatchException;
import antgame.parsers.exceptions.SymbolNotFoundException;
import antgame.parsers.exceptions.SomeException;
import antgame.world.worldTokens.Token;
import java.util.List;

/**
 *
 * @author ItsTheRai
 */
public interface Parser {
    public List<Token> parse (String input) throws SomeException, SymbolNotFoundException,TokenSizeMismatchException;
}
