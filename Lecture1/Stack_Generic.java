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
public class Stack_Generic<Item> {
    int current = 0;
    Item[] ourStack;
    
    public Stack_Generic(int capacity){
        current = 0;
        ourStack = (Item[]) new Object[capacity];
    }
    
    public void push(Item item){
        if(current<ourStack.length){
            ourStack[current] = item;
            current++;
        }
    }
    
    public Item pop(){
        if(current > 0)
            return ourStack[--current];
        else
            return null;
    }
    
    public boolean isEmpty(){
       return current == 0; 
    }
    
    public int size(){
       return current; 
    }
    
    public void display(){
        for(int i=0; i<this.size();i++)
            System.out.print(" " + ourStack[i]);
        System.out.println("\nsize: " + this.size());
        System.out.print("\n\n\n");
    }
  
    public static void main(String[] args){
        Stack_Generic s = new Stack_Generic(1);
        System.out.println(s.pop());
        s.push(1);
        s.push(2);
        s.push(3);
        s.display();
        System.out.println(s.pop());
        System.out.println(s.pop());
        s.push(4);
        s.push(5);
        s.push(6);
        s.display();
        
        Stack_Generic<Integer> iStack = new Stack_Generic<Integer>(3);
        iStack.pop();
        iStack.display();
        
        Stack_Generic<String> x = new Stack_Generic<String>(3);
        x.pop();
        x.display();
    }
}
