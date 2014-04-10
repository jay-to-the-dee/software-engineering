/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antgame.parsers.worldparser;

import antgame.model.World;
import antgame.parsers.exceptions.ColumnNumberException;
import antgame.parsers.exceptions.EmptyLineException;
import antgame.parsers.exceptions.LineHasNotJustIntegersException;
import antgame.parsers.exceptions.NotAnIntException;
import antgame.parsers.exceptions.RowDoesntStartWithWhitespaceException;
import antgame.parsers.exceptions.RowNumberException;
import antgame.parsers.exceptions.SpecifierNotRecognisedException;
import antgame.parsers.exceptions.UnsupportedSizeOfSpecifierException;
import antgame.parsers.worldparser.testClasses.WorldTestClass1;
import antgame.parsers.worldparser.testClasses.WorldTestClass2;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
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
     * Test of parse method, of class ParserImp
     */

    @Test
    public void testParse() throws Exception {
        System.out.println("parse");
        //generate test input strings
        String input1 =ReadFile.readFile("./data/worlds/TestingWorlds/1(1).world",Charset.defaultCharset());
        String input2 =ReadFile.readFile("./data/worlds/TestingWorlds/1(2).world",Charset.defaultCharset());
        ParserImp instance = new ParserImp();
        World result1 = instance.parse(input1);
        World result2 = instance.parse(input2);
        WorldTestClass1 i1 = new WorldTestClass1();
        WorldTestClass2 i2 = new WorldTestClass2();
        World expResult1 = i1.getWorld();
        World expResult2 = i2.getWorld();
        
        
        
        assertEquals(expResult1, result1);
        assertEquals(expResult2,result2);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test(expected=RowDoesntStartWithWhitespaceException.class)
    public void testWhitespaceException() throws IOException, RowNumberException, RowDoesntStartWithWhitespaceException, ColumnNumberException, EmptyLineException, NotAnIntException, LineHasNotJustIntegersException, SpecifierNotRecognisedException, UnsupportedSizeOfSpecifierException {
        String input3 =ReadFile.readFile("./data/worlds/TestingWorlds/1(3).world",Charset.defaultCharset());
        ParserImp instance = new ParserImp();
        instance.parse(input3);
    }
    
    @Test(expected=ColumnNumberException .class)
    public void testColumnCount() throws IOException, RowNumberException, RowDoesntStartWithWhitespaceException, ColumnNumberException, EmptyLineException, NotAnIntException, LineHasNotJustIntegersException, SpecifierNotRecognisedException, UnsupportedSizeOfSpecifierException {
        String input4 =ReadFile.readFile("./data/worlds/TestingWorlds/1(4).world",Charset.defaultCharset());
        ParserImp instance = new ParserImp();
        instance.parse(input4);
    }
    @Test(expected=RowNumberException .class)
    public void testRowCount() throws IOException, RowNumberException, RowDoesntStartWithWhitespaceException, ColumnNumberException, EmptyLineException, NotAnIntException, LineHasNotJustIntegersException, SpecifierNotRecognisedException, UnsupportedSizeOfSpecifierException {
        String input5 =ReadFile.readFile("./data/worlds/TestingWorlds/1(5).world",Charset.defaultCharset());
        ParserImp instance = new ParserImp();
        instance.parse(input5);
    }
    @Test(expected=EmptyLineException.class)
    public void testEmptyLine() throws IOException, RowNumberException, RowDoesntStartWithWhitespaceException, ColumnNumberException, EmptyLineException, NotAnIntException, LineHasNotJustIntegersException, SpecifierNotRecognisedException, UnsupportedSizeOfSpecifierException {
        String input6 =ReadFile.readFile("./data/worlds/TestingWorlds/1(6).world",Charset.defaultCharset());
        ParserImp instance = new ParserImp();
        instance.parse(input6);
    }
    @Test(expected=LineHasNotJustIntegersException.class)
    public void testSizeLineNotJustInts() throws IOException, RowNumberException, RowDoesntStartWithWhitespaceException, ColumnNumberException, EmptyLineException, NotAnIntException, LineHasNotJustIntegersException, SpecifierNotRecognisedException, UnsupportedSizeOfSpecifierException {
        String input7 =ReadFile.readFile("./data/worlds/TestingWorlds/1(7).world",Charset.defaultCharset());
        ParserImp instance = new ParserImp();
        instance.parse(input7);
    }
    @Test(expected=NotAnIntException.class)
    public void testNotAntInt() throws IOException, RowNumberException, RowDoesntStartWithWhitespaceException, ColumnNumberException, EmptyLineException, NotAnIntException, LineHasNotJustIntegersException, SpecifierNotRecognisedException, UnsupportedSizeOfSpecifierException {
        String input8 =ReadFile.readFile("./data/worlds/TestingWorlds/1(8).world",Charset.defaultCharset());
        ParserImp instance = new ParserImp();
        instance.parse(input8);
    }
    @Test(expected=SpecifierNotRecognisedException.class)
    public void testSpecifierNotDefined() throws IOException, RowNumberException, RowDoesntStartWithWhitespaceException, ColumnNumberException, EmptyLineException, NotAnIntException, LineHasNotJustIntegersException, SpecifierNotRecognisedException, UnsupportedSizeOfSpecifierException {
        String input9 =ReadFile.readFile("./data/worlds/TestingWorlds/1(9).world",Charset.defaultCharset());
        ParserImp instance = new ParserImp();
        instance.parse(input9);
    }
    @Test(expected=UnsupportedSizeOfSpecifierException.class)
    public void testUnsupportedSizeOfSpecifier() throws IOException, RowNumberException, RowDoesntStartWithWhitespaceException, ColumnNumberException, EmptyLineException, NotAnIntException, LineHasNotJustIntegersException, SpecifierNotRecognisedException, UnsupportedSizeOfSpecifierException {
        String input10 =ReadFile.readFile("./data/worlds/TestingWorlds/1(10).world",Charset.defaultCharset());
        ParserImp instance = new ParserImp();
        instance.parse(input10);
    }
}
