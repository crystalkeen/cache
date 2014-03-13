import client.HttpProtocol;
import client.Response;

/**
 * User: Andrey
 * Date: 08.03.14
 * Time: 21:55
 */
public class CacheTestThread implements Runnable {
//        final Logger logger = LoggerFactory.getLogger(CacheTestThread.class);
    private int op = 1000;
    private int id = 0;
    HttpProtocol httpProtocol;

    public CacheTestThread(int operations, int id) {

        this.op = operations;
        this.id = id;
        httpProtocol = new HttpProtocol("localhost", 8182);
    }


    @Override
    public void run() {
        for (int i = 0; i < this.op; i++) {
            String key = "thread1" + id;
            String value = "value" + id;
            Response r = null;
            try {
                r = httpProtocol.putValue(key, value);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Response rGet = null;
            try {
                rGet = httpProtocol.getValue(key);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(rGet==null){
                System.out.println("error: no response");
            }else{
                if (rGet.getResponseCode() == 200) {
                    if (!rGet.getResponse().equals(value)) {
                        System.out.println("error value");
//                        logger.error("invalid value");
                    }
                }
            }

        }
    }


}
