/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lecture4;

/**
 *
 * @author uzaycetin
 */
public class clientIntermediateSorts {
    public static void main(String[] args) { 
        int N = 100000;
        Double[] r = new Double[N];
        Double[] rcopy = new Double[N];
        
        StopWatch timer0 = new StopWatch();
        for(int i=0;i<N;i++) r[i] = Math.random();
        System.out.printf("Creating an array of %d items has taken %.2f seconds\n", N, timer0.elapsedTime());
        
        // We have a copy of r
        for(int i=0;i<N;i++) rcopy[i] = r[i];
        
        StopWatch timer1 = new StopWatch();
        IntermediateSorts.shellSort(r);
        System.out.printf("Shell sort takes %.2f seconds\n", timer1.elapsedTime());
        
        
        StopWatch timer2 = new StopWatch();
        IntermediateSorts.insertionSort(rcopy);
        System.out.printf("Insertion sort takes %.2f seconds\n", timer2.elapsedTime());
        
        // Test the first 10 items after sorting 
        System.out.println("\n\nTest the first 10 items after sorting ");
        IntermediateSorts.show(r, 10);
        IntermediateSorts.show(rcopy, 10);
        
    }  
}
