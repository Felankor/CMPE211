package Lecture10;



/**
 * Binary Search Tree redBlackBST
 * @author uzaycetin
 */
public class redBlackBST<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root; // root of redBlackBST
    // Inner class
    private class Node {
        private Key key; // key
        private Value val; // associated value
        private Node left, right; // links to subtrees
        boolean color; // color of the link from the parent

        public Node(Key key, Value val, boolean color) {
            this.key = key;
            this.val = val;
            this.color = color;
        }
        public String toString(){return " ("+key+ ":"+ val + ") ";}
    }
    ////////////////////////////////////////////////////////////////////////////
    private boolean isRed(Node x) {
            if (x == null) return false;
            return x.color == RED;
    }
    public String getRoot(){
        return root.toString();
    }

    Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }
    Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;

        return x;
    }
    void flipColors(Node h){
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }
    ///////////////////////////////////////////////////////////////////////////
    //\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\// 
    /**
     * deleteMin().
     * we go left until finding a Node
     * that has a null left link and then replace the link to that node by
     * its right link (simply by returning the right link in the recursive
     * method). 
     */
    public void deleteMin(){root = deleteMin(root);}
    private Node deleteMin(Node x){
        if (x.left == null) return x.right; // min is the node without left child
        x.left = deleteMin(x.left); // advance untill min is found
        return x;
    }
    
    public void delete(Key key){ root = delete(root, key); }
    private Node delete(Node x, Key key) {
        // node to be deleted can not found
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            // if less go left
            x.left = delete(x.left, key);
        } else if (cmp > 0) {
            // if greater go right
            x.right = delete(x.right, key);
        } else {
            // x is the node to be deleted
            // easy case zero or one child
            if (x.right == null) {// maybe one child at left, return it or null
                return x.left;
            }
            if (x.left == null) {// maybe one child at right, return it or null
                return x.right;
            }
            // hard case two childs
            Node t = x; // t and x are the nodes to be deleted
            x = min(t.right); // x is min at the right subtree
            x.right = deleteMin(t.right); 
            // x.right becomes a new subtree after removal of its min
            x.left = t.left; // nobody is pointing to t
        }
        return x;
    }

    
    
    ////////////////////////////////////////////////////////////////////////////
    //\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//
    // Recursive Show: inorder traversal.
    public void show(){
        show(root);
        System.out.println();
    }
    public void show(Node x){
        if(x == null) return;
        show(x.left);
        System.out.print(" ("+x.key+ ":"+ x.val + ") ");
        show(x.right);
    }
    //\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//
    ////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////
    //\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//     
    public Node min(){
        return min(root);
    }
    public Node min(Node x){
        if(x.left == null) return x;
        return min(x.left);
    }
    //\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//
    ////////////////////////////////////////////////////////////////////////////
      
    ///////////////////////////////////////////////////////////////////////////
    //\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\// 
    public String max(){
        return max(root);
    }
    public String max(Node x){
        if(x.right== null) return " ("+x.key+ ":"+ x.val + ") ";
        return max(x.right);
    }
    //\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//
    ////////////////////////////////////////////////////////////////////////////
   
    
    
    ////////////////////////////////////////////////////////////////////////////
    //\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//
    // public search calls for private search
    public Value get(Key key) {
        // search inside the tree from the root. 
        // Note that: (private) root is invisible outside the tree
        return get(root, key);
    }
    /**
     * Private Search: Recursive Search Algorithm
     * Return value associated with key in the subtree rooted at x
     * @param x : root node of the subtree
     * @param key : search key
     * @return : value if key is found, null otherwise
     */
    private Value get(Node x, Key key) { 
        // return null if subtree is empty 
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        // search recursively in the appropriate subtree
        // if less, go left
        if (cmp < 0) {
            return get(x.left, key); // move left subtree, if key is smaller
        } 
        // if greater, go right
        else if (cmp > 0) {
            return get(x.right, key); // move right subtree, if key is smaller
        } 
        // if found, return value
        else {
            return x.val; // return value if found at the root of the subtree
        }
    }
    //\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//
    ////////////////////////////////////////////////////////////////////////////
    
    
    

    
    ////////////////////////////////////////////////////////////////////////////
    //\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//
    // public insert call
    public void put(Key key, Value val)
    { // Search for key. Update value if found; grow table if new.
        root = put(root, key, val);
        root.color = BLACK;
    }
    private Node put(Node h, Key key, Value val){
        if (h == null) // Do standard insert, with red link to parent.
            return new Node(key, val, RED);
        int cmp = key.compareTo(h.key);
        if (cmp < 0) 
            h.left = put(h.left, key, val);
        else if (cmp > 0) 
            h.right = put(h.right, key, val);
        else 
            h.val = val;
        
        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);
        return h;
    }
    //\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//
    ////////////////////////////////////////////////////////////////////////////
    
    
    
    
    
    
    
    
    
    
    
     public static void main(String[] args) {
        redBlackBST<String, Integer> st;
        st = new redBlackBST<>();
        
        String str = "search example".replace(" ","").toUpperCase();
        String[] keys = str.split("");

        for (int i = 0; i < keys.length; i++) {
            st.put(keys[i], i);
           System.out.println("Root: " + st.getRoot());
            
        }

        st.show();
        st.delete("A");
        st.show();
        System.out.println("Root: " + st.getRoot());
        
        System.out.println("Min: " + st.min());
        System.out.println("Max: " + st.max());

    }
}
