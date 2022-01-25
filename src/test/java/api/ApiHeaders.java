package api;

import java.util.HashMap;
import java.util.Map;

public class ApiHeaders {
    protected static Map<String, String> headers = new HashMap<>();

    public Map<String, String> gameOfThrones() {
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        return headers;
    }
}