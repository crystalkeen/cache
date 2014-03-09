package client;

/**
 * User: Andrey
 * Date: 09.03.14
 * Time: 17:05
 */
public class Response {
    String response;
    int responseCode;

    public Response(String response, int responseCode) {
        this.response = response;
        this.responseCode = responseCode;
    }

    public String getResponse() {
        return response;
    }

    public int getResponseCode() {
        return responseCode;
    }
}
