/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

import java.util.HashMap;
import java.util.Scanner;

class Sapient_HackerEarth_2 {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        Scanner sc = new Scanner(System.in);

        long L = 0, R = 0;
        int STEP_SIZE = 0;

        L = sc.nextLong();
        R = sc.nextLong();
        STEP_SIZE = sc.nextInt();

        int N = sc.nextInt();
        long arr[] = new long[N];
        for(int i=0; i<N; i++)
            arr[i] = sc.nextLong();
        long out = solve(L, R, STEP_SIZE, arr, N);
        System.out.println(out);
    }

    public static long solve(long L, long R, int STEP_SIZE, long[] arr, long N){

        HashMap<Long, Long> map = new HashMap<>();
        long MAX = arr[0];

        for(int i = 0; i<N; i++)
        {
            if(map.containsKey(arr[i]))
            {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
            else
            {
                map.put(arr[i], 1L);
            }

            if(arr[i]>MAX)
            {
                MAX = arr[i];
            }
        }
        long sumi, sumj;
        sumi = 0l;
        sumj = 0l;
        for(long i = L, j = R; i<=MAX || j<=MAX; i+=STEP_SIZE, j+=STEP_SIZE)
        {
            sumi += ((map.get(i) == null )?0:map.get(i));
            sumj += ((map.get(j) == null )?0:map.get(j));
        }
        System.out.print(sumi+" ");
        return sumj;
    }
}