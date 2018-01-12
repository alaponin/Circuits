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
public class Negation extends CircuitCommand {
    private boolean x;

    public Negation(Stack valueStack) {
        super(valueStack);
    }
    
    

    @Override
    public void execute() {
        x = valueStack.pop();
        if (x == true) {
            valueStack.push(false);
        } else {
            valueStack.push(true);
        }
    }
    
}
