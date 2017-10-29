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
public class mergeSort {

    private static Comparable[] aux; // auxiliary array for merges

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length]; // Allocate space just once.
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) { // Sort a[lo..hi].
        
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid); // Sort left half.
        sort(a, mid + 1, hi); // Sort right half.
        
        //show(a, a.length, mid);
        merge(a, lo, mid, hi); // Merge results (code on page 271).
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) { // Merge a[lo..mid] with a[mid+1..hi].
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) // Copy a[lo..hi] to aux[lo..hi].
        {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) // Merge back to a[lo..hi].
        {
            if (i > mid) { // first half (a[lo..mid]) is all-done
                a[k] = aux[j++];
            } else if (j > hi) { // second half (a[mid+1..hi]) is all-done
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) { // take smallest remaining item from two halves
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void show(Comparable[] a) { // Print the array, on a single line.
        show(a, a.length, -1);
    }

    public static void show(Comparable[] a, int N, int mid) { // Print the array, on a single line.
        for (int i = 0; i < N; i++) {
            System.out.print(a[i] + " ");
            if (i == mid ) System.out.print(" - ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) { // Test whether the array entries are in order.
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) { // Read strings from standard input, sort them, and print.
        String quote = "B X A C D R Y Z E";
        String[] l = quote.toLowerCase().split(" ");
        sort(l);
        assert isSorted(l);
        show(l);

    }
}
