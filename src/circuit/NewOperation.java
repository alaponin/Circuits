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
/**
 *
 * @author arnelaponin
 */
public class NewOperation extends CircuitCommand {
    
    private MyGate myFun;
    private Double x;
    private Double y;

    public NewOperation(Stack valueStack, MyGate fun) {
        super(valueStack);
        this.myFun = fun;
    }
    
    @Override
    public void execute() {
       x = valueStack.pop();
       y = valueStack.pop();
       Double result = myFun.evaluate(y, x);
       valueStack.push(result);
    }
}
