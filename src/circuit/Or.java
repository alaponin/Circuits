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
public class Or extends CircuitCommand {
    
    private Double x;
    private Double y;

    public Or(Stack valueStack) {
        super(valueStack);
    }
    
    @Override
    public void execute() {
       x = (Double) valueStack.pop();
       y = (Double) valueStack.pop();
       Double result = 1.0 - (1.0 - x) * (1.0 - y);
       valueStack.push(result);
    }
}
