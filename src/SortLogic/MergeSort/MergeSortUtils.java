package SortLogic.MergeSort;

import java.util.Arrays;

public interface MergeSortUtils {

    static void merge(final int[] initialArray, final int[] helperArray, final int fromIndex, final int middleIndex, final int toIndex) {
        for (int i = fromIndex; i <= toIndex; i++) {
            helperArray[i] = initialArray[i];
        }

        int helperLeftIndex = fromIndex;
        int helperRightIndex = middleIndex + 1;
        int currentIndex = fromIndex;

        while (helperLeftIndex <= middleIndex && helperRightIndex <= toIndex) {
            if (helperArray[helperLeftIndex] <= helperArray[helperRightIndex]) {
                initialArray[currentIndex] = helperArray[helperLeftIndex++];
            } else {
                initialArray[currentIndex] = helperArray[helperRightIndex++];
            }
            currentIndex++;
        }

        while (helperLeftIndex <= middleIndex) {
            initialArray[currentIndex++] = helperArray[helperLeftIndex++];
        }
    }

    static String mergePrint(final int[] initialArray, final int[] helperArray, final int fromIndex, final int middleIndex, final int toIndex) {
        StringBuilder mergeData = new StringBuilder();
        for (int i = fromIndex; i <= toIndex; i++) {
            helperArray[i] = initialArray[i];
        }

        int helperLeftIndex = fromIndex;
        int helperRightIndex = middleIndex + 1;
        int currentIndex = fromIndex;

        while (helperLeftIndex <= middleIndex && helperRightIndex <= toIndex) {
            if (helperArray[helperLeftIndex] <= helperArray[helperRightIndex]) {
                initialArray[currentIndex] = helperArray[helperLeftIndex++];
            } else {
                initialArray[currentIndex] = helperArray[helperRightIndex++];
            }
            currentIndex++;
        }

        while (helperLeftIndex <= middleIndex) {
            initialArray[currentIndex++] = helperArray[helperLeftIndex++];
        }

        mergeData.append("\ninitialArray = ").append(Arrays.toString(initialArray)).append(", helperArray = ").append(Arrays.toString(helperArray)).append(", fromIndex = ").append(fromIndex).append(", middleIndex = ").append(middleIndex).append(", toIndex = ").append(toIndex);
        return mergeData.toString();
    }
}
