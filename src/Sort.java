import SortLogic.MergeSortSeq.MergeSortSeq;
import SortLogic.SelectionSort.SelectionSort;

import java.util.List;

public class Sort {

    SelectionSort selectionSort;

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        List<Integer> generatedValues = selectionSort.generateValues(10, 100, 1);
        System.out.println(generatedValues.toString());
        long selectionSortTime = selectionSort.sortValues(generatedValues);
        System.out.println("\nCzas sortowania przez wybieranie: " + selectionSortTime);

        MergeSortSeq mergeSortSeq = new MergeSortSeq();
        long mergeSortTime = mergeSortSeq.sortValues(generatedValues);
        System.out.println("\nCzas sortowania przez podział: " + mergeSortTime);
    }

}
