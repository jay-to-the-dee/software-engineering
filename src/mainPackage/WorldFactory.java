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

    /**
     *
     * @param p A ParseAndValidate object for parsing and validating the loaded world
     * @param input a string representing the world to be loaded
     * @param req a list of requirements the world should conform to
     * @return A parser World object if it matches all criteria
     * @throws RowNumberException actual and formal number of rows differ
     * @throws RowDoesntStartWithWhitespaceException Odd row doesn't start with a whitespace
     * @throws ColumnNumberException actual and formal number of columns differ
     * @throws Exception default Exception
     */
    public static World loadWorld(ParseAndValidate p, String input, List<CheckRequirement> req) throws RowNumberException, RowDoesntStartWithWhitespaceException, ColumnNumberException, Exception
    {
        return p.parseAndValidate(input, req);
    }

    /**
     *
     * @param req A list of requirements the world should conform to
     * @return A World object conforming to these requirements
     */
    public static World generateRandomWorld(List<CheckRequirement> req)
    {
        GenRandomMap generator = new GenRandomMap(150);

        return generator.createWorld();
    }
}