package dynamic.palindromic.partition;

import util.InputUtils;
import java.io.IOException;
import java.util.Arrays;

public class MinimumPartitionForPalindromicSubstrings {

    private static PalindromicRecords RECORDS;

    public static void main(String args[]) throws IOException {

        String input = InputUtils.readSingleString("Enter input String: ");

        generateAllPalindromicSubstrings(input);
    }

    private static void generateAllPalindromicSubstrings(String input) {

        RECORDS = new PalindromicRecords();
        RECORDS.populateRecords(input, false);

        int partitionCount = getMinimumPartitionForPalindromicSubstrings(input);
        System.out.print("Minimum partitions required for Palindromic Substrings is: "+partitionCount);
    }

    private static int getMinimumPartitionForPalindromicSubstrings(String input) {

        boolean[][] isPalindrome = RECORDS.getPalindromeRecord();

        int inputLength =  input.length();
        int tempCount;
        int partitionCount[] = new int[inputLength];

        for (int i = 0; i < inputLength; i++)
        {
            tempCount = Integer.MAX_VALUE;

            if(isPalindrome[0][i])
            {
                partitionCount[i]=0;
            }
            else
            {
                for (int j = 0; j < i; j++) {
                    if(isPalindrome[j][i] && tempCount > partitionCount[i]+1) {
                        tempCount = partitionCount[i]+1;
                    }
                }
                partitionCount[i] = tempCount;
            }
        }

        Arrays.stream(partitionCount).forEach(i -> System.out.print(i+"\t"));

        return partitionCount[inputLength-1];
    }
}
