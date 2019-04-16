/**
 * Minimum steps to delete a string by deleting substring comprising of same characters
 * https://www.geeksforgeeks.org/minimum-steps-to-delete-a-string-by-deleting-substring-comprising-of-same-characters/
 *
 * Input: str = “abcddcba”
 * Output: 4
 * Delete dd, then the string is “abccba”
 * Delete cc, then the string is “abba”
 * Delete bb, then the string is “aa”
 * Delete aa, then the string is null.
 *
 * Input: str = “abc”
 * Output: 3
 */

class DP_StringDeletionByMinSubstringDeletion
{

    static int N = 10;

    // Function to return the minimum number of 
    // delete operations 
    static int findMinimumDeletion(int l, int r,
                                   int dp[][], String s)
    {
        if (l > r)
        {
            return 0;
        }
        if (l == r)
        {
            return 1;
        }
        if (dp[l][r] != 0)
        {
            return dp[l][r];
        }

        // When a single character is deleted 
        int res = 1 + findMinimumDeletion(l + 1, r, dp, s);

        // When a group of consecutive characters 
        // are deleted if any of them matches 
        for (int i = l + 1; i <= r; ++i)
        {

            // When both the characters are same then 
            // delete the letters in between them 
            if (s.charAt(l) == s.charAt(i))
            {
                res = Math.min(res, findMinimumDeletion(l + 1, i - 1, dp, s)
                        + findMinimumDeletion(i, r, dp, s));

            }
        }

        // Memoize 

        //printMatrix(s, dp);

        return dp[l][r] = res;
    }

    // Driver code 
    public static void main(String[] args)
    {
        String s = "abcddcba";
        int n = s.length();
        int dp[][] = new int[n+1][n+1];
        for (int i = 0; i <= n; i++)
        {
            for (int j = 0; j <= n; j++)
            {
                dp[i][j] = 0;
            }
        }
        System.out.println("Minimum steps: "+findMinimumDeletion(0, n - 1, dp, s));

        //System.out.println("FINAL:");
        //printMatrix(s, dp);
    }

    private static void printMatrix(String s, int[][] dp) {

        int n = dp.length-1;

        for (int i = 0; i < n; i++)
        {
            if(i==0)
            {
                System.out.print("\t\\\t");
                for (int j = 0; j < n; j++)
                {
                    System.out.print(s.charAt(j)+"\t");
                }
                System.out.println();
            }

            for (int j = 0; j < n; j++)
            {
                if(j==0)
                    System.out.print(s.charAt(i)+"\t|\t");

                System.out.print(dp[i][j]+"\t");
            }
            System.out.println();
        }

        System.out.println("\n");
    }
} 