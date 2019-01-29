package mm.api;

import org.junit.Test;

import static org.junit.Assert.*;
public class FlightRequestDeserializerTest {

    final static String FLIGHT_JSON = "" +
            "{" +
            "  'segments' :" +
            "  [" +
            "    {'from' : 'KRK', 'to': 'KTW'}," +
            "    {'from' : 'KTW', 'to': 'GDY'}" +
            "  ]" +
            "}";

    @Test
    public void deserializeValidJson() {
        String data = QuoteConverter.singleToDouble(FLIGHT_JSON);
        FlightRequest fd = FlightRequestDeserializer.deserialize(data);

        assertNotNull(fd.segments);
        assertEquals(2, fd.segments.size());

        FlightSegment s0 = fd.segments.get(0);
        assertEquals("KRK", s0.from);
        assertEquals("KTW", s0.to);

        FlightSegment s1 = fd.segments.get(1);
        assertEquals("KTW", s1.from);
        assertEquals("GDY", s1.to);
    }

    @Test
    public void deserializeInvalidJson() {
        FlightRequest fd = FlightRequestDeserializer.deserialize("{INVALID:JSON}");
        assertEquals(FlightRequest.NULL, fd);
    }
}