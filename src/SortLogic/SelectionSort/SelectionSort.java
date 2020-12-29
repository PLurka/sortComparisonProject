package SortLogic.SelectionSort;

import SortLogic.SortComparison;

import java.util.List;

public class SelectionSort extends SortComparison {

    public long sortValues(List<Integer> list) {
        long startTime = System.nanoTime();
        // ------selectionSort-----
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (list.get(j) < list.get(min_idx))
                    min_idx = j;

            int temp = list.get(min_idx);
            list.set(min_idx, list.get(i));
            list.set(i, temp);
        }
        // ---------
        long elapsedTime = System.nanoTime() - startTime;
        /*System.out.println("Posortowana lista przez wybieranie");
        for (Integer integer : list) {
            System.out.print(integer + ", ");
        }*/
        return elapsedTime;
    }

}
