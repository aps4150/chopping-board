import java.io.IOException;
import java.util.Scanner;

public class JumpingOnTheClouds {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {

        int lastIndex = 0;
        int res = 0;

        int n = c.length;
        while (lastIndex < n-1)
        {
            if(lastIndex+2 < n && c[lastIndex+2]!=1)
            {
                lastIndex+=2;
                res++;
            }
            else if(lastIndex+1 < n && c[lastIndex+1]!=1)
            {
                lastIndex++;
                res++;
            }

        }
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        scanner.nextLine();

        String[] cItems = scanner.nextLine().split(" ");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);
        System.out.println(result);

        scanner.close();
    }
}