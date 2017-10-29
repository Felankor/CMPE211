/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureandalgorithms;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author uzaycetin
 */
public class BinarySearch {
    
    public static int bs(int[] a, int k){
        int mid, start = 0, end = a.length-1;
        while(start <= end){
            mid = start + (end - start) / 2;
 
            //System.out.println("start: " + start + "      mid: " + mid + "      end: " + end);
            
            if(a[mid] == k) return mid;
            if(k > a[mid]) start = mid + 1 ;
            else end = mid - 1 ; 
        }
        return -1;
    }
    
    public static void ls(int[] b, int k){
        for (int i = 0; i < b.length; i++) {
            if(b[i] == k){
                System.out.println("Key found at "+ i);
                break;
            }
        }
    }
    
    public static void display(int[] a){ 
        for(int i = 0; i<a.length;i++)
            System.out.print(" " + a[i]);
        System.out.println("\n");
    }
    
    public static void main(String[] args) {
        int[] a = {2,4,6,7,8,11};
        //System.out.println("Key found at "+ bs(a,8));    
        
        int N = 200000000;//Java int:int is 32 bit signed type ranges from –2,147,483,648 to 2,147,483,647.
        int key = 1223334444;
        int[] b = new int[N];
        Random generator = new Random();
        for (int i = 0; i < N; i++) {
            b[i] = generator.nextInt(10000000);
        }
        b[0] = key;
        Arrays.sort(b); // binary seacrh works on a sorted array
                
        StopWatch timer1 = new StopWatch();
        ls(b,key);
        double time1 = timer1.elapsedTimeInMilSec();
        System.out.printf("linear search (%.5f milli seconds)\n", time1);
        
        
        //display(b);
        StopWatch timer2 = new StopWatch();
        System.out.println("Key found at "+ bs(b,key));
        double time2 = timer2.elapsedTimeInMilSec();
        System.out.printf("binary search (%.5f milli seconds)\n", time2);        
        
    }
}
