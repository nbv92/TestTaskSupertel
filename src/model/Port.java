package model;

import java.util.ArrayList;
import java.util.List;

public class Port {
    public static List<List<Integer>> convertIndexes(String[] indexes) {
        List<List<Integer>> result = new ArrayList<>();
        for (String index : indexes) {
            List<Integer> numbers = new ArrayList<>();
            String[] parts = index.split(",");
            for (String part : parts) {
                if (part.contains("-")) {
                    String[] range = part.split("-");
                    int start = Integer.parseInt(range[0]);
                    int end = Integer.parseInt(range[1]);
                    for (int i = start; i <= end; i++) {
                        numbers.add(i);
                    }
                } else {
                    numbers.add(Integer.parseInt(part));
                }
            }
            result.add(numbers);
        }
        return result;
    }

    public static List<List<Integer>> getAllCombinations(List<List<Integer>> lists) {
        List<List<Integer>> result = new ArrayList<>();
        generateCombinations(lists, result, 0, new ArrayList<>());
        return result;
    }

    private static void generateCombinations(List<List<Integer>> lists, List<List<Integer>> result, int depth, List<Integer> current) {
        if (depth == lists.size()) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < lists.get(depth).size(); i++) {
            current.add(lists.get(depth).get(i));
            generateCombinations(lists, result, depth + 1, current);
            current.remove(current.size() - 1);
        }
    }
}