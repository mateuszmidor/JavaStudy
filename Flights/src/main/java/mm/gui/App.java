package mm.gui;

import mm.api.FlightRequest;
import mm.api.FlightRequestDeserializer;
import mm.api.TextFileReader;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        final String JSON_FILENAME = "FlightsRequest.json";
        String json = TextFileReader.readAll(JSON_FILENAME);
        FlightRequest fr = FlightRequestDeserializer.deserialize(json);
        System.out.format("From: %s, To: %s", fr.from, fr.to);
    }
}
