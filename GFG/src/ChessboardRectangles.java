import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * GFG
 * https://practice.geeksforgeeks.org/problems/rectangles-in-nn-board/0/?ref=self
 *
 * Maths solution: https://mba.hitbullseye.com/CAT/Chess-Puzzles.php
 * [ (N+1)C(r) ] * [ (N+1)C(r) ] =
 */

public class ChessboardRectangles {

    public static void main(String args[]) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        int t = 0;

        Long res[] = new Long[T];
        int N;
        
        while(t<T) {

            N = Integer.parseInt(reader.readLine());
            res[t++] = findOnlyRectangles(new Long(N));
        }

        for (int i = 0; i < T; i++) {

            System.out.println(res[i]);
        }
    }

    private static Long findOnlyRectangles(Long N) {

        if(N < 2)
        {
            return 0L;
        }
        return findAllRectangles(N) - findSquares(N);

    }

    private static Long findSquares(Long N) {

        return ( N * (N+1) * (2*N + 1))/6;
    }

    private static Long findAllRectangles(Long N) {

        // Includes Squares

        return N * (N+1) * N * (N+1) /4;

    }
}
