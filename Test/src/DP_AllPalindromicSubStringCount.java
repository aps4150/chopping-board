/**
 * Original Solution @ https://www.geeksforgeeks.org/count-palindrome-sub-strings-string/
 */
public class DP_AllPalindromicSubStringCount {

    // Returns total number of palindrome substring of
    // length greater then equal to 2
    static int CountPS(char str[], int n)
    {
        // create empty 2-D matrix that counts all palindrome
        // substring. dp[i][j] stores counts of palindromic
        // substrings in st[i..j]
        int dp[][] = new int[n][n];

        // P[i][j] = true if substring str[i..j] is palindrome,
        // else false
        boolean P[][] = new boolean[n][n];

        // palindrome of single length
        for (int i= 0; i< n; i++)
        {
            dp[i][i] = 1;
            P[i][i] = true;
        }

        // palindrome of length 2
        for (int i=0; i<n-1; i++)
        {
            if (str[i] == str[i+1])
            {
                P[i][i+1] = true;
                dp[i][i+1] = 3;
            }
            else
            {
                 dp[i][i+1] = 2;
            }
        }

        // Palindromes of length more then 2. This loop is similar
        // to Matrix Chain Multiplication. We start with a gap of
        // length 2 and fill DP table in a way that gap between
        // starting and ending indexes increases one by one by
        // outer loop.

        boolean flag;
        for (int gap=2 ; gap<n; gap++)
        {
            // Pick starting point for current gap
            for (int i=0; i<n-gap; i++)
            {
                // Set ending point
                int j = gap + i;

                // If current string is palindrome
                if (str[i] == str[j] && P[i+1][j-1] )
                {
                    P[i][j] = true;

                }

                // Add current palindrome substring ( + 1)
                // and rest palindrome substring (dp[i][j-1] + dp[i+1][j])
                // remove common palindrome substrings (- dp[i+1][j-1])
                if (P[i][j])
                    dp[i][j] = dp[i][j-1] + dp[i+1][j] + 1 - dp[i+1][j-1];
                else
                    dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
            }
        }

        // return total palindromic substrings
        printDP(dp);
        return dp[0][n-1];
    }

    private static void printDP(int[][] dp) {

        for (int i = 0; i < dp.length; i++) {

            if(i==0)
            {
                for (int j = 0; j < dp[0].length; j++) {
                    System.out.print( "\t"+j);
                }
                System.out.print("\n");
            }


            for (int j = 0; j < dp[0].length; j++) {
                if(j==0)
                    System.out.print( i+"\t");
                if(i==j)
                    System.out.print( ((dp[i][j] == 0)?"X":"1")+"\t");
                else
                    System.out.print( ((dp[i][j] == 0)?".":dp[i][j])+"\t");
            }
            System.out.println();
        }
    }

    // Driver Method
    public static void main(String[] args)
    {
        String str1 = "abacc";
        String str2 = "ababa";
        String str3 = "aaa";

        System.out.println("\n>>"+CountPS(str1.toCharArray(), str1.length()));
        System.out.println("\n>>"+CountPS(str2.toCharArray(), str2.length()));
        System.out.println("\n>>"+CountPS(str3.toCharArray(), str3.length()));
    }
}