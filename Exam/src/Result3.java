import java.util.HashSet;
import java.util.Set;

public class Result3 {

    TNode root;
    Set distinctChar = new HashSet();

    class TNode
    {
        int freq;
        String word;
        TNode[] next = new TNode[26];

    }


    public int insert(int m, String w)
    {
        distinctChar.clear();
        TNode parent = root;

        for(char c: w.toCharArray())
        {
            distinctChar.add(c);

            if(distinctChar.size() > m)
            {
                return -1;
            }

            int i = c - 'a';
            if(parent.next[i] == null)
            {
                parent.next[i] = new TNode();
            }
            parent = parent.next[i];
        }

        if(parent.word != null)
        {
            parent.freq += 1;
        }
        else
        {
            parent.freq = 1;
            parent.word = w;
        }

        return parent.freq;
    }

    public int getHighestFreqOfSubStr(String s, int minLength, int maxLength, int maxUnique)
    {
        int n = s.length();

        if(n==0 || s == null)
        {
            return 0;
        }

        if(minLength<0 || maxLength<0 || maxUnique<=0)
        {
            return 0;
        }

        int maxF = 1;
        root = new TNode();

        for(int i = 0; i<n; i++)
        {
            for(int j = minLength; j<=maxLength && j<=n; ++j)
            {
                String sub = s.substring(i,j);

                int currF = insert(maxUnique, sub);
                if(currF == -1) break;

                maxF = (currF > maxF)?currF :maxF;

            }
            minLength++;
            maxLength++;
        }
        return maxF;
    }
}
