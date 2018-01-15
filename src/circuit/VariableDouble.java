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
public class VariableDouble extends CircuitCommand {
    private Double value;
    private String name;
   private HashMap<String, Double> varMap;
    
    public VariableDouble(Stack valueStack, HashMap<String, Double> varMap,String name) {
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
