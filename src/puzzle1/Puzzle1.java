package puzzle1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Puzzle1 {

    private final static int TARGET_SUM = 2020;
    private final static String INPUT_FILE = "src/puzzle1/input.txt";

    public static void main(String[] args) {

        HashSet<Integer> potentialAddends = new HashSet<Integer>();

        Scanner sc = getScanner(INPUT_FILE);
        while (sc.hasNextLine()) {
            int addend = Integer.parseInt(sc.nextLine());
            if (potentialAddends.contains(addend)) {
                computeAndReturnAnswer(addend);
            }
            potentialAddends.add(getMatchingAddend(addend));
        }
        System.out.println("No valid addends found");
    }

    private static Integer getMatchingAddend(int addend) {
        return TARGET_SUM - addend;
    }

    private static void computeAndReturnAnswer(int addend) {
        System.out.println(addend * getMatchingAddend(addend));
        System.exit(0);
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
