package dynamic.palindromic.partition;

//import org.apache.commons.lang3.StringUtils;
import util.InputUtils;

import java.io.IOException;

/**
 * Palindromic partitions is Set of indices which when used to split the String will generate
 * only palindromic substrings.
 */
public class AllPossiblePalindromicPartitions {

    private static PalindromicRecords RECORDS;

    public static void main(String args[]) throws IOException {

        String input = InputUtils.readSingleString("Enter input String: ");

        generateAllPalindromicSubstrings(input);
    }

    private static void generateAllPalindromicSubstrings(String input) {

        //if(StringUtils.isBlank(input)) { return;}

        RECORDS = new PalindromicRecords();
        RECORDS.populateRecords(input, false);

        identifyPalindromicPartitions(0, 0, input.length(), "");
    }

    private static void identifyPalindromicPartitions(int row, int col, int length, String resultantString) {

        for (int j = col; j < length && row < length; j++) {

            String[][] palindromicSubstring = RECORDS.getPalindromeSubstring();

            // number of actual characters (from start of) string processed: (j-row+1) + row = j+1
            if(null != palindromicSubstring[row][j] && palindromicSubstring[row][j].length()!=0){
                if(j+1 > length){
                    System.out.println(resultantString);
                } else {
                    identifyPalindromicPartitions(row +  palindromicSubstring[row][j].length(), j + 1, length, resultantString + palindromicSubstring[row][j] + " | ");
                }
            }
        }

        if(col >= length || row >= length) {
            System.out.println(resultantString.replaceAll(" \\| $",""));
        }
    }
}