package SortLogic.MergeSortSeq;

import SortLogic.SortComparison;

import java.util.ArrayList;
import java.util.List;

public class MergeSortSeq extends SortComparison {

    public long sortValues(List<Integer> unsortedList) {
        long startTime = System.nanoTime();
        // sorted(unsortedList);
        sort(unsortedList);
        return System.nanoTime() - startTime;
    }

    public static void sort(List<Integer> list) {
        if (list.size() < 2) {
            return;
        }
        int mid = list.size()/2;
        List<Integer> left = new ArrayList<Integer>(list.subList(0, mid));
        List<Integer> right = new ArrayList<Integer>(list.subList(mid, list.size()));

        sort(left);
        sort(right);
        merge(left, right, list);
    }

    private static void merge(
            List<Integer> left, List<Integer> right, List<Integer> list) {
        int leftIndex = 0;
        int rightIndex = 0;
        int listIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) < right.get(rightIndex)) {
                list.set(listIndex++, left.get(leftIndex++));
            } else {
                list.set(listIndex++, right.get(rightIndex++));
            }
        }
        while (leftIndex < left.size()) {
            list.set(listIndex++, left.get(leftIndex++));
        }
        while (rightIndex < right.size()) {
            list.set(listIndex++, right.get(rightIndex++));
        }

//        for (Integer integer : list) {
//            System.out.print(integer + ", ");
//        }
//        System.out.print("\n");
    }

    // wersja bez mutowania oryginalnej listy
//    public static List<Integer> sorted(List<Integer> list) {
//        if (list.size() < 2) {
//            return list;
//        }
//        int mid = list.size()/2;
//        return merged(
//                sorted(list.subList(0, mid)),
//                sorted(list.subList(mid, list.size())));
//    }
//
//    private static List<Integer> merged(List<Integer> left, List<Integer> right) {
//        int leftIndex = 0;
//        int rightIndex = 0;
//        List<Integer> merged = new ArrayList<Integer>();
//
//        while (leftIndex < left.size() && rightIndex < right.size()) {
//            if (left.get(leftIndex) < right.get(rightIndex)) {
//                merged.add(left.get(leftIndex++));
//            } else {
//                merged.add(right.get(rightIndex++));
//            }
//        }
//        merged.addAll(left.subList(leftIndex, left.size()));
//        merged.addAll(right.subList(rightIndex, right.size()));
//        return merged;
//    }
}
