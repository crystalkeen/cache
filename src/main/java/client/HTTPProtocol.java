package client;

import com.google.common.base.Joiner;
import org.eclipse.jetty.util.URIUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.security.URIParameter;
import java.util.HashMap;
import java.util.Map;

/**
 * User: Andrey
 * Date: 09.03.14
 * Time: 16:58
 */
public class HttpProtocol implements CacheProtocol {

    String host = null;
    Integer port = null;


    public HttpProtocol(String host, Integer port) {
        this.host = host;
        this.port = port;
    }

    private Response sendGet(String action, String key, String value) throws Exception {
        Map<String, String> params = new HashMap<String, String>(2);
        params.put("key", key);
        params.put("value", value);

        Joiner.MapJoiner joiner = Joiner.on("&").withKeyValueSeparator("=").useForNull("");
        String query = joiner.join(params);

        URL obj = new URL("http", host, 8182, "/scan/" + action + "?" + query);

        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header

        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
//        System.out.println(response.toString());
        return new Response(response.toString(), responseCode);

    }

    @Override
    public Response getValue(String key) throws Exception {
        return sendGet("get", key, null);
    }

    @Override
    public Response putValue(String key, String value) throws Exception {
        return sendGet("put", key, value);
    }

    public Response gaskValueTest() throws Exception{
        return sendGet("test", "","");

    }
}
