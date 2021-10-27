package request;

import util.HttpRequestUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static util.HttpRequestUtils.parseHeader;

public class RequestHeader {

    private final Map<String, String> headers;

    private RequestHeader(Map<String, String> headers) {
        this.headers = headers;
    }

    public static RequestHeader of(BufferedReader bufferedReader) throws IOException {
        Map<String, String> headers = new HashMap<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.equals("")) {
                break;
            }
            if (line.contains(": ")) {
                HttpRequestUtils.Pair pair = parseHeader(line);
                headers.put(pair.getKey(), pair.getValue());
            }
        }
        return new RequestHeader(headers);
    }

    public boolean containsKey(String key) {
        return headers.containsKey(key);
    }

    public int getContentLength() {
        return Integer.parseInt(headers.get("Content-Length"));
    }
}
