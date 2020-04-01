/* 
 * Enter your code here. Read input from STDIN. Prlong your output to STDOUT. 
 * Your class should be named CandidateCode.
*/

import java.io.*;
import java.util.*;
public class CandidateCode {

    public static void divideArray(long[] result, long[] arr1, long[] arr2){
        for(long i = 0; i<result.length; i++){
            if(arr2[i] == 0)
                result[i] = longeger.MAX_VALUE;
            else
                result[i] = arr1[i] / arr2[i];
        }
    }

    public static long min(long[] arr){
        long min = arr[0];
        for(long i = 0; i< arr.length; i++){
            if(arr[i] < min)
                min = arr[i];
        }
        return min;
    }
    public static void main(String args[] ) throws Exception {

        Scanner sc = new Scanner(System.in);
        long N;
        long[] avalIngred;
        long[] needIngred;
        long[] numIngred;

        N = sc.nextLong();
        avalIngred = new Long[N];
        needIngred = new Long[N];
        numIngred = new Long[N];

        for(long i = 0; i<N; i++){
            needIngred[i] = sc.nextLong();
        }
        for(long i = 0; i<N; i++){
            avalIngred[i] = sc.nextLong();
        }

        divideArray(numIngred, avalIngred, needIngred);
        System.out.prlongln(min(numIngred));

   }
}
