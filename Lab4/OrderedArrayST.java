package Lab4;


/**
 *
 * @author uzaycetin 
 * Binary search (in an ordered array)
 */
public class OrderedArrayST<Key extends Comparable<Key>, Value> {
    //Key extends Comparable<Key> : key support comparaison with other instances 
    //                                 of its own type via comparable interface
    private Key[] keys;
    private Value[] vals;
    private int N;

    public OrderedArrayST(int capacity) {
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

    // Order log_2(n) operation
    public int rank(Key key) {
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
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }
    /////////////////////////////////////////////////////
    public void show() {
        for (int i = 0;i <keys.length; i ++ ) {
            System.out.print("-> (" + keys[i]+ ": "+vals[i] + ")");
        }
        System.out.println("\n");
    }
    
    /////////////////////////////////////////////////////
    public static void main(String[] args) {
        OrderedArrayST<String, Integer> st;
        st = new OrderedArrayST<>(10);
        
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
