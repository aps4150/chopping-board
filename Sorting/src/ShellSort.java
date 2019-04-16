public class ShellSort {

    public static void main(String s[]){

        int [] array = { 20, 35, -15, 7, 55, 1, -22};

        for(int gap = array.length; gap > 0; gap /=2){

            for(int i = gap; i < array.length; i++){

                int tempElement = array[i];
                int j;
                for(j = i; j >= gap && tempElement < array[j-gap]; j-=gap){

                    array[j] = array[j-gap];
                }
                array[j] = tempElement;
            }
        }

        BubbleSort.printArray(array);

    }
}
