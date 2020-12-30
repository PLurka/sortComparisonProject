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
//            System.out.println("\niteracja " + i + ": ");
//            for (Integer integer : initialArray) {
//                System.out.print(integer + ", ");
//            }
        }

        long elapsedTime = System.nanoTime() - startTime;
//        System.out.println("Posortowana lista przez wybieranie");
//        for (Integer integer : initialArray) {
//            System.out.print(integer + ", ");
//        }
        return elapsedTime;
    }

}
