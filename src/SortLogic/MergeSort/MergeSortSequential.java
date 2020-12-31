package SortLogic.MergeSort;

import static SortLogic.MergeSort.MergeSortUtils.merge;
import static SortLogic.MergeSort.MergeSortUtils.mergePrint;

public class MergeSortSequential {

    public long sortValues(final int[] array) {
        long startTime = System.nanoTime();
        mergesort(array);
        return System.nanoTime() - startTime;
    }

    public static void mergesort(final int[] array) {
        final int[] helper = new int[array.length];
        mergesort(array, helper, 0, array.length - 1);
    }

    public static void mergesort(final int[] initialArray, final int[] helperArray, final int fromIndex, final int toIndex) {
        if (fromIndex < toIndex) {
            final int middle = (fromIndex + toIndex) / 2;
            mergesort(initialArray, helperArray, fromIndex, middle);
            mergesort(initialArray, helperArray, middle + 1, toIndex);
            merge(initialArray, helperArray, fromIndex, middle, toIndex);
        }
    }

    //------------------Simulation------------------//

    StringBuilder mergeDataString;

    public String sortValuesData(final int[] array) {
        mergeDataString = new StringBuilder();
        mergesortData(array);
        return mergeDataString.toString();
    }

    public void mergesortData(final int[] array) {
        final int[] helper = new int[array.length];
        mergesortData(array, helper, 0, array.length - 1);
    }

    public void mergesortData(final int[] initialArray, final int[] helperArray, final int fromIndex, final int toIndex) {
        if (fromIndex < toIndex) {
            final int middle = (fromIndex + toIndex) / 2;
            mergesortData(initialArray, helperArray, fromIndex, middle);
            mergesortData(initialArray, helperArray, middle + 1, toIndex);
            mergeDataString.append(mergePrint(initialArray, helperArray, fromIndex, middle, toIndex));
        }
    }
}
