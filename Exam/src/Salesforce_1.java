import java.util.HashMap;

public class Salesforce_1 {

    public static void doIt(String input) {

        String a[] = input.split(" ");
        String TS = a[0];
        String LS = a[1];

        String LT = a[2];

        long num = getCount(TS, LS);
        String TT = getText(num, LT);

        System.out.println(TT);
    }

    private static String getText(long num, String lang) {

        int nC = lang.length();
        HashMap<Character, Integer> map = new HashMap<>();

        char c[] = lang.toCharArray();
        String res = ""+c[0];

        for (int i = 0; i < nC; i++) {
            map.put(lang.charAt(i), i);
        }

        while(num > 0)
        {
            res = getNext(res, nC, c, map);
            num--;
        }
        return res;
    }

    private static long getCount(String text, String lang) {
        long res = 0L;
        String temp = "";

        int nC = lang.length();
        HashMap<Character, Integer> map = new HashMap<>();

        char c[] = lang.toCharArray();
        temp = ""+c[0];

        for (int i = 0; i < nC; i++) {
            map.put(lang.charAt(i), i);
        }

        while (text.equals(temp) == false){

            temp = getNext(temp, nC, c, map);
            res ++;
        }
        return res;
    }

    private static String getNext(String text, int n, char c[],  HashMap<Character, Integer> map) {
        String res = "";
        boolean done = false;
        for (int i = text.length()-1; i >= 0; i--) {

            if(done){
                res = text.charAt(i) + res;
                continue;
            }

            if(text.charAt(i)==c[n-1]){

                while (i>=0 && text.charAt(i)==c[n-1])
                {
                    res = c[0] + res;
                    i--;
                }

                if(i==-1){
                    res = c[1]+res;
                }
                else
                {
                    res = c[map.get(text.charAt(i))+1] + res;
                    //i--;
                    done = true;
                }
            }
            else{
                res = c[map.get(text.charAt(i))+1] + res;
                done = true;
            }
        }

        return res;
    }

    public static void main(String s[])
    {
        //doIt("9 0123456789 oF8");
        //System.out.println(getCount("13", "0123456789abcdef"));
        System.out.println(getText(19, "01"));
    }
}
