package Q5;

/**
 *
 * @author uzaycetin
 */
public class SparseVector {
    // Implement Sparse Vector Class as an Hash Table
    // This provides constant time search and insertion
    private HashST<Integer, Double> st;
    
    // 1- constructor
    // 2- size
    // 3- put
    // 4- get
    
    // vector-vector dot product
    public double dot(double[] that) {
        double sum = 0.0;
        // 5-   USE: Object[] keys = st.keys();
        //      USE: get((int)keys[i]);
        return sum;
    }
    
    public static void show(double[] that){
        for (int i = 0; i < that.length; i++)
            System.out.print(that[i]+ " ");
        System.out.println();
    }
    
    /////////////////////////////////////////////////////
    public static void main(String[] args) {
        // Do matrix-vector multiplication Ax = b
        // Where matrix A is sparse
        // matrix A is an array of sparse vectors
        int N = 7;
        SparseVectorSol[] A = new SparseVectorSol[N];
        double[] x;
        double[] b;

        // 6- Initialize A[][] and x[]
        // 7- Do matrix-vector multiplication Ax = b
        // 8- show resulting b
    }
}
