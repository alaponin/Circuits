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
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import jdk.nashorn.internal.objects.NativeArray;


/**
 *
 * @author arnelaponin
 */
public final class Circuit {
    private HashMap<String, CircuitCommand> hmap = new HashMap<String, CircuitCommand>();
    private Stack<Double> valueStack = new Stack<Double>();
    private List<CircuitCommand> operations = new ArrayList<CircuitCommand>();
    private HashMap<String, Double> varMap = new HashMap<String, Double>();
    
    public Circuit() {
        hmap.put("true", new Accept(valueStack, Boolean.TRUE));
        hmap.put("false", new Accept(valueStack, Boolean.FALSE));
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
        HashMap<String, Double> mapDouble = new HashMap();
        for (Map.Entry<String, Boolean> entry : varMap.entrySet()) {
            Double result = (entry.getValue() == Boolean.TRUE)? 1.0 : 0.0;
            mapDouble.put(entry.getKey(), result);
          }
        
        this.varMap.putAll(mapDouble);
        valueStack.clear();
        for (CircuitCommand cc : operations) {
            try {
                cc.execute();
            } catch (EmptyStackException e) {
                throw new Exception("Operations do not have enough input.", e);
            }
        }
        return (valueStack.pop() >= 0.5) ? Boolean.TRUE : Boolean.FALSE;
    }
    
    /**
     *
     * @param varMap
     * @return
     * @throws Exception
     */
    public Double getResultDouble(HashMap<String, Double> varMap) throws Exception {
        this.varMap.putAll(varMap);
        for(String key:varMap.keySet()){
            if(varMap.get(key)>1.0)
                throw new Exception("Value is not acceptable");
        }
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
    
    public void createNewOperation(MyBinaryGate fun, String name) {
        CircuitCommand newOp = new NewBinaryOperation(valueStack, fun);
        hmap.put(name, newOp);
    }
    
    public void createNewOperation(MyUnaryGate fun, String name) {
        CircuitCommand newOp = new NewUnaryOperation(valueStack, fun);
        hmap.put(name, newOp);
    }
}


//class Myclass implement FunctionInteface{]
//    static Double fun (Double x, Double y) {
//        return x  - y;
//    }
//}

