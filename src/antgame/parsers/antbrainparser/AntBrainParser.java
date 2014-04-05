package antgame.parsers.antbrainparser;

import antgame.instructions.Instruction;

/**
 *
 * @author ItsTheRai
 */
public interface AntBrainParser {
    public Instruction[] parseAntBrain(String input);
}
