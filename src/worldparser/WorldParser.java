package worldparser;

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
        String input=new String("123.........................#-+  .#   +-");
        try{
        System.out.println(p.parse(input));
        }
        catch(Exception e){
                System.out.println("sumin happened");
            }
    
}
}
