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
public class Queue<Item> {
    private Node first;
    private Node last;
    // Private can not be used by other Client Programs
    private class Node{
        Item item; // Generic Data is kept
        Node next; // Link to Other Node
    }
    // Add item to the end of the list.
    public void enqueue(Item item){
        Node oldLast = last; // oldlast points to the same thing as last
        
        last = new Node();   // new Node is created for last
        last.item = item;    // last is filled
        last.next = null;  // Not necessary, last.next is already null
        
        if(first == null) first = last; // if it is the first time we add sthg
        else oldLast.next = last;  
    }
    // Remove item from the beginnig
    public Item dequeque(){
        if (first == null) return null; // Dont remove sthg from an empty queue
        Item item = first.item;         // take item to be removed
        first = first.next;             // point to the next first node
        if(first == null) last = null;  // after removal if first is null, so must be last
        return item; 
    }
    public void display(){
        for(Node x = first; x != null ; x = x.next){
            System.out.print(x.item + " ");
        }
         System.out.println();
    }    
}
