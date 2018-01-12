/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circuit;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author arnelaponin
 */
public final class Circuit {
    HashMap<String, CircuitCommand> hmap = new HashMap<String, CircuitCommand>();
    static Stack<Boolean> valueStack = new Stack<Boolean>();
    static List<CircuitCommand> operations = new ArrayList<CircuitCommand>();
    
    public Circuit() {
        hmap.put("true", new Accept(valueStack,true));
        hmap.put("false", new Accept(valueStack,false));
        hmap.put("and", new And(valueStack));
        hmap.put("or", new Or(valueStack));
        hmap.put("negation", new Negation(valueStack));
    }
    
    public void build(String... operations) {
        for (String operation : operations) {
            if (hmap.containsKey(operation)) {
                this.operations.add(hmap.get(operation));
            }
        }
        System.out.println(this.operations);
    }
    
    /**
     * The values and commands are input in reverse polish notation.
     * @param input In String using boolean
     * @throws Exception When reverse polish notation is not respected.
     */
    public void getInput(String input) {
        String command = input;
        CircuitCommand cc = hmap.get(command);
        
        operations.add(cc);
             
    }

    public boolean getResult() throws Exception {
        //valueStack = new Stack<Boolean>();
        for (CircuitCommand cc : operations) {
            try {
                cc.execute();
            } catch (EmptyStackException e) {
                throw new Exception("Operations do not have enough input.", e);
            }
        }
        return valueStack.pop();
    }
    

}
