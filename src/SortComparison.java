import java.util.ArrayList;
import java.util.List;
import java.util.Random;

abstract public class SortComparison {

    List<Integer> generateValues(int listSize, int maxValue, int minValue) {
        Random random = new Random();
        List<Integer> generatedList = new ArrayList<>();
        for (int i = 0; i < listSize; ++i) {
            generatedList.add(random.nextInt(maxValue) + minValue);
        }
        return generatedList;
    }

    abstract List<Integer> sortValues(List<Integer> unsortedList);

}
