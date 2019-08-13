package BinarySearchExperiment;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchModified {

    static int find(int x, List<Integer> happy)
    {

        int l = 0, r = happy.size()- 1;
        int m1, m2, i1, i2, ans;
        ans = -1;

        while (l <= r) {
            m1 = l + (r - l) / 3;
            m2 = l + ((r - l) / 3)*2;

            i1 = happy.get(m1);
            i2 = happy.get(m2);

            if (i1 == x)
            { ans = m1; break; }

            if (i2 == x)
            { ans = m2; break; }

            if(x < i1)
            {
                r = m1 - 1;
            }
            else if(x < i2)
            {
                l = m1 + 1;
                r = m2 - 1;
            }
            else
            {
                l = m2 + 1;
            }
        }
        return ans;
    }

    static int find4(int x, List<Integer> happy)
    {

        int l = 0, r = happy.size()- 1;
        int m1, m2, m3, i1, i2, i3, ans;
        ans = -1;

        while (l <= r) {
            m1 = l + (r - l) / 4;
            m2 = l + ((r - l) / 4)*2;
            m3 = l + ((r - l) / 4)*3;

            i1 = happy.get(m1);
            i2 = happy.get(m2);
            i3 = happy.get(m3);

            if (i1 == x)
            { ans = m1; break; }

            if (i2 == x)
            { ans = m2; break; }

            if (i3 == x)
            { ans = m3; break; }

            if(x < i1)
            {
                r = m1 - 1;
            }
            else if(x < i2)
            {
                l = m1 + 1;
                r = m2 - 1;
            }
            else if(x < i3)
            {
                l = m2 + 1;
                r = m3 - 1;
            }
            else
            {
                l = m3 + 1;
            }
        }
        return ans;
    }

    static int find2(int x, List<Integer> happy)
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
            {
                l = m + 1;
            }
            else
            {
                r = m-1;
            }
        }
        return ans;
    }

    public static void main(String s[])
    {
        List<Integer> list = new ArrayList<>();

        for(int k=0; k<50000; k++)
        {
            list.add(k, k);
        }

        long startTime = System.nanoTime();
                int f = find(7000, list);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);


        startTime = System.nanoTime();
                f = find4(7000, list);
        endTime = System.nanoTime();
        long duration2 = (endTime - startTime);

        System.out.println(duration - duration2);
    }
}