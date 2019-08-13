package dynamic;

import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

public class tester {


    static int getMaxSubKSum(List<List<Integer>> grid, int k) {


        int arrLen = grid.size();
        int[][] smallColSum = new int[arrLen][arrLen];

            for (int col = 0; col < arrLen; col++) {

                int sum = 0;
                for (int i = 0; i < k; i++) { sum += grid.get(i).get(col); }
                smallColSum[0][col] = sum;

                for (int i = 1; i < arrLen - k + 1; i++) {
                    sum += (grid.get(i + k - 1).get(col) - grid.get(i-1).get(col));
                    smallColSum[i][col] = sum;
                }
            }

            int g = 0;

            for (int i = 0; i < arrLen - k + 1; i++) {

                int sum = 0;
                for (int j = 0; j < k; j++) { sum += smallColSum[i][j]; }

                if (sum > g) { g = sum; }

                for (int j = 1; j < arrLen - k + 1; j++) {
                    sum += (smallColSum[i][j + k - 1] - smallColSum[i][j - 1]);
                    if (sum > g) { g = sum; }
                }
            }

            return g;
        }

    public static int largestSubsquareSide(List<List<Integer>> grid, int k) {


        int size = grid.size();
        //HashMap<Integer, Integer> map = new HashMap<>();
        NavigableMap<Integer, Integer> tMap = new TreeMap<>();

        while (size > 0) {
            tMap.put(getMaxSubKSum(grid, size), size);
            size--;
        }

        Integer cK = tMap.floorKey(k);

        if(null == cK)
        {
            return 0;
        }

        return tMap.get(cK);

    }
}
