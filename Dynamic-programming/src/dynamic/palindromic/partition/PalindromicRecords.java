package dynamic.palindromic.partition;

public class PalindromicRecords {

    private boolean palindromeRecord[][];
    private String palindromeSubstring[][];

    public void populateRecords(String input, boolean printRequired) {
        final int inputLength = input.length();
        palindromeRecord = new boolean[inputLength][inputLength];
        palindromeSubstring = new String[inputLength][inputLength];

        for (int i = 0; i < inputLength ; i++) {
            for (int j = 0; j < inputLength-i ; j++) {
                palindromeRecord[i][j] = false;
                palindromeSubstring[i][j]="";
            }
        }

        for (int i = 0; i < inputLength ; i++) {

            if(i == 0) {
                for (int j = 0; j < inputLength ; j++) {
                    palindromeRecord[j][j]=true;
                    palindromeSubstring[j][j]=input.substring(j,j+1);
                    //System.out.print(input.substring(j,j+1)+"\t");
                }
            }

            else if(i == 1) {
                for (int j = 0; j < inputLength-1 ; j++) {
                    if(input.charAt(j)==input.charAt(j+1)) {
                        palindromeRecord[j][j+1]=true;
                        palindromeSubstring[j][j+1]=input.substring(j,j+2);
                        //System.out.print(input.substring(j,j+2)+"\t");
                    } else {
                        palindromeRecord[j][j+1]=false;
                        //System.out.print("-"+"\t");
                    }
                }
            }

            else {
                for (int j = 0; j < inputLength-i ; j++) {
                    if(input.charAt(j)==input.charAt(j+i) && palindromeRecord[j+1][j+i-1]) {
                        palindromeRecord[j][j+i]=true;
                        palindromeSubstring[j][j+i]=input.substring(j,j+i+1);
                        //System.out.print(input.substring(j,j+i+1)+"\t");
                    } else {
                        palindromeRecord[j][j+i]=false;
                        //System.out.print("-"+"\t");
                    }
                }
            }
            //System.out.println();
        }

        if(printRequired) {
            for (int i = 0; i < inputLength; i++) {
                for (int j = 0; j < inputLength; j++) {
                    System.out.print(((palindromeRecord[i][j]) ? palindromeSubstring[i][j] : "-") + "\t");
                }
                System.out.println();
            }
        }
    }

    public boolean[][] getPalindromeRecord() {
        return palindromeRecord;
    }

    public String[][] getPalindromeSubstring() {
        return palindromeSubstring;
    }
}
