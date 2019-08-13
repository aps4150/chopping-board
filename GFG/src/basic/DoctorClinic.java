package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * GFG
 * https://practice.geeksforgeeks.org/problems/doctors-clinic/0
 *
 * Maths solution:
 * (N, X) -> [ (N-1)*10 ] - [(N-1)*X] or (N, X) -> (N-1) * (10 - X)
 */

public class DoctorClinic {

    public static void main(String args[]) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        String S;
        int N, X, arr[];

        while(T-- >0) {

            S = reader.readLine();

            arr = Arrays.stream(S.split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

            N = arr[0];
            X = arr[1];

            System.out.println((N-1)*(10-X));
        }
    }
}
