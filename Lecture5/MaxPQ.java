package Lecture5;
/**
 * Heap Priority Queue
 * Use       : Helps us to develop logarithmic time insert and remove-max operation
 * Structure : Parent is greater than its immediate first and second children
 * Analogy   : In an idealized corporate hierarchy, 
 *                  agent with stronger capabilities becomes superior
 *                  agent with lower capabilities becomes lower in the hierarchy
 * @author uzaycetin
 */

// Key extends Comparable<Key>: 
//        eliminates the distinction between items and keys and
//        we refer to the “largest key” instead of the “item with the largest key.”
public class MaxPQ<Key extends Comparable<Key>>{
    private Key[] pq; // heap-ordered complete binary tree
    private int N = 0; // in pq[1..N] with pq[0] unused
    public MaxPQ(int maxN){ 
        pq = (Key[]) new Comparable[maxN+1]; 
    }
    
    public boolean isEmpty(){ return N == 0; }
    public int size(){ return N; }
    
    public static int parent(int k){return k/2;}
    public static int fistChild(int k){return 2*k;}
    public static int secondChild(int k){return 2*k+1;}
    
    // For MinPQ use greater helper function, or use return pq[i].compareTo(pq[j]) > 0;
    private boolean less(int i, int j){ return pq[i].compareTo(pq[j]) <0; }
    private void exch(int i, int j){ Key t = pq[i]; pq[i] = pq[j]; pq[j] = t; }
    public void show() {
        for (int i = 0; i < pq.length; i++) {System.out.print(pq[i] + " ");}
        System.out.println();
    }
    
    // Bottom-up operation to quarantee heap data structure
    //      Exchange entry k with its successive parents, if less(parent(k), k)
    //      log_2(N) operations 
    // Analogy: agent with stronger capabilities becomes superior
    private void swim(int k){
        while (k > 1 && less(parent(k), k)){
            exch(parent(k), k);
            k = parent(k);
        }
    }
    
    // exchange the node with the larger of its two children.
    // Analogy: agent with lower capabilities becomes lower in the hierarchy
    private void sink(int k){
        while (fistChild(k) <= N){
            int child = fistChild(k);
            if (child < N && less(child, child+1)) 
                child++; // select bigger child
            if (!less(k, child)) break;
            exch(k, child);
            k = child;
        }
    }
    
    // insertion with log_2(N) operations
    public void insert(Key v){
        pq[++N] = v; // a new comer is first inserted to bottom at the hieararchy
        swim(N);     // But he goes up in the hieararchy, as long as its capabilities permits
    }
    
    public Key delMax(){
        Key max = pq[1]; // Retrieve max key from top. 
        //the president of the company resigns and is replaced by someone from the outside
        exch(1, N--); // Exchange with last item.
        pq[N+1] = null; // Avoid loitering.
        sink(1); // Restore heap property.
        return max;
    }
    

    
    public static void main(String[] args) { 
        // Suppose N = a.length is too large
        Integer[] a = {3,2,1,4,9,7};
        // We only store top M elements coming from a[]
        int M = 4;
        MaxPQ<Integer> pq = new MaxPQ<Integer>(M+1);
        pq.show();
        
        for (int i = 0; i < a.length; i++) {
            pq.insert(a[i]);
            if (pq.size() > M)
                 System.out.println(pq.delMax());
        }     
        pq.show();
        


    } 
    
}
