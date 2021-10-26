package request;

import java.util.Map;

public class RequestHeader {

    private final Map<String, String> headers;

    private RequestHeader(Map<String, String> headers) {
        this.headers = headers;
    }
}
