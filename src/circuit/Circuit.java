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
    private HashMap<String, CircuitCommand> hmap = new HashMap<String, CircuitCommand>();
    private Stack<Boolean> valueStack = new Stack<Boolean>();
    private List<CircuitCommand> operations = new ArrayList<CircuitCommand>();
    private HashMap<String, Boolean> varMap = new HashMap<String, Boolean>();
    
    public Circuit() {
        hmap.put("true", new Accept(valueStack,true));
        hmap.put("false", new Accept(valueStack,false));
        hmap.put("and", new And(valueStack));
        hmap.put("or", new Or(valueStack));
        hmap.put("negation", new Negation(valueStack));
    }
    
    
    
    /**
     * The values and commands are input in reverse polish notation.
     * @param input In String using boolean
     * @throws Exception When reverse polish notation is not respected.
     */
    public void getInput(String input) {
        String command = input;
        CircuitCommand cc;
        if (hmap.containsKey(command)) {
            cc = hmap.get(command);
            operations.add(cc);
        } else {
            cc = new Variable(valueStack, varMap, input);
            operations.add(cc);
        }
    }

    public boolean getResult(HashMap<String, Boolean> varMap) throws Exception {
        this.varMap.clear();
        this.varMap.putAll(varMap);
        valueStack.clear();
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
