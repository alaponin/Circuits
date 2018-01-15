/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circuit;

import java.util.Stack;

/**
 *
 * @author Beza Getachew
 */
public class NewUnaryOperation extends CircuitCommand {
    
    private MyUnaryGate myFun;
    private Double x;

    public NewUnaryOperation(Stack valueStack, MyUnaryGate fun) {
        super(valueStack);
        this.myFun = fun;
    }

    @Override
    public void execute() {
        x = valueStack.pop();
       
       Double result = myFun.evaluate(x);
       valueStack.push(result);
    }
    
}
