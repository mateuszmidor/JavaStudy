package mm.api;

import org.junit.Test;

import static org.junit.Assert.*;

public class JsonSchemaValidatorTest {

    @Test
    public void isJsonValidTrue() {
        String data = QuoteConverter.singleToDouble(TestJson.JSON_VALID_DATA);
        String schema = QuoteConverter.singleToDouble(TestJson.JSON_SCHEMA);
        boolean valid = JsonSchemaValidator.isJsonValid(data, schema);
        assertTrue(valid);
    }

    @Test
    public void isJsonValidFalse() {
        String data = QuoteConverter.singleToDouble(TestJson.JSON_INVALID_DATA);
        String schema = QuoteConverter.singleToDouble(TestJson.JSON_SCHEMA);
        boolean valid = JsonSchemaValidator.isJsonValid(data, schema);
        assertFalse(valid);
    }

    @Test
    public void isJsonValidFromFile1() {
        String data = QuoteConverter.singleToDouble(TestJson.INT_OR_STRING_LIST_DATA);
        String schema = QuoteConverter.singleToDouble(TestJson.INT_OR_STRING_LIST_SCHEMA);
        boolean valid = JsonSchemaValidator.isJsonValid(data, schema);
        assertTrue(valid);
    }

    @Test
    public void isJsonValidFromFile2() {
        String data = QuoteConverter.singleToDouble(TestJson.FRUIT_OR_SWEET_LIST_DATA);
        String schema = QuoteConverter.singleToDouble(TestJson.FRUIT_OR_SWEET_LIST_SCHEMA);
        boolean valid = JsonSchemaValidator.isJsonValid(data, schema);
        assertTrue(valid);
    }
}