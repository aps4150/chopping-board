import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



class Result {

    /*
     * Complete the 'rearrange' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY elements as parameter.
     */

    public static List<Integer> rearrange(List<Integer> elements) {

        Collections.sort(elements,  new Comparator<Integer>() {
            @Override
            public int compare(Integer a1, Integer a2) {

                int diff = Integer.bitCount(a1) - Integer.bitCount(a2);
                if(diff == 0)
                {
                    diff = a1 - a2;
                }

                return diff;
            }
        });

        return elements;

    }

    public static void mawin(String a[])
    {
        List<Integer> x = new ArrayList<>();
        x.add(8);
        x.add(5);
        x.add(6);
        x.add(7);

        rearrange(x).stream().forEach(i-> System.out.println(i));
    }

    //Hkr 1

    public static int minimumMoves(List<Integer> a, List<Integer> m) {

       int count = 0;

       for(int i = 0; i < a.size(); i++)
       {
           count += diffCount(a.get(i), m.get(i));
       }

       return count;
    }

    private static int diffCount(Integer i, Integer j) {

        int c = 0;

        while (i>0)
        {
            c += Math.abs(i%10 - j%10);
            i/=10;
            j/=10;
        }
        return c;
    }

    // Hkr 2

    public static int minNum(int threshold, List<Integer> happy) {

        Integer x = threshold + happy.get(0);

        int index = find(x, happy);

        if(index ==-1)
            return happy.size();

        return 1+ (index / 2) + ((index %2==0)?0:1);

    }

    static int find(int x, List<Integer> happy)
    {

        int l = 0, r = happy.size()- 1;
        int ans = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            if (happy.get(m) == x)
            {
                ans = m;
                break;
            }

            if (happy.get(m) < x)
                l = m + 1;
            else
            {
                ans = m;
                r = m-1;
            }
        }
        System.out.println(">>"+ans);
        return ans;
    }



    public static void main(String s[])
    {
        List<Integer> x = new ArrayList<>();
        x.add(1);
        x.add(2);
        x.add(3);
        x.add(30);
        x.add(32);

       // x.add(7);

        System.out.println(minNum(60, x));
        }

}
