package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * User: Andrey
 * Date: 09.03.14
 * Time: 16:58
 */
public class HTTPProtocol implements CacheProtocol{

    String  host=null;
    Integer port=null;


    public HTTPProtocol(String host, Integer port) {
        this.host = host;
        this.port = port;
    }

    private Response sendGet() throws Exception {

        String url = "http://www.google.com/search?q=mkyong";

        URL obj = new URL(url);
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
        System.out.println(response.toString());
        return new Response(response.toString(),responseCode);

    }

    @Override
    public Response getValue(String key) {
        return new Response(null,200);
    }

    @Override
    public Response setValue(String key, String value) {
        return new Response(null,200);
    }
}
