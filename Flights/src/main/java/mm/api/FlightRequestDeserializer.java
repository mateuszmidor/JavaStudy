package mm.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;


public class FlightRequestDeserializer {
    public static FlightRequest deserialize(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, FlightRequest.class);
        } catch (IOException e) {
            Log.e(e);
            return FlightRequest.NULL;
        }
    }
}
