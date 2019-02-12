package duplicate;

import util.InputUtils;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class DuplicateRemoval {

    public static void main(String args[]) throws IOException {

        int[] integerArray = InputUtils.readIntegArray("Enter input Array of Integers: ");

        removeDuplicates(integerArray);
    }

    private static void removeDuplicates(int[] array) {

        Set<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            hashSet.add(array[i]);
        }
        System.out.print("Resultant array without Duplicates: ");
        hashSet.stream().forEach(i-> System.out.print(i+"\t"));

    }

}
