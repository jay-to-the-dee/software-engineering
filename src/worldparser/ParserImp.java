package worldparser;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Main User
 */
public class ParserImp implements Parser{
    //initialise token definitions
    private static final Character redAnthill='+';
    private static final Character blackAnthill='-';
    private static final Character rock='#';
    private static final Character terrain='.';
    //init list that stores all parsed tokens
    private List<Token> world = new ArrayList<>();
    public List<Token> parse(String input) throws SomeException{
        input = input.trim();
        //gets the size of the map
        //size is a token with one parameter - a string that that represents the size of the map
        //where the first half of the string is the width and the second half-
        //the height
        world.add(getSize(input));
        input=input.trim();
        System.out.println(input);
        //parses all world tokens
        while(!input.isEmpty()){  
            input=getWorldTokens(input);
            System.out.println(input);
            input=input.trim();
        }
        
        //clean up and return
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
            while(input.charAt(i) >=48 && input.charAt(i) <= 57 && i<=(input.length())){
		i++;
            }
            //get size
            size = input.substring(0,i);
            input = input.substring(i);
        }
        return new MapSizeToken(size);
    }
    
    public String getWorldTokens(String s) throws SomeException{
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