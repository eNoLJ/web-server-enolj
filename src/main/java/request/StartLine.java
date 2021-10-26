package request;

import util.status.HttpMethod;

public class StartLine {

    private HttpMethod httpMethod;
    private String requestTarget;
    private String httpVersion;

    public StartLine(HttpMethod httpMethod, String requestTarget, String httpVersion) {
        this.httpMethod = httpMethod;
        this.requestTarget = requestTarget;
        this.httpVersion = httpVersion;
    }
}
