import SortLogic.MergeSort.MergeSortMixed;
import SortLogic.MergeSort.MergeSortParallel;
import SortLogic.MergeSort.MergeSortSequential;
import SortLogic.SelectionSort.SelectionSort;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainFrame extends JFrame {
    private JButton sortujButton;
    private JTextArea textOutput;
    private JTextField itemsTF;
    private JTextField minTF;
    private JTextField maxTF;
    private JButton generujButton;
    private JButton symulujButton;
    private JLabel itemsLabel;
    private JLabel minLabel;
    private JLabel maxLabel;
    private JPanel mainPanel;

    private int[] generatedValues;
    private static final int TIME_DIVIDER = 1;
    private static final String INT_REGEX = "^[0-9]*$";

    SelectionSort selectionSort;
    MergeSortSequential mergeSortSequential;

    public MainFrame(String title) {

        super(title);
        this.setContentPane(this.mainPanel);
        this.setSize(1100, 700);
        // this.pack(); // dopasowany rozmiar do contentu na panelu lub setSize
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textOutput.setLineWrap(true);

        selectionSort = new SelectionSort();
        mergeSortSequential = new MergeSortSequential();

        generatedValues = new int[0];
        itemsTF.setText("10");
        minTF.setText("1");
        maxTF.setText("100");

        generujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textOutput.setText("");
                if (itemsTF.getText().equals("") || minTF.getText().equals("") || maxTF.getText().equals("")) {
                    textOutput.setText("Podaj liczby");
                    return;
                }
                if (!itemsTF.getText().matches(INT_REGEX) || !minTF.getText().matches(INT_REGEX) || !maxTF.getText().matches(INT_REGEX)) {
                    textOutput.setText("Wpisz tylko cyfry!");
                    return;
                }
                generatedValues = generateValues(Integer.parseInt(itemsTF.getText()), Integer.parseInt(minTF.getText()), Integer.parseInt(maxTF.getText()));
                textOutput.append("Wygenerowano liste losowych liczb całkowitych: \n");
                for (Integer value : generatedValues) {
                    textOutput.append(value + ", ");
                }
            }
        });
        sortujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textOutput.setText("");
                if (generatedValues.length == 0) {
                    textOutput.setText("Nie wygenerowano liczb!");
                    return;
                }
                long selectionSortTime = selectionSort.sortValues(generatedValues.clone());
                textOutput.append("Czas sortowania przez wybieranie: " + selectionSortTime / TIME_DIVIDER);

                long mergeSortSequentialTime = mergeSortSequential.sortValues(generatedValues.clone());
                textOutput.append("\nCzas sortowania przez podział sekwencyjnie: " + mergeSortSequentialTime / TIME_DIVIDER);

                MergeSortParallel mergeSortParallel = new MergeSortParallel(generatedValues.clone(), 0, generatedValues.length - 1);
                long mergeSortParallelTime = mergeSortParallel.sortValues();
                textOutput.append("\nCzas sortowania przez podział równolegle: " + mergeSortParallelTime / TIME_DIVIDER);

                MergeSortMixed mergeSortMixed = new MergeSortMixed(generatedValues.clone(), 0, generatedValues.length - 1);
                long mergeSortMixedTime = mergeSortMixed.sortValues();
                textOutput.append("\nCzas sortowania przez podział mieszane: " + +mergeSortMixedTime / TIME_DIVIDER);
            }
        });
        symulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textOutput.setText("");
                if (generatedValues.length == 0) {
                    textOutput.setText("Nie wygenerowano liczb!");
                    return;
                }

                String selectionSortOutput = selectionSort.sortAndReturnStringArrays(generatedValues.clone());
                textOutput.append("Przebieg sortowania przez wybieranie: \n " + selectionSortOutput);

                String mergeSortOutput = mergeSortSequential.sortValuesData(generatedValues.clone());
                textOutput.append("\n\nPrzebieg sortowania przez podział (seq): \n" + mergeSortOutput);
            }
        });
    }

    private int[] generateValues(int listSize, int minValue, int maxValue) {
        Random random = new Random();
        int[] valuesArray = new int[listSize];
        for (int i = 0; i < listSize; ++i) {
            valuesArray[i] = random.nextInt(maxValue) + minValue;

        }
        return valuesArray;
    }
}
