/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antgame.parsers.worldparser;

import antgame.model.Position;
import antgame.world.worldTokens.MapSizeToken;
import antgame.world.worldTokens.PlainToken;
import antgame.world.worldTokens.RockToken;
import antgame.world.worldTokens.Token;
import antgame.world.worldTokens.WorldToken;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Main User
 */
public class ParserImpTest {
    
    public ParserImpTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of parse method, of class ParserImp.
     */

    @Test
    public void testParse() throws Exception {
        System.out.println("parse");
        //generate test input strings
        String input0 =ReadFile.readFile("./data/worlds/TestingWorlds/1(1).world",Charset.defaultCharset());
        ParserImp instance = new ParserImp();
        List<WorldToken> expResult = new ArrayList<>();
        expResult.add(new MapSizeToken(2));
        expResult.add(new MapSizeToken(2));
        
        expResult.add(new RockToken(new Position(0,0),new Stack()));
        expResult.add(new RockToken(new Position(1,0),new Stack()));
        expResult.add(new RockToken(new Position(0,1),new Stack()));
        expResult.add(new RockToken(new Position(1,1),new Stack()));
        
        List<WorldToken> result = instance.parse(input0);
        
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        for (int i=0;i<result.size();i++){
            if (expResult.get(i)!=result.get(i)){
                System.out.println();
                System.out.println();System.out.println();
                
                //System.out.println("Expected result: "+expResult.get(i).toString());
                System.out.println();
                System.out.println();
                //System.out.println("Actual result: "+result.get(i).toString());
                System.out.println();System.out.println();
            }
    }
    }

    /**
     * Test of getSize method, of class ParserImp.
     */

    /**
     * Test of getWorldTokens method, of class ParserImp.
     */
    
}
