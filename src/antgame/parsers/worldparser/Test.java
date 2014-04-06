package antgame.parsers.worldparser;

import mainPackage.GameEngine;
import antgame.ant.instructions.Instruction;
import antgame.ant.instructions.InstructionSet;
import antgame.parsers.antbrainparser.AntBrainParserImp;
import java.io.IOException;
import java.nio.charset.Charset;
/**
 *
 * @author Main User
 */
public class Test {
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, Exception {
        Parser p = new ParserImp();
        //Verifier v = new VerifierImp();
        ReadFile file = new ReadFile();
        AntBrainParserImp parser = new AntBrainParserImp();
        
        //choose file path
        String input =ReadFile.readFile("./data/worlds/properWorlds/1.world",Charset.defaultCharset());
        
        p.parse(input);
        //System.out.println(parser.parseAntBrain(input));
        
         //GameEngine e = new GameEngine();
         
        //e.run();
        
         
        //Instruction[] v = parser.parseAntBrain(input);
        //System.out.println(v.length);
        //for (int i=0;i<v.length;i++){
        //    System.out.println(v[i]);
        //}
        /*String input=new String(""
                + "3\n"
                + "4\n"
                + ". # .\n"
                + " . . .\n"
                + ". . .\n"
                + " . . .");
                */
        //try{
                    //List<Token> l= new LinkedList<Token>();
            //ParseAndValidate pav = new ParseAndValidate();
            //List<CheckRequirement> ls = new LinkedList();
            //ls.add(new RequirementDimension(100,100));
            //ls.add(new RequirementBorder(1));
            //System.out.println(pav.parseAndValidate(input, ls));
                    //<Token> l=new LinkedList<>(p.parse(input));
                    //System.out.println(l);
                    //int x = ((MapSizeToken)l.get(0)).getSizeAsInt();
                    //int y = ((MapSizeToken)l.get(1)).getSizeAsInt();
                    //System.out.println(x);
                    //List<WorldToken>list = new LinkedList<>();
                    //for (int i=2;i<l.size();i++){
                    //    list.add((WorldToken)l.get(i));
                    //}
                    
                    //v.verify(x, y, list,ls);
                    //success so  
        //}
        //catch(Exception e){
             //   System.out.println("sumin happened");
            //}
    }
}