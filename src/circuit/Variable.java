/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circuit;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author arnelaponin
 */
public class Variable extends CircuitCommand {
    private Double value;
    private String name;
   private HashMap<String, Double> varMap;
    
    public Variable(Stack valueStack, HashMap<String, Boolean> varMap,String name) {
        super(valueStack);
        HashMap<String, Double> mapDouble = new HashMap();
        for (Map.Entry<String, Boolean> entry : varMap.entrySet()) {
            Double result = (entry.getValue() == Boolean.TRUE)? 1.0 : 0.0;
            mapDouble.put(entry.getKey(), result);
          }
        this.name = name;
        this.varMap = mapDouble;
    }
 
    @Override
    public void execute() {
        value = varMap.get(name);
        valueStack.push(value);
    }
    
}
