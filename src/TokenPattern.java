import java.util.regex.Pattern;

class TokenPattern {
    private String pattern;
    private String type;
    private Pattern compiledPattern;


    public TokenPattern(String pattern, String type) {
        this.pattern = pattern;
        this.type = type;
        this.compiledPattern = Pattern.compile(this.pattern);
    }
    // getters, match method, etc
    public String getPattern() {
        return this.pattern;
    }
    public String getType() {
        return this.type;
    }
    public Pattern getCompiledPattern() {
        return this.compiledPattern;
    }
}

