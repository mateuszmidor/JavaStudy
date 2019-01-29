package mm.api;

import org.junit.Test;

import static org.junit.Assert.*;
public class FlightRequestDeserializerTest {

    final static String FLIGHT_JSON = "{\"from\" : \"ATH\", \"to\" : \"KTW\"}";

    @Test
    public void deserializeValidJson() {
        FlightRequest fd = FlightRequestDeserializer.deserialize(FLIGHT_JSON);
        assertEquals("ATH", fd.from);
        assertEquals("KTW", fd.to);
    }

    @Test
    public void deserializeInvalidJson() {
        FlightRequest fd = FlightRequestDeserializer.deserialize("FLIGHT_JSON");
        assertEquals(FlightRequest.NULL, fd);
    }
}