/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lecture2;

/**
 * A More Efficient Queue_RemovalOrder1 Implementation On Arrays
      remove() operation order of 1
 * @author uzaycetin
 */
public class Queue_RemovalOrder1 {
    int[] queue ;
    int start = 0, end = 0;
    int size = 0;
    public Queue_RemovalOrder1(int N){
        queue = new int[N];
    }
    
    // add item to the end
    public void add(int item){
        if(size == queue.length) return; //Full => do not add
        queue[end%queue.length] = item; // circular position
        end ++; // end points to the next location
        size ++;  
    }
    // remove from the start
    public int remove(){
        if (size == 0) return -1;// can not remove item from an empty queue
        int item = queue[start];
        start++;
        start = start%queue.length;
        size --; // ORDER of 1, MORE EFFICIENT
        return item;
    }  
    
    public void display(){
        for(int i=0; i<size;i++){
            System.out.print(" " + queue[(start+i)%queue.length]);
        }
        System.out.print("\n\n\n");
    }
  
    
    public static void main(String[] args) {
        Queue_RemovalOrder1 q = new Queue_RemovalOrder1(3);
        q.add(41);
        q.add(1002);
        q.add(33);
        q.remove();
        q.remove();
        q.add(3222);
        q.add(322233);
        q.add(2);
        q.remove();
        
        q.display();
    }
}
