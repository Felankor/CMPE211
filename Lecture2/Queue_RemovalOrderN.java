/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lecture2;

/**
 *  A LESS Efficient Queue Implementation On Arrays
 *      remove() operation order of N
 * @author uzaycetin
 */
public class Queue_RemovalOrderN {
    int[] queue ;
    int end = 0;
    public Queue_RemovalOrderN(int N){
        queue = new int[N];
    }
    
    // add item to the end
    public void add(int item){
        if(end == queue.length) return; //Full => do not add
        queue[end] = item; 
        end ++; // end points to the next location 
    }
    // remove from the start
    public int remove(){
        if (end == 0) return -1;// can not remove item from an empty queue
        int item = queue[0]; // always remove the first item
        for(int i=1; i<end;i++){
            queue[i-1] = queue[i]; // Order of N !! Not so efficient
        }
        end--; // // end points to the next location 
        return item;
    }  
    
    public void display(){
        for(int i=0; i<end;i++){
            System.out.print(" " + queue[i]);
        }
        System.out.print("\n\n\n");
    }
  
    
    public static void main(String[] args) {
        Queue_RemovalOrderN q = new Queue_RemovalOrderN(3);
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
