package Lab4;


/**
 * Linked List implementation of Symbol Table
 */
public class LinkedListST_Lab<Key, Value> {
    // first node in the linked list
    private Node first;

    /////////////////////////////////////////////////////
    // Each node holds 
    //     * key-value pair
    //     * and a reference to anothe node
    private class Node { // linked-list node

        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    /////////////////////////////////////////////////////
    // SEARCH Algorithm
    public Value get(Key key) {
        // To-Do 1
        //      Search, if found return val else return null
        // To-Do 2
        //      Running time? 
        return null; 
    }

    /////////////////////////////////////////////////////
    // Analysis of INSERTION Algorithm
    //      One loop : Order(n)
    public void put(Key key, Value val) {
        // To-Do 3
        //      if key exists in the list, update val
        // To-Do 4
        //      Otherwise, add new node to the begining.
    }

    /////////////////////////////////////////////////////
    public void show() {
        for (Node x = first; x != null; x = x.next) {
            System.out.print("-> (" + x.key+ ": "+x.val + ")");
        }
        System.out.println("\n");
    }
    

    /**
     * Iterative delete function works
     */
    public void del(Key key){
        // To-Do 5
        //      Explain how iterative delete function works
        // To-Do 6
        //      Does it work for first and middle node? Explain how?
        // To-Do 7
        //      Does it work for last node? Explain how?
        if(key.equals(first.key)){
            first = first.next;
            return;
        }
        Node prev = first, current = first;
        if(prev.next != null) current = prev.next;
        while(current != null){
            if(key.equals(current.key)){
                if(current != null)
                    prev.next = current.next;
                return;
            }
            current = current.next;
            prev = prev.next;
        }
        
    }

    /**
     * Recursive Delete Method
     */
    public void delete(Key key) {
        if (key != null) {
            first = delete(first, key);
        }
    }
    private Node delete(Node x, Key key) {
        if (x == null) {
        // To-Do 8
        //      what to do if x == null?
        }
        if (key.equals(x.key)) {
        // To-Do 9
        //      what to do if found?
        }
        // To-Do 10
        //      iterate through the list
        return x;
    }
   
    /////////////////////////////////////////////////////
    public static void main(String[] args) {
        LinkedListST_Lab<String, Integer> st;
        st = new LinkedListST_Lab<>();
        
        String[] keys = {"H", "E", "L", "L", "O"};
                      //  0    1    2    3    4

        for (int i = 0; i < 5; i++) {
            st.put(keys[i], i);
        }

        st.put("X", 8);
        st.show();

        st.put("X", 7);
        st.show();    
        
        st.del("H");
        st.show();  


    }
}
