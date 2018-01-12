/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import circuit.Circuit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author arnelaponin
 */
public class CircuitTests {
    
    public CircuitTests() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testX1AndX2() throws Exception {
        Circuit c = new Circuit();
        c.getInput("true");
        c.getInput("true");
        c.getInput("and");
        boolean result;
        result = c.getResult();
        assertTrue(result);
        
        c.getInput("true");
        c.getInput("false");
        c.getInput("and");
        boolean result1;
        result1 = c.getResult();
        assertFalse(result1);
    }
    
    
    @Test
    public void testX1AndX2OrX3() throws Exception {
        Circuit c = new Circuit();
        c.getInput("false");
        c.getInput("true");
        c.getInput("and");
        c.getInput("false");
        c.getInput("or");
        boolean result;
        result = c.getResult();
        assertFalse(result);
        
        c.getInput("false");
        c.getInput("false");
        c.getInput("and");
        c.getInput("true");
        c.getInput("or");
        boolean result1;
        result1 = c.getResult();
        assertTrue(result1);
    }
   
    
    @Test
    public void testAlwaysTrue() throws Exception {
        Circuit c = new Circuit();
        c.getInput("true");
        c.getInput("true");
        c.getInput("negation");
        c.getInput("or");
        
        boolean result;
        result = c.getResult();
        assertTrue(result);
    }
    
    
}
