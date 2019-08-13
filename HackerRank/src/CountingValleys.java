import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CountingValleys {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {

        int valleyCount = 0, level = 0;
        char c ;
        boolean isValley = false;

        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);

            if(c=='U')
            {
                level++;
            }
            else
            {
                level--;
            }

            if(level < 0)
            {
                isValley = true;
            }
            else if(level == 0)
            {
                if(isValley)
                {
                    valleyCount++;
                }
                isValley = false;
            }

        }

        return valleyCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
