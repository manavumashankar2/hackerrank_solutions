import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'taskOfPairing' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER_ARRAY freq as parameter.
     */

    public static long taskOfPairing(List<Long> freq) {
    // Write your code here
        long rem = 0 ; 
        long cnt = 0 ; 
        if(freq.size()==0){
            return 0 ; 
        }
        for ( long i : freq){
            if(i!=0){
            if(rem==(long)1){
                cnt+=1 ; 
                i = i-1 ; 
            }
            cnt+= i/2 ; 
            
            rem =  ( i % 2 ) ; 
            System.out.println("rem is "+rem + " for i="+i);
            }
            else{
                rem = 0 ; 
            }
        }
        return cnt ; 
    }

}

public class Solution {