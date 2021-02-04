import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {


    

    // Complete the braces function below.
    static String[] braces(String[] values) {

        String[] res = new String[values.length]; 
        int i = 0 ; 
        for(String brackets : values){
             res[i++] = balanced(brackets) ? "YES" : "NO"; 
            }
            return res ; 
        }
        
    static boolean balanced(String b){
        if(b.length()==1){
            return false ; 
        }
        System.out.println("String - " + b) ;

        char[] open  = { '(' , '[' , '{' } ; 
        char[] close = { ')' , ']' , '}' } ; 
        boolean flag = true ; 
        System.out.println(Arrays.asList(open)) ; 
        Stack<Character> stack = new Stack<Character>() ;
        for(int i = 0 ; i<b.length() ; i++)
        {
            System.out.println("ele -  " + b.charAt(i)) ;

            if(contains(open , b.charAt(i))) {
                stack.push(b.charAt(i)); 
                System.out.println("pushing - " + b.charAt(i)) ;
            }
            else if(contains(close , b.charAt(i))) {
                if(!stack.isEmpty() && ( new String(open).indexOf(stack.peek()) == 
                    new String(close).indexOf(b.charAt(i)) )){
                if(!stack.isEmpty()) 
                    {
                        stack.pop(); 
                    }
                System.out.println("popping - " + b.charAt(i)) ;

                }
                else{
                    flag = false ;
                    break ; 
                }
            }
        } 
        if(stack.isEmpty() && flag==true){
            return true ; 
        }
        else{
            return false ; 
        }
    }
    
    static boolean contains(char[] open , char chr){
        boolean contains = false;
        for (char c : open) {
            if (c == chr) {
                contains = true;
                break;
            }
        }
        return contains ; 
    }

    private static final Scanner scanner = new Scanner(System.in);