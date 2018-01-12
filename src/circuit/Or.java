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
    
    private boolean x;
    private boolean y;

    public Or(Stack valueStack) {
        super(valueStack);
    }
    
    

    @Override
    public void execute() {
       x = valueStack.pop();
       y = valueStack.pop();
       if (x == false && y == false) {
           valueStack.push(false);
       } else {
           valueStack.push(true);
       }
    }
}
