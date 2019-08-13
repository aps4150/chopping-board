import java.util.Scanner;

public class Test1 {

    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        */
        Scanner s = new Scanner(System.in);

        String input = s.nextLine();                 // Reading input from STDIN
        int K = Integer.parseInt(input);

        input = s.nextLine();                 // Reading input from STDIN
        String x[] = input.split(" ");
        int num[] = new int[K];
        for (int i = 0; i < K; i++) {
            num[i] = x[i].charAt(0)-48;
        }

        String rule[] =  new String[K];
        for (int i = 0; i < K; i++) {

            input = s.nextLine();
            rule[i] = input;

            num = process(i, rule[i], num);
        }

        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i]+" ");
        }

    }

    private static int[] process(int i, String s, int[] num) {

        int min = num[i];
        int index = i;
        for (int j = 0; j < s.length(); j++)
        {
            if(s.charAt(j)=='Y' && num[j]<min)
            {
                min = num[j];
                index = j;
            }
        }
        int temp = num[i];
        num[i] = num[index];
        num[index] = temp;

        return num;
    }
}
