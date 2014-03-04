/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package worldparser;

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
        String input = "";
        ParserImp instance = new ParserImp();
        List expResult = null;
        List result = instance.parse(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSize method, of class ParserImp.
     */
    @Test
    public void testGetSize() throws Exception {
        System.out.println("getSize");
        String input = "";
        ParserImp instance = new ParserImp();
        Token expResult = null;
        Token result = instance.getSize(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWorldTokens method, of class ParserImp.
     */
    @Test
    public void testGetWorldTokens() throws Exception {
        System.out.println("getWorldTokens");
        String s = "";
        ParserImp instance = new ParserImp();
        String expResult = "";
        String result = instance.getWorldTokens(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}