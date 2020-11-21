package SortLogic.SelectionSort;

import SortLogic.SortComparison;
import java.util.List;

public class SelectionSort extends SortComparison {

    public List<Integer> sortValues(List<Integer> unsortedList) {
        int n = unsortedList.size();

        // traverse unsorted array
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (unsortedList.get(j) < unsortedList.get(min_idx))
                    min_idx = j;

            // swap minimum element with compared element
            int temp = unsortedList.get(min_idx);
            unsortedList.set(min_idx, unsortedList.get(i));
            unsortedList.set(i, temp);
        }
        return unsortedList;
    }

}
