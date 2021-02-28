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
     * Complete the 'findSongs' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER rideDuration
     *  2. INTEGER_ARRAY songDurations
     */

    public static List<Integer> findSongs(int rideDuration, List<Integer> songDurations) {
    // Write your code here
        List<Integer> returnList = new ArrayList<>();

        Map<Integer , Integer>  songsIdMap = new LinkedHashMap<>() ; 
        List<Integer> maxDurations = new ArrayList<>() ; 

        int songsTotalDuration = rideDuration - 30 ; 
        
        for ( int i = 0 ; i<songDurations.size()-1 ; i++){
            for ( int j = i+1 ; j<songDurations.size() ; j++ ){
                if(songDurations.get(i)+songDurations.get(j)==songsTotalDuration){
                    songsIdMap.put(i,j);
                    maxDurations.add(Math.max(songDurations.get(i) ,
                     songDurations.get(j))) ; 
                    break;
                }
            }
        }
        if(songsIdMap.size()<1){
            returnList.add(-1);
            returnList.add(-1);
            return returnList;
        }
        
       //get the max duration out of all the possible combinations
        int maxValue = Collections.max(maxDurations) ;
        int index = maxDurations.indexOf(maxValue) ; 
        
        //get the id of songs pair  
        Integer a = ( Integer) songsIdMap.keySet().toArray()[index] ; 
        Integer b = ( Integer) songsIdMap.get(a) ; 

        returnList.add(a);
        returnList.add(b);
       
        return returnList ; 

    }

}
