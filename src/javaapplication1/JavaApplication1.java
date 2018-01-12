/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import circuit.Circuit;

/**
 *
 * @author arnelaponin
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Circuit c = new Circuit();
        c.getInput("false");
        c.getInput("negation");
        c.getInput("true");
        c.getInput("and");
        System.out.println(c.getResult());
        
        
       
        c.getInput("negation");
        
        System.out.println(c.getResult());
        c.getInput("true");
        c.getInput("or");
        System.out.println(c.getResult());
        
        
        
    }
    
}
