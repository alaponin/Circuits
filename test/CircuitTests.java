/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import circuit.Circuit;
import java.util.HashMap;
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
        c.getInput("X1");
        c.getInput("X2");
        c.getInput("and");
        
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        map.put("X1", Boolean.TRUE);
        map.put("X2", Boolean.TRUE);
        
        boolean result;
        result = c.getResult(map);
        assertTrue(result);
        
        c.getInput("X1");
        c.getInput("X2");
        c.getInput("and");
        
        HashMap<String, Boolean> map1 = new HashMap<String, Boolean>();
        map1.put("X1", Boolean.TRUE);
        map1.put("X2", Boolean.FALSE);
        boolean result1;
        result1 = c.getResult(map1);
        assertFalse(result1);
    }
    
    
    @Test
    public void testX1AndX2OrX3() throws Exception {
        Circuit c = new Circuit();
        c.getInput("X1");
        c.getInput("X2");
        c.getInput("and");
        c.getInput("X3");
        c.getInput("or");
        
        HashMap<String, Boolean> map1 = new HashMap<String, Boolean>();
        map1.put("X1", Boolean.FALSE);
        map1.put("X2", Boolean.TRUE);
        map1.put("X3", Boolean.FALSE);
        
        boolean result;
        result = c.getResult(map1);
        assertFalse(result);
        
        c.getInput("X1");
        c.getInput("X2");
        c.getInput("and");
        c.getInput("X3");
        c.getInput("or");
        
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        map.put("X1", Boolean.FALSE);
        map.put("X2", Boolean.FALSE);
        map.put("X3", Boolean.TRUE);
        boolean result1;
        result1 = c.getResult(map);
        assertTrue(result1);
    }
   
    
    @Test
    public void testAlwaysTrue() throws Exception {
        Circuit c = new Circuit();
        c.getInput("X1");
        c.getInput("X2");
        c.getInput("negation");
        c.getInput("or");
        
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        map.put("X1", Boolean.TRUE);
        map.put("X2", Boolean.TRUE);
        
        boolean result;
        result = c.getResult(map);
        assertTrue(result);
    }
    
    
}
