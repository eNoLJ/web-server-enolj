package request;

import util.status.HttpMethod;

import java.io.BufferedReader;
import java.io.IOException;

public class StartLine {

    private final HttpMethod httpMethod;
    private final String requestTarget;
    private final String httpVersion;

    private StartLine(HttpMethod httpMethod, String requestTarget, String httpVersion) {
        this.httpMethod = httpMethod;
        this.requestTarget = requestTarget;
        this.httpVersion = httpVersion;
    }

    public static StartLine of(BufferedReader bufferedReader) throws IOException {
        String[] splitStartLine = bufferedReader.readLine().split(" ");
        HttpMethod httpMethod = HttpMethod.valueOf(splitStartLine[0]);
        String requestTarget = splitStartLine[1];
        String httpVersion = splitStartLine[2];
        return new StartLine(httpMethod, requestTarget, httpVersion);
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public String getRequestTarget() {
        return requestTarget;
    }

    public String getHttpVersion() {
        return httpVersion;
    }
}
