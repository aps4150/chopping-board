public class BubbleSort {

    public static void main(String args[]) {

        int [] array = { 20, 35, -15, 7, 55, 1, -22};

        for(int sortedPortionStartingIndex = array.length-1; sortedPortionStartingIndex > 0; sortedPortionStartingIndex--){

            for(int i = 0; i < sortedPortionStartingIndex; i++){

                if(array[i]>array[i+1]){
                    swap(array, i, i+1);
                }
            }
        }

        printArray(array);

    }

    public static void swap(int[] array, int i, int j){

        if(i==j || i >= array.length || j >= array.length || i < 0 || j < 0) {
            return;
        }

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void printArray(int[] array){
        for(int i = 0; i<array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
