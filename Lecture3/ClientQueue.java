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
public class ClientQueue {
    public static void main(String [] args){
        Queue<String> q = new Queue<String>();
        q.enqueue("One");
        q.enqueue("Two");
        q.enqueue("Three");
        q.dequeque();
        
        q.display();
    }   
}
