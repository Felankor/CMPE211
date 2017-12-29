package Q5;


/**
 *
 * @author uzaycetin
 */
public class HashST<Key, Value> {

    private int N; // number of key-value pairs in the table
    private int M; // size of linear-probing table
    private Key[] keys; // the keys
    private Value[] vals; // the values

    public HashST() {
        this(16);
    }
    public HashST(int M) {
        this.M = M;
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }
    
    private void resize(int cap) {
        HashST<Key, Value> t;
        t = new HashST<>(cap);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                t.put(keys[i], vals[i]);
            }
        }
        keys = t.keys;
        vals = t.vals;
        M = t.M;
    }
    
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }
    
    public boolean contains(Key key) {
        return get(key) != null;
    }
    public int size() {
        return N;
    }
    public Key[] keys(){
        return this.keys;
    }

    /**
     * If a new key hashes to an empty entry, it is stored there; 
     * if not, we scan sequentially to find an empty position.
     * @param key
     * @param val 
     */
    public void put(Key key, Value val) {
        if (N >= M / 2) { resize(2 * M);} // double M (see text) 
        int i;
        //uses empty spaces (marked by null) to terminate clusters of keys. If
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
    }
    
    public void delete(Key key) {
        if (get(key) == null) {return;}
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % M;
        }
        keys[i] = null;
        vals[i] = null;
        i = (i + 1) % M;
        while (keys[i] != null) {
            Key keyToRedo = keys[i];
            Value valToRedo = vals[i];
            keys[i] = null;
            vals[i] = null;
            N--;
            put(keyToRedo, valToRedo);
            i = (i + 1) % M;
        }
        N--;
        if (N > 0 && N == M / 8) resize(M / 2);
    }
}
