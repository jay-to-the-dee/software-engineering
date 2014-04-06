package mainPackage;


import antgame.world.worldTokens.World;
import antgame.world.requirements.CheckRequirement;
import antgame.parsers.worldparser.ParseAndValidate;
import antgame.parsers.exceptions.SomeException;
import antgame.parsers.exceptions.SymbolNotFoundException;
import antgame.parsers.exceptions.TokenSizeMismatchException;
import antgame.world.textworldgenerator.GenRandomMap;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ItsTheRai
 */
public class WorldFactory {
    
    public static World loadWorld(ParseAndValidate p,String input,List<CheckRequirement> req) throws SomeException, SymbolNotFoundException, TokenSizeMismatchException{
        return p.parseAndValidate(input, req);
    }
    
    public static World generateRandomWorld(List<CheckRequirement> req, GenRandomMap generator){
        return null;//generator.createString(); nick needs to sort this out
    }
}