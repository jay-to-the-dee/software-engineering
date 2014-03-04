package antgame.parsers.worldparser;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Main User
 */
public class WorldParser {
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Parser p = new ParserImp();
        Verifier v = new VerifierImp();
        ReadFile file = new ReadFile();
        //choose file path
        String input =ReadFile.readFile("C:\\Users\\Main User\\Downloads\\sample5.world",Charset.defaultCharset());
         
        /*String input=new String(""
                + "3\n"
                + "4\n"
                + ". # .\n"
                + " . . .\n"
                + ". . .\n"
                + " . . .");
                */
        try{
                    //List<Token> l= new LinkedList<Token>();
            ParseAndValidate pav = new ParseAndValidate();
            List<CheckRequirement> ls = new LinkedList();
            ls.add(new RequirementDimension(100,100));
            ls.add(new RequirementBorder());
            System.out.println(pav.parseAndValidate(input, ls));
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
        }
        catch(Exception e){
                System.out.println("sumin happened");
            }
    }
}