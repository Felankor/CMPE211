package Lecture3;
/**
 * Stack Implementation Based On Linked Lists
 * @author uzaycetin
 */
public class Stack<Item> {
    private Node first; // top of stack (most recently added node)
    // Private can not be used by other Client Programs
    private class Node{
        Item item; // Generic Data is kept
        Node next; // Link to Other Node
    }
    // Insert a new Node (holding item) at the Beginning
    public void push(Item item){
        Node oldFirst = first; // first may be null for an empty stack
                               // oldFirst points to the same thing as first
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }
    // Remove (most recently added) item from the Beginning
    public Item pop(){
        Item item = first.item; // item at the top
        first = first.next;     // first changes to the next first node
        return item;
    }
    public void display(){
        for(Node x = first; x != null ; x = x.next){
            System.out.print(x.item + " ");
        }
         System.out.println();
    }
}
