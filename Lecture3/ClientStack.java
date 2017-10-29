/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lecture3;

/**
 *
 * @author uzaycetin
 */
public class ClientStack {
    public static void main(String [] args){
        Stack<String> s = new Stack<String>();
        s.push("To");
        s.push("Be");
        s.push("Or");
        s.push("Not");
        s.push("To");
        s.push("Be");
        s.pop();
        
        s.display();
    }
}
