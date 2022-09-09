import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpecialTask {
    static final String INPUT_PATH = "data/input.txt";
    static final String REGEX_PATTERN = "[A-Za-z0-9]*[1-9]\\d+[A-Za-z0-9]*";

    public static void main(String[] args) throws Exception {
        File inputFile = new File(INPUT_PATH);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
        List<String> inputList = new ArrayList<>();

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            inputList.add(line);
        }

        inputList.stream()
                .filter(SpecialTask::matchesPattern)
                .forEach(System.out::println);
    }

    public static boolean matchesPattern(String line) {
        Pattern pattern = Pattern.compile(REGEX_PATTERN);
        Matcher matcher = pattern.matcher(line);
        return matcher.matches();
    }
}
