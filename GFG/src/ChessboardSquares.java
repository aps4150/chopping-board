import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * GFG
 * https://practice.geeksforgeeks.org/problems/squares-in-nn-chessboard/0
 */

public class ChessboardSquares {

    public static void main(String args[]) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        int t = 0;

        Long res[] = new Long[T];
        int N;
        
        while(t<T) {

            N = Integer.parseInt(reader.readLine());
            res[t++] = findSquares(new Long(N));
        }

        for (int i = 0; i < T; i++) {

            System.out.println(res[i]);
        }
    }

    private static Long findSquares(Long n) {

        return ( n * (n+1) * (2*n + 1))/6;
    }
}
