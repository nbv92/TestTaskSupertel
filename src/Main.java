import javax.swing.*;
import java.util.List;

import static model.Port.convertIndexes;
import static model.Port.getAllCombinations;

public class Main {
    public static void main(String[] args) {
        String[] indexes = {"1,3-5", "2", "3-4"};
        List<List<Integer>> numberLists = convertIndexes(indexes);
        List<List<Integer>> combinations = getAllCombinations(numberLists);
        System.out.println(numberLists);
        System.out.println(combinations);

        // GUI implementation
        JFrame frame = new JFrame("Port Sequence Combinations");
        JTextArea textArea = new JTextArea();
        StringBuilder sb = new StringBuilder();
        for (List<Integer> numberList : numberLists) {
            sb.append(numberList);
            sb.append(" ");
        }
        for (List<Integer> combination : combinations) {
            sb.append(combination);
            sb.append("\n");
        }
        textArea.setText(sb.toString());

        JScrollPane scrollPane = new JScrollPane(textArea);


        frame.add(scrollPane);

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}