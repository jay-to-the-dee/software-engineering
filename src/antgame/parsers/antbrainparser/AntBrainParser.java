package antgame.parsers.antbrainparser;

import antgame.ant.instructions.InstructionSet;

/**
 *
 * @author ItsTheRai
 */
public interface AntBrainParser {

    /**
     *
     * @param input A string representing an ant brain
     * @return returns a array of Instructions
     */
    public InstructionSet[] parseAntBrain(String input);
}
