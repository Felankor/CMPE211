/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q5;

/**
 *
 * @author uzaycetin
 */
public class SparseVectorSol {

    private HashST<Integer, Double> st;

    public SparseVectorSol() {
        st = new HashST<Integer, Double>();
    }

    public int size() {
        return st.size();
    }

    public void put(int i, double x) {
        st.put(i, x);
    }

    public double get(int i) {
        if (!st.contains(i)) {
            return 0.0;
        } else {
            return st.get(i);
        }
    }

    public double dot(double[] that) {
        double sum = 0.0;
        Object[] keys = st.keys();
        
        for (int i = 0; i < st.size(); i++)
            sum += that[i] * get((int)keys[i]);

        return sum;
    }
    
    public static void show(double[] that){
        for (int i = 0; i < that.length; i++)
            System.out.print(that[i]+ " ");
        System.out.println();
    }
    
   public static void main(String[] args) {
        int N = 7;
        double[] x = {0.1,0.1,0.1,0.1,0.1,0.25,0.25};
        double[] b = new double[N];

        // A:   a sparse matrix 
        //      represented as an array of SparseVectors
        SparseVectorSol[] A = new SparseVectorSol[N];
        for (int i = 0; i < N; i++)
            A[i] = new SparseVectorSol(); // Each SparseVector is initialised
        
        // Spare vector A[0] corresponds to the array [8, 4, 0, 0, ..., 0]
        //        where A[0][0] = 8 and A[0][1] = 4 and all the rest is 0
        // But since it is a sparse vector
        //           it is a hash table containing 2 elements: [[0|8],[1|4]]
        A[0].put(0, 8);
        A[0].put(1, 4);
          
        for (int i = 0; i < N; i++)
            b[i] = A[i].dot(x);
        show(b);
        
    }
}
