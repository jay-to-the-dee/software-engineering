package antgame.parsers.worldparser;
import antgame.model.Food;
import antgame.model.FoodStack;
import antgame.model.Position;
import antgame.model.World;
import antgame.parsers.exceptions.ColumnNumberException;
import antgame.parsers.exceptions.EmptyLineException;
import antgame.parsers.exceptions.LineHasNotJustIntegersException;
import antgame.parsers.exceptions.NotAnIntException;
import antgame.parsers.exceptions.RowDoesntStartWithWhitespaceException;
import antgame.parsers.exceptions.RowNumberException;
import antgame.parsers.exceptions.SpecifierNotRecognisedException;
import antgame.parsers.exceptions.UnsupportedSizeOfSpecifierException;
import antgame.world.worldTokens.BlackAnthillToken;
import antgame.world.worldTokens.MapSizeToken;
import antgame.world.worldTokens.PlainToken;
import antgame.world.worldTokens.RedAnthillToken;
import antgame.world.worldTokens.RockToken;
import antgame.world.worldTokens.TerrainToken;
import antgame.world.worldTokens.WorldToken;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private List<WorldToken> world = new ArrayList<>();
    @Override
    public World parse(String input) throws RowNumberException,RowDoesntStartWithWhitespaceException, ColumnNumberException,EmptyLineException,NotAnIntException,LineHasNotJustIntegersException,SpecifierNotRecognisedException,UnsupportedSizeOfSpecifierException{
        //should get n+2
        for (String s: input.split("\\r?\\n|\\r")){
            rowQueue.add(s);
        }
        
            //line 1 for xsize
            //line 2 for ysize
            world.add((getSize(rowQueue.remove().toString())));
            world.add(getSize(rowQueue.remove().toString()));
        //now each object in the queue should contain xsize number of elements
        //and there should be ysize number of objects in the queue alltogether
        //so do a check
        if(rowQueue.size()!=((MapSizeToken)world.get(1)).getSize()){
                throw new RowNumberException("File states that there are "+((MapSizeToken)world.get(1)).getSize() + " rows but there"
                        + "are actually "+rowQueue.size() +" rows");
           
        }
        //initialise row  counter
        //parses all world tokens in queue
        int column =1;
        while(!rowQueue.isEmpty()){
            Queue comlumnQueue = new LinkedList();
            //rowString contains all row objects
            String rowString = rowQueue.remove().toString();
            //check if the row number is even, if it is
            //the first element has to be a whitespace
            if (column%2==0){
                if (rowString.charAt(0)==' '){
                    rowString=rowString.substring(1);
                }
                else throw new RowDoesntStartWithWhitespaceException(" Row "+column +" doesn't start with a whitespace");
            }
            int row=1;
            //we assume that more than one whitespace is allowed between cell specifiers
            if (rowString==""||rowString.isEmpty()){
                    throw new EmptyLineException("Line "+(row-1)+" es empty");
            }else{
            for(String s:rowString.split("\\s+")){
                comlumnQueue.add(s);
            }
            }
            if (comlumnQueue.size()!=((MapSizeToken)world.get(0)).getSize()){
                throw new ColumnNumberException("File states that there are "+
                        ((MapSizeToken)world.get(0)).getSize() + " columns but there"
                        + "are actually "+comlumnQueue.size() +" columns");
            }
            //parse the current row
            else {
                while(!comlumnQueue.isEmpty()){
                        getWorldTokens(comlumnQueue.remove().toString(),row-1,column-1);
                    
                    row++;
                }
            }
            column++;
        }
        //clean up and return
        List<WorldToken> returnTokens =new LinkedList<>(world);
        world.clear();
        
        int xsize= ((MapSizeToken) returnTokens.get(0)).getSize();
        int ysize = ((MapSizeToken)returnTokens.get(1)).getSize();
        List<TerrainToken>list = new LinkedList<>();
        for (int i=2;i<returnTokens.size();i++){
            list.add((TerrainToken)returnTokens.get(i));
        }
        TerrainToken[] t = new TerrainToken[list.size()];
        for (int i = 0; i< list.size();i++){
            t[i]=list.get(i);
        }
        return new World(xsize,ysize,t);
    }

    /**
     *
     * @param input a string representing a numeric value
     * @return A MapSizeToken object with the specified size
     * @throws antgame.parsers.exceptions.LineHasNotJustIntegersException expected only integers 
     * @throws antgame.parsers.exceptions.EmptyLineException empty line 
     * @throws antgame.parsers.exceptions.NotAnIntException expected only integers
     */
    public MapSizeToken getSize(String input) throws LineHasNotJustIntegersException, EmptyLineException, NotAnIntException{
        int size;
        //String size = new String();
        if(input.isEmpty()){
            throw new EmptyLineException("Line is empty");
        }
        else if(input.charAt(0) <48 || input.charAt(0) > 57){
            throw new NotAnIntException("Value :"+input.charAt(0)+" is not an integer");
        }
        else{
            int i = 0;
            ///keep reading input untill no ints are found
            while(i<(input.length())&&input.charAt(i) >=48 && input.charAt(i) < 57){
		i++;
            }
            //checks if the current line has just integers
            if (i<input.length()){
                throw new LineHasNotJustIntegersException("Error in line: "+input);
            }
            else size = Integer.parseInt(input);
            return new MapSizeToken(size);
        }
    }
    
    /**
     *
     * @param s representing a single cell identifier
     * @param xposition x coordinate of the cell in the world
     * @param yposition y coordinate of the cell in the world
     * @throws UnsupportedSizeOfSpecifierException cell specifier of wrong size
     * @throws SpecifierNotRecognisedException Could not recognise specifier
     */
    public void getWorldTokens(String s,int xposition, int yposition) throws UnsupportedSizeOfSpecifierException, SpecifierNotRecognisedException,EmptyLineException{
        if(s.length()!=1){
            throw new UnsupportedSizeOfSpecifierException(s+ "is not a valid cell specifier or is missing a whitespace");
        }
        if(s.charAt(0)==redAnthill){
            
            world.add(new RedAnthillToken(new Position(xposition,yposition)));
        }
        else if(s.charAt(0)==blackAnthill){
            world.add(new BlackAnthillToken(new Position(xposition,yposition)));
        }
        else if(s.charAt(0)==rock){
            world.add(new RockToken(new Position(xposition,yposition)));
        }
        else if(s.charAt(0)==terrain){
            world.add(new PlainToken(new Position(xposition,yposition), new FoodStack()));
        }
        else if(s.charAt(0) >=48 && s.charAt(0) <= 57){
            FoodStack food = new FoodStack();
            for (int i=0;i<Character.getNumericValue(s.charAt(0));i++){
                food.push(new Food());
            }
            world.add(new PlainToken(new Position(xposition,yposition),food));
        }
        else throw new SpecifierNotRecognisedException(s+ " is not a valid cell specifier(line "+(yposition+1)+
                " column "+(xposition-1)+")");
        
    }
}