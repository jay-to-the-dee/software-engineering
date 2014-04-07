package antgame.parsers.antbrainparser;

import antgame.ant.instructions.InstructionSet;

/**
 *
 * @author ItsTheRai
 */
public interface AntBrainParser {
    public InstructionSet[] parseAntBrain(String input);
}
