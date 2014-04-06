package mainPackage;


import antgame.ant.instructions.Instruction;
import antgame.parsers.antbrainparser.AntBrainParser;
import antgame.parsers.antbrainparser.AntBrainParserImp;


/**
 *
 * @author ItsTheRai
 */
public class AntBrainFactory {
    
    public AntBrainFactory(){
        
    }
    
    public static Instruction[] generateAntBrainFromString(String input){
        AntBrainParser parser = new AntBrainParserImp();
        return parser.parseAntBrain(input);
    }
}