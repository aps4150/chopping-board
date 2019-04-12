import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Array_IsSubSetHasGivenSum {

    public static void main(String args[]) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        int i = 0;
        int N;

        String res[] = new String[T];

        while(T-- > 0)
        {
            N = Integer.parseInt(reader.readLine());
            int a[] = new int[N];

            String S = reader.readLine();
            a = Arrays.stream(S.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            boolean boolRes = isSubSetSumZero(a, 0,0, false);
            res[i] = (boolRes==true)?"Yes":"No";
        }

        Arrays.stream(res).forEach(e-> System.out.println(e));

    }

    private static boolean isSubSetSumZero(int[] a, int i, int sum, boolean sumUpdated) {

        //System.out.println(i+"-"+sum+"-"+sumUpdated);

        if(sumUpdated && i != 0 && sum == 0)
            return true;

        if( i < 0 || i >= a.length )
        {
            return false;
        }
        else
        {
            return isSubSetSumZero(a, i+1, sum+a[i], true) || isSubSetSumZero(a, i+1, sum, sumUpdated||false);
        }
    }
}
