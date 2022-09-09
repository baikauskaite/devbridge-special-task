import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Contains a main method that reads an input file containing alphanumeric
 * strings and prints out the ones containing at least one number equal to or
 * higher than 10.
 *
 * @version 1.09 09 Sep 2022
 * @author Viktorija Baikauskaite
 */

public class SpecialTask {
    /** Path of the input file containing alphanumeric strings */
    static final String INPUT_PATH = "data/input.txt";
    /**
     * Regex pattern for strings containing alphanumeric characters and at
     * least one number equal to or higher than 10.
     */
    static final String REGEX_PATTERN = "[A-Za-z0-9]*[1-9]\\d+[A-Za-z0-9]*";

    public static void main(String[] args) throws Exception {
        File inputFile = new File(INPUT_PATH);
        List<String> inputList = new ArrayList<>();
        BufferedReader bufferedReader
                = new BufferedReader(new FileReader(inputFile));

        // Stores lines from the input file to an input list.
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            inputList.add(line);
        }

        // Filters lines in the input list and prints them.
        inputList.stream()
                .filter(SpecialTask::matchesPattern)
                .forEach(System.out::println);
    }

    /**
     * Checks whether the given line matches the regex pattern.
     *
     * @param line  string to match against the regex pattern
     * @return      boolean value depicting whether the line matches the pattern
     */
    public static boolean matchesPattern(String line) {
        Pattern pattern = Pattern.compile(REGEX_PATTERN);
        Matcher matcher = pattern.matcher(line);
        return matcher.matches();
    }
}
