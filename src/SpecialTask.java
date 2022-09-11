import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Contains a main method that reads an input file containing alphanumeric
 * strings and prints out the ones containing at least one number equal to or
 * higher than 10.
 * The input file path should be provided via command line args.
 *
 * @version 1.09 09 Sep 2022
 * @author Viktorija Baikauskaite
 */

public class SpecialTask {
    /**
     * Regex pattern for strings containing alphanumeric characters and at
     * least one number equal to or higher than 10.
     */
    static final String REGEX_PATTERN = "^[A-Za-z0-9]*?[1-9]\\d+[A-Za-z0-9]*$";

    /**
     * Prints string containing at least one number equal to or higher than 10
     * from an input file containing alphanumeric strings.
     *
     * @param args      path to input file containing alphanumeric strings
     */
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Please provide a path to a .txt input file.");
            System.exit(1);
        }

        // Uses command line args for depicting the input file path
        String inputFilePath = args[0];
        File inputFile = new File(inputFilePath);
        BufferedReader bufferedReader
                = new BufferedReader(new FileReader(inputFile));

        // Filters lines from the input file and prints them.
        Pattern pattern = Pattern.compile(REGEX_PATTERN);
        bufferedReader.lines()
                .filter(x -> matchesPattern(x, pattern))
                .forEach(System.out::println);
    }

    /**
     * Checks whether the given line matches the regex pattern.
     *
     * @param line      string to match against the regex pattern
     * @param pattern   regex pattern to match
     * @return          boolean value depicting whether the line matches the
     *                  pattern
     */
    public static boolean matchesPattern(String line, Pattern pattern) {
        Matcher matcher = pattern.matcher(line);
        return matcher.matches();
    }
}
