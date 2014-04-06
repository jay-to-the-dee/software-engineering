/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antgame.parsers.worldparser;

import antgame.world.worldTokens.WorldToken;
import antgame.world.requirements.CheckRequirement;
import antgame.model.World;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Main User
 */
public class VerifierImpTest {
    
    public VerifierImpTest() {
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
     * Test of verify method, of class VerifierImp.
     */
    @Test
    public void testVerify() {
        System.out.println("verify");
        int xsize = 0;
        int ysize = 0;
        List<WorldToken> world = null;
        List<CheckRequirement> requirements = null;
        VerifierImp instance = new VerifierImp();
        World expResult = null;
        World result = instance.verify(xsize, ysize, world, requirements);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
