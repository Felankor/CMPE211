package Lecture2;
/**
 *
 * @author uzaycetin
 */
public class Fibonacci {
    long[] F ; 
    public Fibonacci(){
        
    }
    public Fibonacci(int n){
        F = new long[n+1]; // One more slot to hold Fib(n) at n.slot
        for(int i=0; i <= n; i++) F[i] = -1;
        F[0] = 1;
        F[1] = 1;
    }
    
    //-------------------------------------------------------------------//
    /**
     * Order n
     * @param n
     * @return 
     */ 
    public long iterative(int n){
        long secondPrev = 1;
        long firstPrev = 1;
        long result = 1;
        
        for(int i=2; i <= n; i++){
            result = firstPrev + secondPrev;       
            
            secondPrev = firstPrev;
            firstPrev = result;
        }
        return result;
    }
    //-------------------------------------------------------------------//
     /**
     * Order 2^n ETREMELY SLOW!!
     * @param n
     * @return 
     */
    public long recursive(int n){
        if (n <= 1) return 1;
        else return recursive(n-1) + recursive(n-2); // redundancy 
    }
    //-------------------------------------------------------------------//
     /**
     * Order n GOOD :)
     * @param n
     * @return 
     */
    public long recursiveMemory(int n){
        //if (n <= 1) return 1;
        if (F[n] != -1) return F[n]; // Dont calculate more than once
        F[n] = recursiveMemory(n-1) + recursiveMemory(n-2);
        return F[n]; 
    }
    
    
    
    //-------------------------------------------------------------------//
    public static void main(String [] args){
        Fibonacci fib = new Fibonacci();
        
        int N = 46;
        StopWatch timer1 = new StopWatch();
        System.out.println(fib.iterative(N));
        double time1 = timer1.elapsedTime();
        System.out.printf("%.2f seconds\n", time1);       
        
        
        StopWatch timer2 = new StopWatch();
        System.out.println(fib.recursive(N));
        double time2 = timer2.elapsedTime();
        System.out.printf("%.2f seconds\n", time2);  
        
        
        Fibonacci fibMemo = new Fibonacci(N);
        StopWatch timer3 = new StopWatch();
        System.out.println(fibMemo.recursiveMemory(N));
        double time3 = timer3.elapsedTime();
        System.out.printf("%.2f seconds\n", time3);         
        
    }
    
}
