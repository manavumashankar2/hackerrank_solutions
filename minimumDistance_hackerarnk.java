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
     * Complete the 'minimumDistance' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY area as parameter.
     */

    public static int minimumDistance(List<List<Integer>> area) {
    // Write your code here
        int [][] directions = {{0,1} , {1,0} ,{0,-1} ,{-1,0} };

        Integer [][] array = new Integer[area.size()][];
        
        int i = 0 ; 
        for ( List<Integer> nestedList : area ){
            array[i++] = nestedList.toArray(new Integer[nestedList.size()]);
        }
        
        Queue<Coordinates> queue = new ArrayDeque<>() ; 
        //adding starting points
        queue.add(new Coordinates(0, 0));
        array[0][0] = 0 ;
        
        for ( int count = 1 ; !queue.isEmpty() ; count++){
            for( int size = queue.size() ; size > 0  ; size--){
                Coordinates c = queue.poll() ; 
                
                for ( int[] direction : directions ){
                    int x = c.x + direction[0] ; 
                    int y = c.y + direction[1] ; 
                    
                    if(isSafe( array , x , y)){
                        if(array[x][y]==9)
                            return count ; 
                        array[x][y] = 0 ;
                        queue.add(new Coordinates(x, y));
                    }

                }
            }
        }
        return -1 ; 

    }
   
    private static class Coordinates{
        int x ;
        int y ; 
        Coordinates(int x, int y){
            this.x = x ; 
            this.y = y ; 
        }
    } 
    
     private static boolean isSafe(Integer[][] array , int x , int y ){
        return x >=0 && x < array.length && y>=0 && y <array[0].length && array[x][y]!=0 ;
    }

}
