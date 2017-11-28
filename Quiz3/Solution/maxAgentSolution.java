package Q3;

import java.util.Arrays;

/**
 * Simple Agent with an unordered memory
 * @author uzaycetin
 */
public class maxAgentSolution {
    // capacity
    int M;
    
    // memory stores id of items
    Integer [] memory;
    

    
    // Constructor
    public maxAgentSolution(int capacity){
        M = capacity;
        memory = new Integer[M];
        
        // Fill memory with random numbers from 0 to 2M-1
        for(int i = 0; i < M; i++){
             int item = randomInt(0,2*M);
             
             // prevent dublicate values
             while(control(item, 0, i) != -1) {
                 item = randomInt(0,2*M);
             }  
             memory[i] =item;
        }
        
        Arrays.sort(memory);
    }
    
    
    // generate random integer number from [a,b-1]
    public static int randomInt(int a, int b){
        return a + (int) ((b-a) * Math.random());
    }
    
    // Does item exist in the memory\ lokking though from "from" to "to". (linear search)
    public int control(int item, int from, int to){
        // Implement with a linear search
        for(int i = from; i < to; i++){
            if(memory[i] == item)
                return i;
        }
        return -1;
    }
    
    // Does item exist in the memory. (reqires sorted array!!)
    public int know(int item){
        return Arrays.binarySearch(memory, item);
    }
    
    // Learn new item. 
    // put at the begining
    // exchange with next item as long as it is greater
    public void learn(int item){
        if(know(item) < 0){ 
            memory[0] = item;
            for(int f = 0; f < M-1;f++)
                if(memory[f] > memory[f+1])
                    exch(f,f+1);
                else
                    break;

        }
    }
    
    // exchange/swap
    private void exch(int i, int j) {
        int swap = memory[i];
        memory[i] = memory[j];
        memory[j] = swap;
    }
    
    // 3 - To - Do: return random item from the range [M/2,M]
    public int recommend(){
        return memory[randomInt(M/2,M)];
    }
    
    public void show(){
        for(int i = 0; i < M; i++){
            System.out.print(" " + memory[i]);
        }
        System.out.println();
    }
    
    /**
     * Simulation of a population composed of simple agents.
     * Agents recommend "an item from their memory" at RANDOM to other agents.
     * As a result the memory content of agents change gradually.
     * 
     * @param args 
     */
    public static void main(String[] args){
        int time = 10000000;
        int N = 10; // population size
        int capacity = 3;
        
        System.out.println("\n1.Initialize Population");
        // 1.Initialize Population
        maxAgentSolution[] population = new maxAgentSolution[N];
        for(int i = 0; i < N; i++){
            population[i] = new maxAgentSolution(capacity);
            population[i].show();
        }
        
        
        System.out.println("\n2.Interaction");
        // 2. Interact: Agents interact with each other
        for(int i = 0; i < time; i++){
            // Select two agents at random
            maxAgentSolution a1 = population[randomInt(0,N)];
            maxAgentSolution a2 = population[randomInt(0,N)];
            
            if(a1 == a2) continue;
            
            // agent learns what the other recommends 
            a2.learn(a1.recommend());
            a1.learn(a2.recommend());
        }
        
        
       // 3. End of Simulation
        System.out.println("\n\nAt the end of Simulation");
        for(int i = 0; i < N; i++){
            population[i].show();
        }
    }
    
}
