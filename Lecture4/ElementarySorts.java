package Lecture4;
/**
 *
 * @author uzaycetin
 */
public class ElementarySorts {
    /**
     * Selection Sort
     * Selection part: Find the index of i'th smallest item in the array a, call it min
     * Exchange Part : Exchange item at index min, with i'th entry
     * @param a 
     */
    public static void selectionSort(Comparable[] a) {
        // Sort a[] into increasing order.
        int N = a.length; // array length
        for (int i = 0; i < N; i++) { // Exchange a[i] with smallest entry in a[i+1...N).
            int min = i; // index of minimal entr.
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exchange(a, i, min);
        }
    }
    
    /**
     * Insertion Sort
     * Go forwards    : From second item to the last item advance one by one, get current i'th item
     * Go backwards   : From current ith item, go backwards as long as it is larger (by repetitive backward exchanges)
     * Insertion Part : Insert Item to its place
     * @param a 
     */
    public static void insertionSort(Comparable[] a) { // Sort a[] into increasing order.
        int N = a.length;
        for (int i = 1; i < N; i++) { // Insert a[i] among a[i-1], a[i-2], a[i-3]... ..
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exchange(a, j, j - 1);
            }
        }
    }
    
    /**
     * Helper function
     * @param v
     * @param w
     * @return true if v is less than w, false ow
     */
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * Helper Function to swap items
     * @param a
     * @param i
     * @param j 
     */
    private static void exchange(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) { // Print the array, on a single line.
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
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
        String quote = "Art is a lie that tells the truth Picassso";
        String[] a = quote.split(" ");
        insertionSort(a);
        assert isSorted(a);
        show(a);
        
        System.out.println("\n----Don't Forget to make your strings lowercase---");
        String[] l = quote.toLowerCase().split(" ");
        insertionSort(l);
        assert isSorted(l);
        show(l); 
        
        System.out.println("b".compareTo("a"));
        
    }
}
