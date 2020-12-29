package SortLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class SortComparison {

    public static List<Integer> generateValues(int listSize, int maxValue, int minValue) {
        Random random = new Random();
        List<Integer> generatedList = new ArrayList<>();
        for (int i = 0; i < listSize; ++i) {
            generatedList.add(random.nextInt(maxValue) + minValue);
        }
        return generatedList;
    }

    public static int[] listToArray(List<Integer> generatedValues) {
        int[] valuesArray = new int[generatedValues.size()];
        int i = 0;
        for (Integer value : generatedValues) {
            valuesArray[i] = value;
            i++;
        }
        return valuesArray;
    }

    public abstract long sortValues(List<Integer> unsortedList); // wcześniej zwracaliśmy List<Integer> ale chcemy mierzyć czas

}
