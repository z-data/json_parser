import java.io.File;
import java.util.List;
import java.util.ArrayList;

public class JSONParserMain {

    public static void main(String[] args) {

        System.out.println("Parser Started!");
        File json = new File(args[0]);
        System.out.println(args[0]);
        Tokenizer JsonTokenizer = new Tokenizer();
        List<List<String>> tokenList = JsonTokenizer.analyze(json);
        System.out.println("Parser Completed!");


    }

}
