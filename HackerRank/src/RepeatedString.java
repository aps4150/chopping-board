import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RepeatedString  {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {

        if(s.indexOf('a')==-1)
            return 0;

        long x = s.length();
        long y = n%x;
        long totalA = 0;
        long fewerA = 0;

        for (int i = 0; i < x; i++) {
            if(s.charAt(i)=='a'){
                if(i<y) { fewerA ++; }
                totalA ++;
            }
        }
        return (n/x) * totalA + fewerA;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}