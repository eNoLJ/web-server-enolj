package request;

import java.util.Map;

public class RequestBody {

    private final Map<String, String> bodies;

    private RequestBody(Map<String, String> bodies) {
        this.bodies = bodies;
    }
}
