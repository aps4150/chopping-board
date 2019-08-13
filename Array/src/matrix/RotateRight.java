package matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * GFG
 * https://practice.geeksforgeeks.org/problems/rotate-a-2d-array-without-using-extra-space/0

 * I/P:
 * 1
 * 3
 * 1 2 3 4 5 6 7 8 9
 * O/P:
 * 7 4 1 8 5 2 9 6 3

 * I/P:
 * 1
 * 8
 * 35 78 84 86 81 25 45 54 38 73 18 88 72 64 30 35 17 98 38 7 74 46 57 5 43 79 28 72 89 53 39 78 56 18 10 20 20 19 58 74 12 65 46 66 30 93 41 52 86 18 93 53 56 56 24 40 36 49 50 35 53 28 9 99
 * O/P:
 * 36 86 12 56 43 17 38 35 49 18 65 18 79 98 73 78 50 93 46 10 28 38 18 84 35 53 66 20 72 7 88 86 53 56 30 20 89 74 72 81 28 56 93 19 53 46 64 25 9 24 41 58 39 57 30 45 99 40 52 74 78 5 35 54

 */
public class RotateRight {

    public static void main(String args[]) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        int t = 0;

        String res[] = new String[T];
        int N;
        String matrixAsString;
        while(t<T) {

            N = Integer.parseInt(reader.readLine());
            matrixAsString = reader.readLine();

            res[t++] = rotateMatrix(matrixAsString, N);
        }

        for (int i = 0; i < T; i++) {

            System.out.println(res[i]);
        }
    }

    private static String rotateMatrix(String matrixAsString, int size) {

        String arr[] = matrixAsString.split(" ");

        int i,newR, newC, newI;
        String carryValue, tempCarryValue;

        int rightBoundForColumn = size-1;
        for (int r = 0; r < size; r++) {

            if( r > rightBoundForColumn) {
                break;
            }

            for (int c = r; c < rightBoundForColumn; c++) {

                int starterI = r * size + c;
                i = starterI;
                newI = -1;

                newR = c;
                newC = (size - 1) - r;

                carryValue = arr[i];

                while (newI != starterI) {

                    newI = newR * size + newC;

                    tempCarryValue = arr[newI];
                    arr[newI] = carryValue;
                    carryValue = tempCarryValue;

                    newR = newI % size;
                    newC = (size - 1) - (newI / size);

                    i = newI;
                }

            }

            rightBoundForColumn--;
        }

        return String.join(" ", arr);
    }

    private static String rotateMatrix_Old(String matrixAsString, int size) {

        int length = size * size;
        String arr[] = matrixAsString.split(" ");

        //  1 2 3 4 5 6 7 8 9
        //  7 4 1 8 5 2 9 6 3

        int r, c, j, newR, newC, newI;
        String carryValue, tempCarryValue;

        int a, b, k, i;
        a = 1;
        b = size-1;
        k = 3;
        i = a;

        while (a < b) {

            newI = -1;
            j = i;
            carryValue = arr[i];

            while (newI != i) {

                //r=i/size;
                //c=i%size;
                newR = j%size; //=c;
                newC = size-1-j/size;//r;
                newI = newR*size + newC;

                tempCarryValue = arr[newI];
                arr[newI] = carryValue;
                carryValue = tempCarryValue;

                j = newI;
            }
            i++;

            if(i > b) {
                a = b+k;
                k = k+2;
                b = b+size-1;
                i = a;
            }
        }

        return String.join(" ", arr);
    }
}