/**
 *https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/
 *
 * https://www.youtube.com/watch?v=prx1psByp7U
 *
 * https://www.youtube.com/watch?v=vgLJZMUfnsU
 *      https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/MatrixMultiplicationCost.java
 */
public class DP_MatrixMultiplicationCost {

    public int findCost(int arr[]){
        int temp[][] = new int[arr.length][arr.length];
        int q = 0;

        for(int l=2; l < arr.length; l++){

            for(int i=1; i < arr.length - l + 1; i++){

                int j = i + l - 1;
                temp[i][j] = 1000000;

                for(int k = i; k < j; k++){

                    q = temp[i][k] + temp[k+1][j] + arr[i-1] * arr[k] * arr[j];
                    if(q < temp[i][j]){
                        temp[i][j] = q;
                    }
                }
            }
        }
        return temp[1][arr.length-1];
    }

    public static void main(String args[]){
        DP_MatrixMultiplicationCost mmc = new DP_MatrixMultiplicationCost();
        int arr[] = {2,3,6,4,5};
        int cost = mmc.findCost(arr);
        System.out.print(cost);
    }
}