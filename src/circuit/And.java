/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circuit;

import java.util.Stack;

/**
 *
 * @author arnelaponin
 */
public class And extends CircuitCommand {
    private Double x;
    private Double y;

    public And(Stack valueStack) {
        super(valueStack);
    }
    
    @Override
    public void execute() {
       x = valueStack.pop();
       y = valueStack.pop();
       Double result = x * y;
       valueStack.push(result);
    }
    
}
