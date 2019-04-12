public class InsertionSort {

    public static void main(String args[]){

        int [] array = { 20, 35, -15, 7, 55, 1, -22};

        for(int startingIndexOfUnsortedPartition = 1; startingIndexOfUnsortedPartition < array.length; startingIndexOfUnsortedPartition++){

            int tempElement = array[startingIndexOfUnsortedPartition];

            int i;
            for(i = startingIndexOfUnsortedPartition; i > 0 && array[i-1] > tempElement; i--) {

                array[i] = array[i - 1];
            }
            array[i] = tempElement;
        }

        BubbleSort.printArray(array);

        //sout
        System.out.println();

        main2_TunedUp(args);
    }

    // My Code :)
    public static void main2_TunedUp(String args[]){

        int [] array = { 20, 35, -15, 7, 55, 1, -22};

        for(int startingIndexOfUnsortedPartition = 1; startingIndexOfUnsortedPartition < array.length; startingIndexOfUnsortedPartition++){

            int tempElement = array[startingIndexOfUnsortedPartition];
            int i = startingIndexOfUnsortedPartition;

            while(i > 0 && array[i-1] > tempElement){
                array[i] = array[--i];
            }
            array[i] = tempElement;
        }

        BubbleSort.printArray(array);
    }

    /*
    // 2nd attempt
    public static void main3(String args[]){

        int [] array = { 20, 35, -15, 7, 55, 1, -22};

        for(int startingIndexOfUnsortedPartition = 1; startingIndexOfUnsortedPartition < array.length; startingIndexOfUnsortedPartition++){

            int temp = array[startingIndexOfUnsortedPartition];

            int index = -1;
            for(int i = startingIndexOfUnsortedPartition-1; i >= 0; i--){

                if(array[i] > temp){
                    array[i+1] = array[i];
                    index = i;//array[i] = temp;
                }
                else{
                    break;
                }
            }
            if(index != -1){
                array[index] = temp;
            }
        }

        BubbleSort.printArray(array);
    }

    // 1st attempt
    public static void main2(String args[]){

        int [] array = { 20, 35, -15, 7, 55, 1, -22};

        for(int startingIndexOfUnsortedPartition = 1; startingIndexOfUnsortedPartition < array.length; startingIndexOfUnsortedPartition++){

            int temp = array[startingIndexOfUnsortedPartition];
            int i = startingIndexOfUnsortedPartition -1;
            boolean updateFlag = false;

            while(array[i] > temp){

                array[i+1] = array[i];
                i--;

                if(i<0) {
                break;
                }
                updateFlag = true;
            }
            if(updateFlag)
                array[i+1] = temp;

        }

        BubbleSort.printArray(array);
    }
    */


}
