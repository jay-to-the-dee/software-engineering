package antgame.parsers.worldparser;

import antgame.model.World;
import antgame.parsers.exceptions.ColumnNumberException;
import antgame.parsers.exceptions.RowDoesntStartWithWhitespaceException;
import antgame.parsers.exceptions.RowNumberException;

/**
 *
 * @author ItsTheRai
 */
public interface Parser {

    /**
     *
     * @param input A String representing an ant world
     * @return A World object parsed from the input string
     * @throws RowNumberException Stated row size differs from actual
     * @throws RowDoesntStartWithWhitespaceException Every odd row has to start with a whitespace
     * @throws ColumnNumberException Stated column size differs from actual
     */
    public World parse (String input) throws RowNumberException, RowDoesntStartWithWhitespaceException, ColumnNumberException;
}
