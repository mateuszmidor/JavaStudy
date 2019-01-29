package mm.api;

public class FlightRequest {
    public String from;
    public String to;
    public static final FlightRequest NULL = new FlightRequest("[NULL]", "[NULL]");

    public FlightRequest() {
        this("[NONE]", "[NONE]");
    }
    public FlightRequest(String from, String to) {
        this.from = from;
        this.to = to;
    }
}
