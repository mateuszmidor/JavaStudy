package mm.api;

public class QuoteConverter {
    static public String singleToDouble(String input) {
        return input.replaceAll("'", "\"");
    }
}
