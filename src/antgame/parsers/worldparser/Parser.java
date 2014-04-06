package antgame.parsers.worldparser;

import antgame.model.World;
import antgame.parsers.exceptions.ColumnNumberException;
import antgame.parsers.exceptions.RowDoesntStartWithWhitespaceException;
import antgame.parsers.exceptions.RowNumberException;
import antgame.world.worldTokens.WorldToken;
import java.util.List;

/**
 *
 * @author ItsTheRai
 */
public interface Parser {
    public World parse (String input) throws RowNumberException, RowDoesntStartWithWhitespaceException, ColumnNumberException;
}
