package puzzle2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import lombok.Builder;
import lombok.Getter;

public class Puzzle2Part2 {

    private final static String INPUT_FILE = "src/puzzle2/input.txt";

    public static void main(String[] args) {

        int validPasswords = 0;
        
        Scanner sc = getScanner(INPUT_FILE);
        while (sc.hasNextLine()) {
            validPasswords += verifyPassword(parseLine(sc.nextLine())) ? 1 : 0;
        }
        System.out.println(validPasswords);
    }
    
    @Builder
    @Getter
    private static class PasswordWithPolicy {
        private final char requiredLetter;
        private final int firstPosition;
        private final int secondPosition;
        private final String password;
    }

    private static PasswordWithPolicy parseLine(String nextLine) {
        String[] min = nextLine.split("-");
        String[] max = min[1].split(" ", 2);
        String[] letter = max[1].split(": ");

        return PasswordWithPolicy.builder()
                .firstPosition(Integer.valueOf(min[0]))
                .secondPosition(Integer.valueOf(max[0]))
                .requiredLetter(letter[0].charAt(0))
                .password(letter[1])
                .build();
    }
    
    private static boolean verifyPassword(PasswordWithPolicy p) {
        return p.getPassword().charAt(p.getFirstPosition()-1) == p.getRequiredLetter()
                ^ p.getPassword().charAt(p.getSecondPosition()-1) == p.getRequiredLetter();
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
