package Lecture6;
/**
 *
 * @author uzaycetin
 */
public class PeakFinder {
    
    public static int peakFinder(int[] a){
        int mid = a.length/2, start = 0, end = a.length-1;
        
        // Control bounds
        if(a[0] > a[1]) return 0;
        if(a[a.length-1] > a[a.length-2]) return a.length-1;

        while(start >-1 && end <a.length){
            mid = start + (end - start) / 2;
            
            System.out.println(a[mid]);
            
            if(mid+1 == a.length-1 || mid-1 == 0) break; // Control bounds
            
            if(mid+1 <= a.length-1 && a[mid+1] > a[mid]) 
                start = mid + 1 ; // look right
            else if(a[mid-1] > a[mid]) 
                end = mid - 1 ; // look left
            else return  a[mid] ; 
        }
        return -1;
    }
    

    
    public static void display(int[] a){ 
        for(int i = 0; i<a.length;i++)
            System.out.print(" " + a[i]);
        System.out.println("\n");
    }
    
    public static void main(String[] args) {
        int[] a = {8,9,10,9,8,7,6,5,4,3,2,3,1};
        System.out.println("Peak is "+ PeakFinder.peakFinder(a));    
        
      
        
    }
}
