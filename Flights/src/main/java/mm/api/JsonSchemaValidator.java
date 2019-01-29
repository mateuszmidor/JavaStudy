package mm.api;

public class JsonSchemaValidator {
    public static boolean isJsonValid(String json, String schema) {
        try {
            return ValidationUtils.isJsonValid(schema, json);
        } catch (Exception e) {
            Log.e(e);
            return false;
        }
    }
}
