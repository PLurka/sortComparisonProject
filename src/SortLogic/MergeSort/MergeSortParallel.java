package SortLogic.MergeSort;

import java.util.concurrent.RecursiveAction;

import static SortLogic.MergeSort.MergeSortUtils.merge;

public class MergeSortParallel extends RecursiveAction {
    private final int[] initialArray;
    private final int[] helperArray;
    private final int fromIndex;
    private final int toIndex;

    public MergeSortParallel(final int[] initialArray, final int fromIndex, final int toIndex) {
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
            final int middle = (fromIndex + toIndex) / 2;
            final MergeSortParallel left = new MergeSortParallel(initialArray, fromIndex, middle);
            final MergeSortParallel right = new MergeSortParallel(initialArray, middle + 1, toIndex);
            invokeAll(left, right);
            merge(initialArray, helperArray, fromIndex, middle, toIndex);
        }
    }

}
