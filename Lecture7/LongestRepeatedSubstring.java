package Lecture7;

import java.util.Arrays;

/**
 *
 * @author uzaycetin
 */
public class LongestRepeatedSubstring {
    // Longest common prefix.
    // Ex: lcp("acaagtttac", "acaagc") = "acaag".
    public static String lcp (String a, String b){
        int i = 0;
        for (; i < a.length(); i++)
            if(a.charAt(i) != b.charAt(i)) break;
        return a.substring(0, i);
    }
    //Given a string, find the longest substring that appears at least twice.
    public static void main(String[] args) {
        String s =  "aacaagtttacaagc";
        int N = s.length();
        
        String[] suffixes = new String[N];
        
        for (int i = 0; i < N; i++)
            suffixes[i] = s.substring(i, N);
        
        Arrays.sort(suffixes);
        for (int i = 0; i < N; i++)
            System.out.println(suffixes[i]);
        
        String lrs = "";
        for (int i = 0; i < N-1; i++) {
            String x = lcp(suffixes[i], suffixes[i+1]);
            if (x.length() > lrs.length()) lrs = x;
        }
        
        System.out.println("\nLongest Repeated Substring:" + lrs);
        
    }
    
}
