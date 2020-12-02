package puzzle1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Puzzle1Part2 {

    private final static int TARGET_SUM = 2020;
    private final static String INPUT_FILE = "src/puzzle1/input.txt";
    private final static HashSet<Integer> potentialAddends = new HashSet<Integer>();
    private final static HashMap<Integer, List<Integer>> potentialPartialSums = new HashMap<>();

    public static void main(String[] args) {

        Scanner sc = getScanner(INPUT_FILE);
        while (sc.hasNextLine()) {
            int addend = Integer.parseInt(sc.nextLine());
            checkForValidSum(addend);
            storePartialSums(addend);
            potentialAddends.add(addend);
        }
        System.out.println("No valid addends found");
    }

    private static void storePartialSums(int addend) {
        potentialAddends.stream().forEach(a -> {
            potentialPartialSums.put(a+addend,List.of(a, addend));
        });;
    }

    private static void checkForValidSum(int addend) {
        potentialPartialSums.keySet().stream().forEach(s -> {
            if (s + addend == TARGET_SUM) {
                // Assuming unique answer, otherwise recurse original puzzle here.
                System.out.println(
                        potentialPartialSums.get(s).get(0)
                        * potentialPartialSums.get(s).get(1)
                        * addend);
                System.exit(0);
            }
        });
    }

    private static Scanner getScanner(String input) {
        try {
            File inputFile = new File(input);
            return new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return null;
    }

}
