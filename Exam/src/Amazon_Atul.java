import java.util.*;

public class Amazon_Atul {

    public static void main(String args[]) throws Exception
    {
        int numRows = 3;
        int numColumns = 3;
        List<List<Integer>> fl = new ArrayList<>();
        List<List<Integer>> bl = new ArrayList<>();

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        List<Integer> a1 = new ArrayList<>();

        a.add(1);
        a.add(3);

        b.add(2);
        b.add(5);

        c.add(3);
        c.add(8);

        a1.add(1);
        a1.add(2);

        fl.add(a);
        fl.add(b);
        fl.add(c);

        bl.add(a1);

        for(List<Integer> i: minimumDistance(6, fl, bl))
        {
            for( Integer j : i)
            {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    static List<List<Integer>> minimumDistance(int capacity, List<List<Integer>> f, List<List<Integer>> b)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        TreeMap<Integer, Integer> tree = new TreeMap<>();

        List<List<Integer>> res = new ArrayList<>();

        int id, val, target;

        for (int i = 0; i < f.size(); i++) {

            id = f.get(i).get(0);
            val = f.get(i).get(1);

            map.put(val, id);
            tree.put(val, id);
        }

        boolean exactMatchFound = false;

        for (int i = 0; i < b.size(); i++) {

            id = b.get(i).get(0);
            val = b.get(i).get(1);

            target = capacity - val;

            if(map.containsKey(target))
            {
                exactMatchFound = true;

                List<Integer> e = new ArrayList<>();
                e.add(map.get(target));
                e.add(id);

                res.add(e);
            }
        }

        if(!exactMatchFound)
        {
            Integer max = Integer.MIN_VALUE;
            Map.Entry<Integer, Integer> rec;

            for (int i = 0; i < b.size(); i++) {

                id = b.get(i).get(0);
                val = b.get(i).get(1);

                target = capacity - val;
                rec = tree.floorEntry(target);

                if(null == rec)
                    continue;

                if(rec.getValue() > max)
                {
                    max = rec.getValue();

                    res = new ArrayList<>();

                    List<Integer> e = new ArrayList<>();
                    //e.add(tree.get(target));
                    e.add(map.get(rec.getKey()));
                    e.add(id);

                    res.add(e);
                }
                else if(rec.getValue() == max)
                {
                    List<Integer> e = new ArrayList<>();
                    e.add(tree.get(target));
                    e.add(id);

                    res.add(e);
                }
            }
        }

        return res;
    }
}
