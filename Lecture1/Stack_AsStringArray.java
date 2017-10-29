/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureandalgorithms;

/**
 *
 * @author uzaycetin
 */
public class Stack_AsStringArray { 
    int N = 0; // top position
    String[] ourStack;
    
    public Stack_AsStringArray(int capacity){
        N = 0;
        ourStack = new String[capacity];
    }
    
    public void push(String item){
        ourStack[N] = item;
        N++;
    }
    
    public String pop(){
        N--;
        return ourStack[N];
    }
    
    public boolean isEmpty(){
       return N == 0; 
    }
    
    public int size(){
       return N; 
    }
    
    public void display(){
        for(int i=0; i<this.size();i++)
            System.out.print(" " + ourStack[i]);
        System.out.println("\nsize: " + this.size());
        System.out.print("\n\n\n");
    }
  
    public static void main(String[] args){
        Stack_AsStringArray s = new Stack_AsStringArray(10);
        //-- TEST THIS --
        // Stack_AsStringArray s = new Stack_AsStringArray(10); //-- TEST THIS --
        // System.out.println(s.pop()); //-- TEST THIS --
        //-- TEST THIS --
        
        
        s.push("merhaba");
        s.push(" sinif");
        s.push(" nasilsin?");
        s.display();
        String x = s.pop();
        x =  s.pop();
        s.display();
        
        

    }
}
