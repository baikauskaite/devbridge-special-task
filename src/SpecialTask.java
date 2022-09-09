import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class SpecialTask {

    static final String INPUT_PATH = "data/input.txt";

    public static void main(String[] args) throws Exception {
        File inputFile = new File(INPUT_PATH);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
        List<String> inputList = new ArrayList<>();

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            inputList.add(line);
        }
    }
}
