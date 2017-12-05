package Lab5;


/**
 * Binary Search Tree BST
 * @author uzaycetin
 */
public class BST_lab<Key extends Comparable<Key>, Value> {
    private Node root; // root of BST
    // Inner class
    private class Node {
        private Key key; // key
        private Value val; // associated value
        private Node left, right; // links to subtrees

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
        
        public String toString(){
        // To-Do 1
        //      return content of the root as a string
            return "";
        }
    }
    ////////////////////////////////////////////////////////////////////////////
    
    public String getRoot(){
        // To-Do 2
        //      return content of the root
        return "";
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
        // To-Do 3
        //      search the node to be deleted
        
        // To-Do 4
        //      if it has one or zero child, how to delete?
        
        // To-Do 5
        //      if it has two children, how to delete? 
        //      use deleteMin()
        

        return x;
    }

    
    
    ////////////////////////////////////////////////////////////////////////////
    //\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//
    // Recursive Show: inorder traversal.
    public void show(){
        // To-Do 5
    }
    private void show(Node x){
        // To-Do 6
    }
    //\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//
    ////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////////////////
    //\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//     
    public Node min(){
        // To-Do 7
        return null;
    }
    public Node min(Node x){
        // To-Do 8
        return null;
    }
    //\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//
    ////////////////////////////////////////////////////////////////////////////
      
    ///////////////////////////////////////////////////////////////////////////
    //\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\// 
    public String max(){
        // To-Do 9
        return null;
    }
    public String max(Node x){
        // To-Do 10
        return null;
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
        // To-Do 11
        //      return null if subtree is empty 
        // To-Do 12
        //      if less, go left
        // To-Do 13
        //      if greater, go right
        // To-Do 14
        //      if found, return value      

        return null;
    }
    //\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//
    ////////////////////////////////////////////////////////////////////////////
    
    
    

    
    ////////////////////////////////////////////////////////////////////////////
    //\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//
    // public insert call
    public void put(Key key, Value val) { 
        root = put(root, key, val);
    }
    /**
     * Public insert call:
     * Recursive logic: 
     *  if empty, return new node to the call
     *  ow compare with node x, update x's left or right link
     * @param x : root node of the subtree
     * @param key : key-value pair to be inserted
     * @param val : key-value pair to be inserted
     * @return 
     */
    private Node put(Node x, Key key, Value val) {
        // Insertion occurs only at the bottom, return new node  
        if (x == null) {
            return new Node(key, val); // node count N is 1
        }
        // compare search key against the root node x
        int cmp = key.compareTo(x.key);
        // update link from parent x to its child
        if (cmp < 0) {
            // set left link, to the resulting left subtree after insertion
            x.left = put(x.left, key, val);
        } else if (cmp > 0) {
            // set right link, to the resulting right subtree after insertion
            x.right = put(x.right, key, val);
        } else {
            // update already-existing key with new value
            x.val = val;
        }
        return x;
        // To-Do 15
        //      trace how insertion works, step by step   
    }
    //\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//\\////\\//
    ////////////////////////////////////////////////////////////////////////////
    
    
    
    
    
    
    
    
    
    
    
     public static void main(String[] args) {
        BST_lab<String, Integer> st;
        st = new BST_lab<>();
        
        String str = "search example".replace(" ","").toUpperCase();
        String[] keys = str.split("");

        // To-Do 16
        //      Fill binary search tree with keys[]
        
        // To-Do 17
        //      Draw the tree on a paper
        
        // To-Do 18
        //      show the contents in order    
        
        // To-Do 19
        //      show min and root after removal of E
        
        // To-Do 20
        //      show min and root after removal of A
    }
}
