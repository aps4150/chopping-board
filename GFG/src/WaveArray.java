import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * GFG
 * https://practice.geeksforgeeks.org/problems/wave-array/0/?ref=self
 */

public class WaveArray {

    public static void main(String args[]) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        String input;
        int N;

        StringBuffer buffer = new StringBuffer();
        String[] arr;
        String t;
        while(T-- > 0 ) {

            N = Integer.parseInt(reader.readLine());
            input = reader.readLine();

            arr = input.split(" ");

            for (int i = 0; i < N-1; i ++) {
                if(i%2==1){
                    continue;
                }
                t = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = t;
            }
            for (int i = 0; i < N; i ++) {
                buffer.append(arr[i] + " ");
            }
            System.out.println(buffer);
            buffer.setLength(0);
        }
    }
}
