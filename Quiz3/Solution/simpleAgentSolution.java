package Q3;
/**
 * Simple Agent with an unordered memory
 * @author uzaycetin
 */
public final class simpleAgentSolution {
    // capacity
    int M;
    // memory stores id of items
    int [] memory;
    
    // Constructor
    public simpleAgentSolution(int capacity){
        M = capacity;
        memory = new int[M];
        
        // Fill memory with random numbers from 0 to 2M-1
        for(int i = 0; i < M; i++){
             int item = randomInt(0,2*M);
             
             // prevent dublicate values
             while(know(item) != -1) 
                 item = randomInt(0,2*M);  
             
             memory[i] =item;
        }
    }
    
    // generate random integer number from [a,b-1]
    public static int randomInt(int a, int b){
        return a + (int) ((b-a) * Math.random());
    }
    
    // 1 - To - Do: Does item exist in the memory. 
    public int know(int item){
        // Implement with a linear search
        for(int i = 0; i < M; i++){
            if(memory[i] == item)
                return i;
        }
        return -1;
    }
    
    // 2 - To - Do: Learn new item. 
    public void learn(int item){
        // To - Do: Use randomInt() function!!
        if(know(item) == -1){
            int f = randomInt(0,M);
            memory[f] = item;
        }
    }
    
    // 3 - To - Do: return a random item from the memory
    public int recommend(){
        // To - Do: Use randomInt() function!!
        int r = randomInt(0,M);
        return memory[r];
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
        int time = 1000000;
        int N = 10; // population size
        int capacity = 5;
        
        // 1.Initialize Population
        simpleAgentSolution[] population = new simpleAgentSolution[N];
        for(int i = 0; i < N; i++){
            population[i] = new simpleAgentSolution(capacity);
            population[i].show();
        }
        
        
        // 2. Interact: Agents interact with each other
        for(int i = 0; i < time; i++){
            // Select two agents at random
            simpleAgentSolution a1 = population[randomInt(0,N)];
            simpleAgentSolution a2 = population[randomInt(0,N)];
            
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
