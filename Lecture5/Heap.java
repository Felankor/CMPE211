/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lecture5;

/**
 *
 * @author uzaycetin
 */
public class Heap {

    // This class should not be instantiated.
    private Heap() { }
    
    public static int parent(int k){return k/2;}
    public static int fistChild(int k){return 2*k;}
    public static int secondChild(int k){return 2*k+1;}

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param pq the array to be sorted
     */
    public static void sort(Comparable[] pq) {
        int n = pq.length;
        
        // Heapify: Higher in hierarchy (parent) higher in value
        //          sink all the nodes that are not leaf
        //          result is max Heap: 
        for (int k = n/2; k >= 1; k--)
            sink(pq, k, n);
        
        // Sort : Exchange root(1) = max entries, with bottom entry
        //        sink new root(1) to guarantee heapify (Higher in hierarchy (parent) higher in value)
        while (n > 1) {
            exch(pq, 1, n--);
            sink(pq, 1, n);
        }
    }

   /***************************************************************************
    * Helper functions to restore the heap invariant.
    ***************************************************************************/

    private static void sink(Comparable[] pq, int k, int N) {
        while (fistChild(k) <= N){
            int child = fistChild(k);
            if (child < N && less(pq, child, child+1)) 
                child++; // select bigger child
            if (!less(pq, k, child)) break;
            exch(pq, k, child);
            k = child;
        }
    }

   /***************************************************************************
    * Helper functions for comparisons and swaps.
    * Indices are "off-by-one" to support 1-based indexing.
    ***************************************************************************/
    private static boolean less(Comparable[] pq, int i, int j) {
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }

    private static void exch(Object[] pq, int i, int j) {
        Object swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }

    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {System.out.print(a[i] + " ");}
        System.out.println();
    }

    /**
     * Reads in a sequence of strings from standard input; heapsorts them; 
     * and prints them to standard output in ascending order. 
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {;
        Integer[] a = {5,4,9,6,7,2,1,4};
        Heap.sort(a);
        show(a);
    }
}
