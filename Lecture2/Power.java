/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lecture2;

/**
 *
 * @author uzaycetin
 */
public class Power {
    /**
     * Order n
     * @param x
     * @param n
     * @return 
     */
    public long pow(int x, int n){
        if (n == 0) return 1;
        else return x*pow(x,n-1); 
    }
    
    /**
     * ORDER N
     * REDUNDANT CODE for powFasty(x,n/2) is calculated 2 times 
     * @param x
     * @param n
     * @return 
     */
    public long powFasty(int x, int n){
        if (n == 0) return 1;
        if (n%2 == 0) return powFasty(x,n/2)*powFasty(x,n/2); 
        else return x * powFasty(x,n/2)*powFasty(x,n/2);
    }
    
    /**
     * ORDER logN
     * STORE p =  powFast(x,n/2) and CACLCULATE ONLY ONCE
     * @param x
     * @param n
     * @return 
     */
    public long powFast(int x, int n){
        if (n == 0) return 1;
        long p =  powFast(x,n/2);
        if (n%2 == 0) return p*p; 
        else return x * p*p;
    }
    
    //-------------------------------------------------------------------//
    public static void main(String [] args){
        Power p = new Power();
        int x = 2;
        int n = 50;
       
                
        StopWatch timer1 = new StopWatch();
        for(int i=0; i <= 1000000; i++) p.pow(x, n);
        System.out.println(p.pow(x, n));
        double time1 = timer1.elapsedTime();
        System.out.println("Linear Time");
        System.out.printf("%.2f seconds\n", time1);      
        
        StopWatch timer2 = new StopWatch();
        for(int i=0; i <= 1000000; i++) p.powFasty(x, n);
        System.out.println(p.powFasty(x, n));
        double time2 = timer2.elapsedTime();
        System.out.println("Logarithmic Time");
        System.out.printf("%.2f seconds\n", time2);     
        
        
        StopWatch timer3 = new StopWatch();
        for(int i=0; i <= 1000000; i++) p.powFast(x, n);
        System.out.println(p.powFast(x, n));
        double time3 = timer3.elapsedTime();
        System.out.println("Logarithmic Time");
        System.out.printf("%.2f seconds\n", time3);    
    }
    
}
