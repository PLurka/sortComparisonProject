package SortLogic.MergeSortSeq;

import SortLogic.SortComparison;

import java.util.ArrayList;
import java.util.List;

public class MergeSortSeq extends SortComparison {

    public long sortValues(List<Integer> unsortedList) {
        long startTime = System.nanoTime();
        sort(unsortedList);
        return System.nanoTime() - startTime;
    }

    @SuppressWarnings("Duplicates")
    public void sort(List<Integer> mainList) {
        if (mainList.size() < 2) {
            return;
        }
        int mid = mainList.size() / 2;
        List<Integer> leftSubList = new ArrayList<>(mainList.subList(0, mid));
        List<Integer> rightSubList = new ArrayList<>(mainList.subList(mid, mainList.size()));

        sort(leftSubList);
        sort(rightSubList);
        merge(leftSubList, rightSubList, mainList);
    }

    protected void merge(List<Integer> leftSubList, List<Integer> rightSubList, List<Integer> mainList) {
        int leftSubListIndex = 0;
        int rightSubListIndex = 0;
        int mainListIndex = 0;

        while (leftSubListIndex < leftSubList.size() && rightSubListIndex < rightSubList.size()) {
            if (leftSubList.get(leftSubListIndex) < rightSubList.get(rightSubListIndex)) {
                mainList.set(mainListIndex++, leftSubList.get(leftSubListIndex++));
            } else {
                mainList.set(mainListIndex++, rightSubList.get(rightSubListIndex++));
            }
        }
        while (leftSubListIndex < leftSubList.size()) {
            mainList.set(mainListIndex++, leftSubList.get(leftSubListIndex++));
        }
        while (rightSubListIndex < rightSubList.size()) {
            mainList.set(mainListIndex++, rightSubList.get(rightSubListIndex++));
        }
    }
}
