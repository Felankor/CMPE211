package Lab4;


/**
 * Array Implementation of Symbol Table
 */
public class OrderedArrayST_Lab<Key extends Comparable<Key>, Value> {
    //Key extends Comparable<Key> : key support comparaison with other instances 
    //                                 of its own type via comparable interface
    private Key[] keys;
    private Value[] vals;
    private int N;

    public OrderedArrayST_Lab(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public int size() {
        return N;
    }
    
    public boolean isEmpty() {
        return size() == 0;
    }
    
    // Search method
    //   uses rank
    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            return vals[i];
        } else {
            return null;
        }
    }

    public int rank(Key key) {
        // To-Do 11
        //      Running time of rank?
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    // Order n
    public void put(Key key, Value val) { // Search for key. Update value if found; grow table if new.
        int i = rank(key);// Search for key.
        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val; // Update value if found
            return;
        }
        for (int j = N; j > i; j--) {
        // To-Do 12
        //      shift every elements to right, from index i to N, 
        //      to make room for new key-val pair
        }
        
        keys[i] = key; // put new key to ith location
        vals[i] = val; // put new val to ith location
        N++;
    }
    /////////////////////////////////////////////////////
    public void show() {
        // To-Do 13
        //      show key-val pair contents like -> (X: 7)-> (O: 4)-> (L: 3)-> (E: 1)
        System.out.println("\n");
    }
    
    /////////////////////////////////////////////////////
    public static void main(String[] args) {
        OrderedArrayST_Lab<String, Integer> st;
        st = new OrderedArrayST_Lab<>(10);
        
        String[] keys = {"H", "E", "L", "L", "O"};
                      //  0    1    2    3    4

        for (int i = 0; i < 5; i++) {
            st.put(keys[i], i);
        }

        st.put("X", 8);
        st.show();

        st.put("X", 7);
        st.show();    
        
    }
}
