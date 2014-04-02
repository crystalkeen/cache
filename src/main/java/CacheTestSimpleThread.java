import client.HttpProtocol;
import client.Response;

import java.net.ConnectException;
import java.rmi.ServerException;

/**
 * Created by tty on 3/30/2014.
 */
public class CacheTestSimpleThread implements Runnable {
    HttpProtocol httpProtocol;
    private int op = 1000;


    public CacheTestSimpleThread(int operation) {
        this.op = operation;

        httpProtocol = new HttpProtocol("localhost", 8182);
    }


    @Override

    public void run() {
        try {
            for (int i = 0; i < this.op; i++) {

                Response r = httpProtocol.gaskValueTest();
                if (r.getResponseCode() != 200) {
                    throw new ConnectException();
                }
                if (!r.getResponse().equals("ok")) {
                    throw new Exception();
                }
//                System.out.println(r.getResponse());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
