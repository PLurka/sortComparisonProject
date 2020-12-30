import SortLogic.MergeSort.MergeSortMixed;
import SortLogic.MergeSort.MergeSortParallel;
import SortLogic.MergeSort.MergeSortSequential;
import SortLogic.SelectionSort.SelectionSort;

import java.util.Random;

public class Sort {

    private static final int TIME_DIVIDER = 1;
    public static void main(String[] args) {

        int[] generatedValues = generateValues(100, 100, 1);
        System.out.println("Wygenerowana lista losowych liczb całkowitych: ");
        for (Integer value : generatedValues) {
            System.out.print(value + ", ");
        }

        SelectionSort selectionSort = new SelectionSort();
        long selectionSortTime = selectionSort.sortValues(generatedValues);
        System.out.println("\nCzas sortowania przez wybieranie: " + selectionSortTime / TIME_DIVIDER);

        MergeSortSequential mergeSortSequential = new MergeSortSequential();
        long mergeSortSequentialTime = mergeSortSequential.sortValues(generatedValues.clone());
        System.out.println("\nCzas sortowania przez podział sekwencyjnie (net): " + mergeSortSequentialTime / TIME_DIVIDER);


        MergeSortParallel mergeSortParallel = new MergeSortParallel(generatedValues.clone(), 0, generatedValues.length - 1);
        long mergeSortParallelTime = mergeSortParallel.sortValues();
        System.out.println("\nCzas sortowania przez podział równolegle (net): " + mergeSortParallelTime / TIME_DIVIDER);


        MergeSortMixed mergeSortMixed = new MergeSortMixed(generatedValues.clone(), 0, generatedValues.length - 1);
        long mergeSortMixedTime = mergeSortMixed.sortValues();
        System.out.println("\nCzas sortowania przez podział mieszane (net): " + mergeSortMixedTime / TIME_DIVIDER);
    }

    public static int[] generateValues(int listSize, int maxValue, int minValue) {
        Random random = new Random();
        int[] valuesArray = new int[listSize];
        for (int i = 0; i < listSize; ++i) {
            valuesArray[i] = random.nextInt(maxValue) + minValue;

        }
        return valuesArray;
    }

}
