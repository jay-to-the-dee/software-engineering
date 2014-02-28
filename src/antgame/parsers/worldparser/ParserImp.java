package antgame.parsers.worldparser;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Main User
 */
//lexing and parsing combined because of very simple hierarchy of world
public class ParserImp implements Parser{
    Queue q = new LinkedList();
    
    //initialise token definitions
    private static final Character redAnthill='+';
    private static final Character blackAnthill='-';
    private static final Character rock='#';
    private static final Character terrain='.';
    //init list that stores all parsed tokens
    private List<Token> world = new ArrayList<>();
    public List<Token> parse(String input) throws SomeException,SymbolNotFoundException,TokenSizeMismatchException{
        input = input.trim();
        //should get n+2
        for (String s: input.split("\\r?\\n|\\r")){
            q.add(s.trim());
        }
        //gets the xsize of the map
        //not sure if works when
        //line 1 for xsize
        //line 2 for ysize
        
        
        world.add(getSize(q.remove().toString()));
        world.add(getSize(q.remove().toString()));
        //now each object in the queue should contain xsize number of elements
        //and there should be ysize number of objects in the queue alltogether
        //so do a check
        if(q.size()!=((MapSizeToken)world.get(1)).getSizeAsInt()){
            throw new TokenSizeMismatchException();
        }
        //parses all world tokens in queue
        
        while(!q.isEmpty()){
            Queue queue = new LinkedList();
            //s contains all row objects
            for(String s:q.remove().toString().trim().split("\\n|\\t")){
                queue.add(s.trim());
            }
            if (queue.size()!=((MapSizeToken)world.get(0)).getSizeAsInt()){
                throw new TokenSizeMismatchException();
            }
            else {
                while(!queue.isEmpty()){
                    getWorldTokens(queue.remove().toString());
                }
            }
        //clean up and returna
        
        }
        List<Token> returnTokens = world;
        System.out.println(returnTokens);
        world.clear();
        return returnTokens;
    }

    public Token getSize(String input) throws SomeException{
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
            while(input.charAt(i) >=48 && input.charAt(i) < 57 && i<(input.length())){
		i++;
            }
            if (i<input.length()){
                throw new SomeException();
            }
            else size = input;
            return new MapSizeToken(size);
        }
    }
    
    public String getWorldTokens(String s) throws SomeException{
        s.trim();
        if(s.charAt(0)==redAnthill){
            world.add(new RedAnthillToken());
            s=s.substring(1);
        }
        else if(s.charAt(0)==blackAnthill){
            world.add(new BlackAnthillToken());
            s=s.substring(1);
        }
        else if(s.charAt(0)==rock){
            world.add(new RockToken());
            s=s.substring(1);
        }
        else if(s.charAt(0)==terrain){
            world.add(new TerrainToken());
            s=s.substring(1);
        }
        else if(s.charAt(0) >=48 && s.charAt(0) <= 57){
            world.add(new TerrainWithFoodToken(5));
            s=s.substring(1);
        }
        else throw new SomeException();
        return s;
        
    }
}