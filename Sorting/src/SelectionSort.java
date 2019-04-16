public class SelectionSort {

    public static void main(String args[]){

        int [] array = { 20, 35, -15, 7, 55, 1, -22};

        for(int sortedPorttionStartingIndex = array.length-1; sortedPorttionStartingIndex > 0; sortedPorttionStartingIndex--){

            int greatestIndex = 0;

            for (int i = 1; i <= sortedPorttionStartingIndex; i++) {
                if(array[i]>array[greatestIndex]){
                    greatestIndex = i;
                }
            }
            BubbleSort.swap(array, sortedPorttionStartingIndex, greatestIndex);
        }

        BubbleSort.printArray(array);

    }
}
