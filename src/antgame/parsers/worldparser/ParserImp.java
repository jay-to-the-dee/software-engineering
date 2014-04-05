package antgame.parsers.worldparser;
import antgame.parsers.exceptions.TokenSizeMismatchException;
import antgame.parsers.exceptions.SymbolNotFoundException;
import antgame.parsers.exceptions.SomeException;
import antgame.world.worldTokens.MapSizeToken;
import antgame.world.worldTokens.Token;
import antgame.model.Food;
import antgame.model.Position;
import antgame.world.worldTokens.BlackAnthillToken;
import antgame.world.worldTokens.PlainToken;
import antgame.world.worldTokens.RedAnthillToken;
import antgame.world.worldTokens.RockToken;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author ItsTheRai
 */
//lexing and parsing combined because of very simple hierarchy of world
//note: rows and columns are numbered starting from 1
public class ParserImp implements Parser{
    Queue rowQueue = new LinkedList();
    
    //initialise token definitions
    private static final Character redAnthill='+';
    private static final Character blackAnthill='-';
    private static final Character rock='#';
    private static final Character terrain='.';
    //init list that stores all parsed tokens
    private List<Token> world = new ArrayList<>();
    public List<Token> parse(String input) throws SomeException,SymbolNotFoundException,TokenSizeMismatchException{
        //should get n+2
        for (String s: input.split("\\r?\\n|\\r")){
            rowQueue.add(s);
            
        }
        //line 1 for xsize
        //line 2 for ysize
        world.add(getSize(rowQueue.remove().toString()));
        world.add(getSize(rowQueue.remove().toString()));
        //now each object in the queue should contain xsize number of elements
        //and there should be ysize number of objects in the queue alltogether
        //so do a check
        if(rowQueue.size()!=((MapSizeToken)world.get(1)).getSizeAsInt()){
            throw new TokenSizeMismatchException();
        }
        //initialise row  counter
        //parses all world tokens in queue
        int row =1;
        while(!rowQueue.isEmpty()){
            Queue comlumnQueue = new LinkedList();
            //rowString contains all row objects
            String rowString = rowQueue.remove().toString();
            //check if the row number is even, if it is
            //the first element has to be a whitespace
            if (row%2==0){
                if (rowString.charAt(0)==' '){
                    rowString=rowString.substring(1);
                }
                else throw new TokenSizeMismatchException();
            }
            int column=1;
            for(String s:rowString.split("\\s")){
                
                comlumnQueue.add(s);
            }
            if (comlumnQueue.size()!=((MapSizeToken)world.get(0)).getSizeAsInt()){
                throw new TokenSizeMismatchException();
            }
            //parse the current row
            else {
                while(!comlumnQueue.isEmpty()){
                    getWorldTokens(comlumnQueue.remove().toString(),row-1,column-1);
                    column++;
                }
            }
            row++;
        }
        //clean up and return
        List<Token> returnTokens =new LinkedList<>(world);
        world.clear();
        System.out.println(returnTokens);
        return returnTokens;
    }

    /**
     *
     * @param input
     * @return
     * @throws SomeException
     */
    public MapSizeToken getSize(String input) throws SomeException{
        String size = new String();
        if(input.isEmpty()){
            throw new SomeException();
        }
        else if(input.charAt(0) <48 || input.charAt(0) > 57){
            throw new SomeException();
        }
        else{
            int i = 0;
            ///keep reading input untill no ints are found
            while(i<(input.length())&&input.charAt(i) >=48 && input.charAt(i) < 57){
		i++;
            }
            if (i<input.length()){
                throw new SomeException();
            }
            else size = input;
            return new MapSizeToken(size);
        }
    }
    
    public void getWorldTokens(String s,int xposition, int yposition) throws SomeException{
        if(s.length()!=1){
            throw new SomeException();
        }
        if(s.charAt(0)==redAnthill){
            
            world.add(new RedAnthillToken(new Position(xposition,yposition)));
        }
        else if(s.charAt(0)==blackAnthill){
            world.add(new BlackAnthillToken(new Position(xposition,yposition)));
        }
        else if(s.charAt(0)==rock){
            world.add(new RockToken(new Position(xposition,yposition),null));
        }
        else if(s.charAt(0)==terrain){
            world.add(new PlainToken(new Position(xposition,yposition), new Stack()));
        }
        else if(s.charAt(0) >=48 && s.charAt(0) <= 57){
            Stack food = new Stack();
            for (int i=0;i<Character.getNumericValue(s.charAt(0));i++){
                food.push(new Food());
            }
            world.add(new PlainToken(new Position(xposition,yposition),food));
        }
        else throw new SomeException();
        
    }
}