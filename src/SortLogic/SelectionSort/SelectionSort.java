package SortLogic.SelectionSort;

import SortLogic.SortComparison;

import java.util.List;

public class SelectionSort extends SortComparison {

    public long sortValues(List<Integer> initialList) {
        long startTime = System.nanoTime();

        int numberOfElements = initialList.size();
        for (int i = 0; i < numberOfElements - 1; i++) {
            int minimalValueIndex = i;
            for (int j = i + 1; j < numberOfElements; j++)
                if (initialList.get(j) < initialList.get(minimalValueIndex))
                    minimalValueIndex = j;

            int minimalValue = initialList.get(minimalValueIndex);
            initialList.set(minimalValueIndex, initialList.get(i));
            initialList.set(i, minimalValue);
        }

        long elapsedTime = System.nanoTime() - startTime;
        /*System.out.println("Posortowana lista przez wybieranie");
        for (Integer integer : initialList) {
            System.out.print(integer + ", ");
        }*/
        return elapsedTime;
    }

}
