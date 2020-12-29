package SortLogic.MergeSort;

public interface MergeSortUtils {

    static void merge(final int[] initialArray, final int[] helperArray, final int fromIndex, final int middleIndex, final int toIndex) {
        for (int i = fromIndex; i <= toIndex; i++) {
            helperArray[i] = initialArray[i];
        }

        int helperLeftIndex = fromIndex;
        int helperRightIndex = middleIndex + 1;
        int current = fromIndex;

        while (helperLeftIndex <= middleIndex && helperRightIndex <= toIndex) {
            if (helperArray[helperLeftIndex] <= helperArray[helperRightIndex]) {
                initialArray[current] = helperArray[helperLeftIndex++];
            } else {
                initialArray[current] = helperArray[helperRightIndex++];
            }
            current++;
        }

        while (helperLeftIndex <= middleIndex) {
            initialArray[current++] = helperArray[helperLeftIndex++];
        }
    }
}
