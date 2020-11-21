import SortLogic.SelectionSort.SelectionSort;

import java.util.List;

public class Sort {

    SelectionSort selectionSort;

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        List<Integer> generatedValues = selectionSort.generateValues(10, 100, 1);
        System.out.println(generatedValues.toString());
        List<Integer> sortedList = selectionSort.sortValues(generatedValues);
        System.out.println("Posortowana lista przez wybieranie");
        for (Integer integer : sortedList) {
            System.out.print(integer + ", ");
        }
    }

}
