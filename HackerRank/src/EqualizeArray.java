public class EqualizeArray {

    // Complete the equalizeArray function below.
    static int equalizeArray(int[] arr) {

        int x[] = new int[101];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {

            x[arr[i]]++;
            if(max<x[arr[i]])
            {
                max = x[arr[i]];
            }

        }

        return arr.length - max;

    }
}
