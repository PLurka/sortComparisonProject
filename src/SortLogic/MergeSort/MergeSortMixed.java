package SortLogic.MergeSort;

import java.util.concurrent.RecursiveAction;

import static SortLogic.MergeSort.MergeSortSequential.mergesort;
import static SortLogic.MergeSort.MergeSortUtils.merge;

public class MergeSortMixed extends RecursiveAction {
    private static final int THRESHOLD = 1 << 13;
    private final int[] initialArray;
    private final int[] helperArray;
    private final int fromIndex;
    private final int toIndex;

    public MergeSortMixed(final int[] initialArray, final int fromIndex, final int toIndex) {
        this.initialArray = initialArray;
        helperArray = new int[initialArray.length];
        this.fromIndex = fromIndex;
        this.toIndex = toIndex;
    }

    public long sortValues() {
        long startTime = System.nanoTime();
        compute();
        return System.nanoTime() - startTime;
    }

    @Override
    protected void compute() {
        if (fromIndex < toIndex) {
            if (toIndex - fromIndex <= THRESHOLD) {
                mergesort(initialArray, helperArray, fromIndex, toIndex);
            } else {
                final int middle = (fromIndex + toIndex) / 2;
                final MergeSortMixed left = new MergeSortMixed(initialArray, fromIndex, middle);
                final MergeSortMixed right = new MergeSortMixed(initialArray, middle + 1, toIndex);
                invokeAll(left, right);
                merge(initialArray, helperArray, fromIndex, middle, toIndex);
            }
        }
    }
}
