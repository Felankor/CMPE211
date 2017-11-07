package Lecture6;

import java.util.Arrays;

/**
 * This is a simplified version of Jaccard Similarity
 * 
 * @author uzaycetin
 */
public class Jaccard {
    public static double sim(Comparable[] a, Comparable[] b){
        int count = 0;        
        Comparable[] s, h;// s small array, h huge array
        if(a.length < b.length){ s = a; h = b;}
        else { s = b; h = a;}
        
        // sort small array MlogM
        Arrays.sort(s);
        
        // look if elements of huge array exists in the small array
        for(int i = 0; i<h.length; i++){
            if(Arrays.binarySearch(s, h[i]) >= 0) // N times logM
                count++;
        }
        
        System.out.println(count);
        double res = (double)count/(s.length + h.length -count);
        System.out.println("Jaccard Similarity: " + res);
        return res;
    }
    
    /**
     * NOTE THAT: We assume that arrays do not have duplicate values
     * @param args 
     */
    public static void main(String[] args) { 
        Integer [] a = {1,2,3};
        Integer [] b = {7,2,3,4};
        
        double s = sim(a,b);
        
        
        //====================================
        String quote = "the science of 21st century is complexity";
        String[] q1 = quote.toLowerCase().split(" ");
        
        String quote2 = "The 21st century will be guided by algorithms";
        String[] q2 = quote2.toLowerCase().split(" ");
        
        double d = sim(q1, q2);
        

    }
}
