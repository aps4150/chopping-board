package hard;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII_140 {

    public List<String> wordBreak(String s, List<String> wordDict) {

        int n = s.length();
        String subStr;
        Set<String> set = new HashSet<>();
        int maxLen = 0;

        for(String w: wordDict) {
            maxLen = (w.length()>maxLen)?w.length():maxLen;
            set.add(w);
        }

        return null;
    }
}
