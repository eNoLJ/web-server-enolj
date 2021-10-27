package request;

import util.status.HttpMethod;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpRequestInfo {

    private StartLine startLine;
    private RequestHeader requestHeader;
    private RequestBody requestBody;

    public HttpRequestInfo(BufferedReader bufferedReader) throws IOException {
        this.startLine = StartLine.of(bufferedReader);
        this.requestHeader = RequestHeader.of(bufferedReader);
        this.requestBody = RequestBody.of(bufferedReader, requestHeader);
    }

    public HttpMethod getHttpMethod() {
        return startLine.getHttpMethod();
    }

    public String getRequestTarget() {
        return startLine.getRequestTarget();
    }
}
