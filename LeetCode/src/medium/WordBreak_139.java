package medium;

/**
 * https://leetcode.com/problems/word-break/
 * https://www.youtube.com/watch?v=RPeTFTKwjps&list=PLgkTb_uYkq5f6mI52NZv68QTb6Ui7omWX&index=12
 */

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak_139 {

    public boolean wordBreak(String s, List<String> wordDict) {

        int n = s.length();
        String subStr;
        Set<String> set = new HashSet<>();
        int maxLen = 0;

        for(String w: wordDict) {
            maxLen = (w.length()>maxLen)?w.length():maxLen;
            set.add(w);
        }



        boolean dp[] = new boolean[n+1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = i-1; j >= Math.max(0, i-maxLen); j--) {
                if(dp[j]) {
                    subStr = s.substring(j, i);
                    if(set.contains(subStr)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[n];
    }
}
