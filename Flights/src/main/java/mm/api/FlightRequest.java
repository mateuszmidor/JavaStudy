package mm.api;

import java.util.ArrayList;

public class FlightRequest {
    public ArrayList<FlightSegment> segments;

    public static final FlightRequest NULL = new FlightRequest();
}
