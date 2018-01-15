/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circuit;

import java.util.HashMap;
import java.util.Stack;

/**
 *
 * @author arnelaponin
 */
public class Variable extends CircuitCommand {
    private Boolean value;
    private String name;
   private HashMap<String, Boolean> varMap;
    
    public Variable(Stack valueStack, HashMap<String, Boolean> varMap,String name) {
        super(valueStack);
        this.name = name;
        this.varMap = varMap;
    }
 

    @Override
    public void execute() {
        value = varMap.get(name);
        valueStack.push(value);
    }
    
}
