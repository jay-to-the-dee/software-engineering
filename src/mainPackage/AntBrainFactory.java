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
    
    public Instruction[] generataAntBrainFromString(String input){
        AntBrainParser parser = new AntBrainParserImp();
        return parser.parseAntBrain(input);
    }
}