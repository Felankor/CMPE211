package Lecture4;
/**
 *
 * @author uzaycetin
 */
public class IntermediateSorts {
    /**
     * An Extension to Insertion Sort
     * Insertion-code is modified to decrement by h instead of 1 when moving through the array
     * @param a
     * @param h 
     */
    public static void insertionSort(Comparable[] a, int h) { // Sort a[] into increasing order.
        int N = a.length;        
        // h-sort the array.
        for (int i = h; i < N; i++) { // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
            for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                //Exchanges takes places between every h distant pairs, not only adjacent items
                exchange(a, j, j - h);
            }
        }
    }
     /**
     * Here exchange takes place for only adjacent items.
     * We obtain the original insertion sort
     * @param a 
     */
    public static void insertionSort(Comparable[] a) { // Sort a[] into increasing order.
        insertionSort(a,1);
    }
    
    /**
     * ShellSort
     *      Fast algorithm based on Insertion sort
     *      insertionSort works pretty good for partially sorted arrays!!
     *      ShellSort gain its power from this.
     * @param a 
     */
    public static void shellSort(Comparable[] a){
        int N = a.length, h = 1;
        while (h < N/3) h = 3*h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
        // For different h values we sort array a, result will be a partially sorted array
        while (h > 1){
            insertionSort(a,h);
            h = h/3;
        }
        // Final touch is the original insertion sort..
        insertionSort(a);
    }
    ///////////////////////////////////////////////////////////////////////////////////////

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
        show(a, a.length);
    }
    
    public static void show(Comparable[] a, int N) { // Print the array, on a single line.
        for (int i = 0; i < N; i++) {
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
        shellSort(a);
        assert isSorted(a);
        show(a);
        
        System.out.println("\n----Don't Forget to make your strings lowercase---");
        String[] l = quote.toLowerCase().split(" ");
        shellSort(l);
        assert isSorted(l);
        show(l); 
        
    }
}
