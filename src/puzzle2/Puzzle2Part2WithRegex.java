package puzzle2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.Builder;
import lombok.Getter;

public class Puzzle2Part2WithRegex {

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
        Matcher m = Pattern.compile("(?<min>\\d+)-(?<max>\\d+) (?<letter>\\w): (?<password>\\w+)").matcher(nextLine);
        m.find();
        return PasswordWithPolicy.builder()
                .firstPosition(Integer.valueOf(m.group("min")))
                .secondPosition(Integer.valueOf(m.group("max")))
                .requiredLetter(m.group("letter").charAt(0))
                .password(m.group("password"))
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
