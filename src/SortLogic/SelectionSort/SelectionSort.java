package SortLogic.SelectionSort;

public class SelectionSort {

    public long sortValues(int[] initialArray) {

        long startTime = System.nanoTime();
        int numberOfElements = initialArray.length;
        for (int i = 0; i < numberOfElements - 1; i++) {
            int minimalValueIndex = i;
            for (int j = i + 1; j < numberOfElements; j++)
                if (initialArray[j] < initialArray[minimalValueIndex])
                    minimalValueIndex = j;

            int minimalValue = initialArray[minimalValueIndex];
            initialArray[minimalValueIndex] = initialArray[i];
            initialArray[i] = minimalValue;
        }

        long elapsedTime = System.nanoTime() - startTime;
        return elapsedTime;
    }

    public String sortAndReturnStringArrays(int[] initialArray) {

        StringBuilder arrayIters = new StringBuilder();
        int numberOfElements = initialArray.length;
        for (int i = 0; i < numberOfElements - 1; i++) {
            int minimalValueIndex = i;
            for (int j = i + 1; j < numberOfElements; j++)
                if (initialArray[j] < initialArray[minimalValueIndex])
                    minimalValueIndex = j;

            int minimalValue = initialArray[minimalValueIndex];
            initialArray[minimalValueIndex] = initialArray[i];
            initialArray[i] = minimalValue;
            arrayIters.append("\niteracja ").append(i).append(": ");
            for (Integer integer : initialArray) {
                arrayIters.append(integer).append(", ");
            }
        }
        return arrayIters.toString();
    }

}
