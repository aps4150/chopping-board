import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Amazon_Add2NoToSumInArray {

    public static void main(String a[])
    {
        ArrayList<Integer> x = new ArrayList<>();
        x.add(80);
        x.add(20);
        x.add(70);
        x.add(90);
        x.add(30);
        x.add(60);
        x.add(50);
        x.add(10);
        x.add(0);
        IDsOfSongs(110, x).stream().forEach(i->System.out.print(i+" "));

        System.out.println();

        ArrayList<Integer> y = new ArrayList<>();
        y.add(80);
        y.add(80);

        IDsOfSongs(190, y).stream().forEach(i->System.out.print(i+" "));

    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    static ArrayList<Integer>  IDsOfSongs(int rideDuration,
                                          ArrayList<Integer> songDurations)
    {
        Integer targetDuration = rideDuration - 30;

        HashMap<Integer, Integer> seenSongDurationMap = new HashMap<>();
        ArrayList<Integer> resultantList = new ArrayList<>();

        if(targetDuration < 0 || null == songDurations)
        {
            return resultantList;
        }

        int min, max, minIndex, maxIndex;
        int s, diff, resultantMax;

        resultantMax = Integer.MIN_VALUE;
        minIndex = maxIndex = -1;

        for(int index = 0; index < songDurations.size(); index++)
        {
            s = songDurations.get(index);
            diff = targetDuration-s;

            if(seenSongDurationMap.containsKey(diff))
            {
                max = Math.max(s, diff);
                min = Math.min(s, diff);

                if(max > resultantMax && min != 0)
                {
                    resultantMax = max;

                    if(s > diff)
                    {
                        minIndex = seenSongDurationMap.get(diff);
                        maxIndex = index;
                    }
                    else
                    {
                        minIndex = index;
                        maxIndex = seenSongDurationMap.get(diff);
                    }
                }
            }
            else
            {
                seenSongDurationMap.put(s, index);
            }

        }

        resultantList.add(minIndex);
        resultantList.add(maxIndex);

        Collections.sort(resultantList);

        return resultantList;

    }
    // METHOD SIGNATURE ENDS
}
