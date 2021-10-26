package request;

import java.io.BufferedReader;

public class HttpRequestInfo {

    private StartLine startLine;
    private RequestHeader requestHeader;
    private RequestBody requestBody;

    public HttpRequestInfo(BufferedReader bufferedReader) {

    }
}
