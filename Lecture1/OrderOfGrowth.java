/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureandalgorithms;

/**
 *
 * @author uzaycetin
 */
public class OrderOfGrowth {
    public static void f(int N){
        while(N>1)
            N = N / 2;
    }
    
    public static void g(int N){
        if (N==0) return;
        g( N / 2);
        g( N / 2);
        for (int i = 0; i < N; i++);
    }
    
    public static void e(int N){
        if (N==0) return;
        e(N-1);
        e(N-1);
    }
    public static void main(String[] args) {
        int N = 30;//Java int:int is 32 bit signed type ranges from –2,147,483,648 to 2,147,483,647.
        

        StopWatch timer3 = new StopWatch();
        e(N);
        System.out.printf("e takes (%.5f seconds)\n", timer3.elapsedTime());
    }
    
}
