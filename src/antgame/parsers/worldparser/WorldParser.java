package antgame.parsers.worldparser;

/**
 *
 * @author Main User
 */
public class WorldParser {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Parser p = new ParserImp();
        String input=new String("2\n2\n"
                + ". .\n. .");
        try{
        System.out.println(p.parse(input));
        }
        catch(Exception e){
                System.out.println("sumin happened");
            }
        //fucking old macs
        System.out.println("\\r?\\n|\\r");
}
}