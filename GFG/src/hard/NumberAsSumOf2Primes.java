package hard;

/**
 * https://practice.geeksforgeeks.org/problems/return-two-prime-numbers/0
 */

import java.util.Scanner;

public class NumberAsSumOf2Primes {

    static int N = 100001;
    static boolean isPrime[] = new boolean[N];


    static void SieveOfEratosthenes()
    {
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i < N; i++)
            isPrime[i] = true;

        for (int p = 2; p * p < N; p++)
        {
            if (isPrime[p] == true)
            {
                for (int i = p * p; i < N; i += p)
                    isPrime[i] = false;
            }
        }
    }

    static void findPrimePair(int n)
    {
        for (int i = 2; i < n; i++)
        {
            if (isPrime[i] && isPrime[n - i])
            {
                System.out.println(i + " " + (n - i));
                return;
            }
        }
    }

    public static void main (String[] args) {

        SieveOfEratosthenes();

        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        int n;

        while(T-- > 0)
        {
            n = s.nextInt();
            findPrimePair(n);
        }

    }
}