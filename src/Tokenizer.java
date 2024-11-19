import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.*;

public class Tokenizer {
    private File jsonFile;
    private List<List<String>> tokens;

    public List<List<String>> analyze(File inputFile) {
        //read the file and make it all a long string (hopefully read json string)
        //call method to parse the file - needs to determine what each token is
        List<List<String>> tokenList = this.parse(inputFile);
        return tokenList;
    }

    private List<List<String>> parse(File inputFile) {
        List<List<String>> returnValue = new ArrayList<List<String>>();

        Scanner parser = null;
        try {
            parser = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (parser.hasNext()) {
            String jsonString = parser.next();
            //string building logic
            if (jsonString.startsWith("\"") && !jsonString.endsWith(":\"")) {
                while (parser.hasNext()) {
                    String stringBuilder = parser.next();
                    if (stringBuilder.endsWith("\"")) {
                        jsonString += stringBuilder;
                        break;
                    } else {
                        jsonString += stringBuilder;
                    }
                }
            }
            TokenDefinitions tokensFinder = new TokenDefinitions();
            String token = tokensFinder.getToken(jsonString);
            System.out.println(token);
            List<String> outputToken = new ArrayList<>();
            outputToken.add(jsonString);
            outputToken.add(token);
            returnValue.add(outputToken);
        }

        return returnValue;
    }

    private String tokenIdentifier(String value) {
        //have to have the regex to test
        return "TokenType";
    }
}
