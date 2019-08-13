import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Sapient_HackerEarth_1 {

    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long arr[] = new long[N];
        for(int i=0; i<N; i++)
            arr[i] = sc.nextLong();
        long out = solve(arr, N);
        System.out.println(out);
    }

    public static long solve(long[] arr, long N){

        Arrays.sort(arr);

        HashMap<Long, Long> map = new HashMap<>();
        long sq;

        long res = 0l;

//        for (int i = 0; i < N; i++) {
//
//            s = Math.sqrt((int)arr[i]);
//            sq= (long)s;
//
//            if(s - ((int)s) == 0d) {
//                if (map.containsKey(sq)) {
//                    map.put(sq, map.get(sq) + 1);
//                } else {
//
//                    if (s - ((int) s) == 0d) {
//                        map.put(sq, 1L);
//                    }
//                }
//            }
//
//        }
        long s = 0L;
        for (int i = 0; i < N; i++) {

            if(arr[i]==1)
            {
                long x = map.get(arr[i]);
                s = x * (x-1);
                continue;
            }
            if(map.containsKey(arr[i]))
            {
                res+= map.get(arr[i]);
            }

        }

        return res+s;

    }

}
