package mainPackage;


import antgame.model.World;
import antgame.parsers.worldparser.CheckRequirement;
import antgame.parsers.worldparser.ParseAndValidate;
import antgame.parsers.worldparser.SomeException;
import antgame.parsers.worldparser.SymbolNotFoundException;
import antgame.parsers.worldparser.TokenSizeMismatchException;
import antgame.textworldgenerator.GenRandomMap;
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
    
    public World loadWorld(ParseAndValidate p,String input,List<CheckRequirement> req) throws SomeException, SymbolNotFoundException, TokenSizeMismatchException{
        return p.parseAndValidate(input, req);
    }
    
    public World generateRandomWorld(List<CheckRequirement> req, GenRandomMap generator){
        return null;//generator.createString(); nick needs to sort this out
    }
}