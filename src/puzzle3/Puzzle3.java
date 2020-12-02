package puzzle3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Puzzle3 {

    private final static String INPUT_FILE = "src/puzzle3/test.txt";

    public static void main(String[] args) {

        Scanner sc = getScanner(INPUT_FILE);
        while (sc.hasNextLine()) {
        }
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
