import java.util.HashMap;

public class Array_IsSubArrayHasGivenSum {

    public static void main(String[] args) {
        int[] arr = {1, 20, 2, 8};
        int n = arr.length;
        int sum = 10;
        subArraySum(arr, n, sum);

    }

    public static void subArraySum(int[] arr, int n, int res_sum) {
        //cur_sum to keep track of cummulative sum till that point
        int cur_sum = 0;
        int start = 0;
        int end = -1;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            cur_sum = cur_sum + arr[i];
            //check whether cur_sum - sum = 0, if 0 it means
            //the sub array is starting from index 0- so stop
            if (cur_sum - res_sum == 0) // i.e. cur_sum == res_sum i.e. res_sum == arr[0]
            {
                start = 0;
                end = i;
                break;
            }
            //if hashMap already has the value, means we already
            // have subarray with the res_sum - so stop
            if (hashMap.containsKey(cur_sum - res_sum)) {
                start = hashMap.get(cur_sum - res_sum) + 1;
                end = i;
                break;
            }
            //if value is not present then add to hashmap
            hashMap.put(cur_sum, i);

        }
        // if end is -1 : means we have reached end without the sum
        if (end == -1) {
            System.out.println("No subarray with given sum exists");
        } else {
            System.out.println("Sum found between indexes "
                    + start + " to " + end);
        }

    }
}