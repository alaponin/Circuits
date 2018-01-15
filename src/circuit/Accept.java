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
    private Double value;

    public Accept(Stack valueStack, Boolean x) {
        super(valueStack);
        Double result = (x == true) ? 1.0 : 0.0;
        this.value = result;
    }
 

    @Override
    public void execute() {
        valueStack.push(value);
    }
    
}
