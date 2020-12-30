import SortLogic.MergeSort.MergeSortMixed;
import SortLogic.MergeSort.MergeSortParallel;
import SortLogic.MergeSort.MergeSortSequential;
import SortLogic.MergeSortSeq.MergeSortSeq;
import SortLogic.SelectionSort.SelectionSort;
import SortLogic.SortComparison;

import java.util.List;

public class Sort {

    SelectionSort selectionSort;

    public static void main(String[] args) {
        List<Integer> generatedValues = SortComparison.generateValues(1000, 100, 1);
        System.out.println(generatedValues.toString());

        SelectionSort selectionSort = new SelectionSort();
        long selectionSortTime = selectionSort.sortValues(generatedValues);
        System.out.println("\nCzas sortowania przez wybieranie: " + selectionSortTime);


        MergeSortSeq mergeSortSeq = new MergeSortSeq();
        long mergeSortTime = mergeSortSeq.sortValues(generatedValues);
        System.out.println("\nCzas sortowania przez podział (Szaman): " + mergeSortTime);


        int[] valuesArray = SortComparison.listToArray(generatedValues);

        MergeSortSequential mergeSortSequential = new MergeSortSequential();
        long mergeSortSequentialTime = mergeSortSequential.sortValues(valuesArray.clone());
        System.out.println("\nCzas sortowania przez podział sekwencyjnie (net): " + mergeSortSequentialTime);


        MergeSortParallel mergeSortParallel = new MergeSortParallel(valuesArray.clone(), 0, valuesArray.length - 1);
        long mergeSortParallelTime = mergeSortParallel.sortValues();
        System.out.println("\nCzas sortowania przez podział równolegle (net): " + mergeSortParallelTime);


        MergeSortMixed mergeSortMixed = new MergeSortMixed(valuesArray.clone(), 0, valuesArray.length - 1);
        long mergeSortMixedTime = mergeSortMixed.sortValues();
        System.out.println("\nCzas sortowania przez podział mieszane (net): " + mergeSortMixedTime);
    }

}
