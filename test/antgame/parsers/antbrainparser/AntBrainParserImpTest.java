package antgame.parsers.antbrainparser;

import antgame.ant.instructions.Instruction;
import antgame.ant.instructions.InstructionSet;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author ItsTheRai
 */
public class AntBrainParserImpTest {
    
    public AntBrainParserImpTest() {
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
     * Test of parseAntBrain method, of class AntBrainParserImp.
     */
    @Test
    public void testParseAntBrain() {
        System.out.println("parseAntBrain");
        String input = "";
        AntBrainParserImp instance = new AntBrainParserImp();
        Instruction[] expResult = null;
        InstructionSet[] result = instance.parseAntBrain(input);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
