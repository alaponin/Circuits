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
 public abstract class CircuitCommand implements Cloneable {
    protected Stack<Double> valueStack;
     
    public CircuitCommand(Stack valueStack) {
        this.valueStack = valueStack;
    }
    public abstract void execute();
}
