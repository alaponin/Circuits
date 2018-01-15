/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circuit;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Beza Getachew
 */
/**
 *
 * @author arnelaponin
 */
public class NewBinaryOperation extends CircuitCommand {
    
    private MyBinaryGate myFun;
    private Double x;
    private Double y;

    public NewBinaryOperation(Stack valueStack, MyBinaryGate fun) {
        super(valueStack);
        this.myFun = fun;
    }
    
    @Override
    public void execute() {
       x = (Double) valueStack.pop();
       y = (Double) valueStack.pop();
       
       Double result = myFun.evaluate(y, x);
       valueStack.push(result);
    }
}
