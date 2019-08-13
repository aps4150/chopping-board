import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * GFG
 * https://practice.geeksforgeeks.org/problems/number-following-a-pattern/0
 */

public class NumberFollowingPattern {

    public static void main(String args[]) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        String inputPattern;

        while(T-- > 0 ) {

            inputPattern = reader.readLine();
            System.out.println(getNumberForPattern(inputPattern+"X"));
        }
    }

    private static String getNumberForPattern(String S) {

        String temp, res="";
        int dCount;
        int j,k, tempNum, correction, num = 1;


        for (int i = 0; i < S.length()-1; i++) {

            temp = ""+ S.charAt(i) + S.charAt(i+1);

            if(i == 0){
                if(temp.equals("II")) {
                    res = res + num + ++num;
                }
                else if(temp.equals("IX")) {
                    res = res + num + ++num;
                }
            }
            if(i != 0) {
                if (temp.equals("II")) {
                    res = res + ++num;
                }
                else if(temp.equals("IX")) {
                    res = res + ++num;
                }
            }

            if(!(temp.equals("II") || temp.equals("IX"))) {

                dCount = 0;
                j = i;
                k = i+1;

                if(temp.equals("ID")) {

                    if(i==0) {
                        res = res + "1";
                    }

                    while (S.charAt(k) == 'D') {
                        dCount ++;
                        k++;
                    }

                    tempNum = num+dCount+1;
                    res = res + tempNum;
                    while (dCount > 0) {
                        res = res + (num + dCount--);
                    }
                    i=k-1;
                    num = tempNum;
                }
                else {

                    while (S.charAt(i) == 'D') {
                        dCount ++;
                        i++;
                    }

                    while (dCount >= 0) {
                        res = res + (num + dCount--);
                    }

                    correction = i-j;
                    i--;
                    num = num + correction;
                }
            }

        }
        return res;
    }
}
