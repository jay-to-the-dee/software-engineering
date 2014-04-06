package mainPackage;

import antgame.model.World;
import antgame.parsers.exceptions.ColumnNumberException;
import antgame.parsers.exceptions.RowDoesntStartWithWhitespaceException;
import antgame.parsers.exceptions.RowNumberException;
import antgame.world.requirements.CheckRequirement;
import antgame.parsers.worldparser.ParseAndValidate;
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
public class WorldFactory
{

    public static World loadWorld(ParseAndValidate p, String input, List<CheckRequirement> req) throws RowNumberException, RowDoesntStartWithWhitespaceException, ColumnNumberException, Exception
    {
        return p.parseAndValidate(input, req);
    }

    public static World generateRandomWorld(List<CheckRequirement> req)
    {
        GenRandomMap generator = new GenRandomMap(150);

        return generator.createWorld(); //nick needs to sort this out
    }
}
