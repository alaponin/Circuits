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
public class Accept extends CircuitCommand {
    private boolean x;

    public Accept(Stack valueStack, boolean x) {
        super(valueStack);
        this.x = x;
    }
 

    @Override
    public void execute() {
        valueStack.push(x);
    }
    
}