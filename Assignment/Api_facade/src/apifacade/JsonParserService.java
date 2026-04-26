package apifacade;

public class JsonParserService {

    public String getAttributeValue(String json, String attributeName) {
        String key = "\"" + attributeName + "\"";

        int keyIndex = json.indexOf(key);

        if (keyIndex == -1) {
            throw new IllegalArgumentException("Attribute not found: " + attributeName);
        }

        int colonIndex = json.indexOf(":", keyIndex);

        if (colonIndex == -1) {
            throw new IllegalArgumentException("Invalid JSON format.");
        }

        int valueStart = colonIndex + 1;

        while (valueStart < json.length() && Character.isWhitespace(json.charAt(valueStart))) {
            valueStart++;
        }

        if (valueStart >= json.length()) {
            throw new IllegalArgumentException("Invalid JSON value.");
        }

        if (json.charAt(valueStart) == '"') {
            int valueEnd = json.indexOf("\"", valueStart + 1);

            if (valueEnd == -1) {
                throw new IllegalArgumentException("Invalid JSON string value.");
            }

            return json.substring(valueStart + 1, valueEnd);
        }

        int valueEnd = valueStart;

        while (valueEnd < json.length()
                && json.charAt(valueEnd) != ','
                && json.charAt(valueEnd) != '}') {
            valueEnd++;
        }

        return json.substring(valueStart, valueEnd).trim();
    }
}