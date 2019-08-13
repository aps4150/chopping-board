package hard;

import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/maximum-index/0/?ref=self
 */
public class MaximumDifferenceIndex {

    public static void main (String[] args) {

        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        int n;
        int a[];

        while(T-- > 0)
        {
            n = s.nextInt();
            a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = s.nextInt();
            }

            System.out.println(printRes(a));
        }

    }

    private static int printRes(int[] a) {

        int res = 0;

        for (int i = a.length-1; i > 0 && res < 1; i--) {
            for (int j = 0; j+i < a.length && res < 1 ; j++) {
                if(a[j]<=a[j+i])
                {
                    res = i;
                }
            }
        }

        return res;
    }
}
