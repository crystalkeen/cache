package client;

import org.restlet.resource.ClientResource;

import java.io.IOException;

public class CacheClient {

    public static void main(String[] args) {

        String url = "http://localhost:8182/scan/get/fkjkjk";

        try {
            ClientResource client = new ClientResource(url);
            System.out.println(client.get().getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
