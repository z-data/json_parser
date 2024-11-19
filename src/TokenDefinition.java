import java.util.regex.Matcher;
import java.util.ArrayList;
import java.util.List;

class TokenDefinitions {
    private List<TokenPattern> patterns;

    public TokenDefinitions() {
        // Use generics for type safety
        patterns = new ArrayList<>();
        // Add patterns in order of checking
        patterns.add(new TokenPattern("\\{", "LEFT_BRACE"));
        patterns.add(new TokenPattern("\\}", "RIGHT_BRACE"));
        patterns.add(new TokenPattern("\".*?\"", "STRING"));
        // etc...
    }

    public String getToken(String input) {
        for (TokenPattern pattern : patterns) {
            Matcher isMatch = pattern.getCompiledPattern().matcher(input);
            if (isMatch.find()) {
                return pattern.getType(); // Assuming you want the token type
            }
        }
        return "Not Found";
    }
}
