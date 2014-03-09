import client.HTTPProtocol;
import client.Response;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

/**
 * User: Andrey
 * Date: 08.03.14
 * Time: 21:55
 */
public class CacheTestThread implements Runnable {
//    final Logger logger = LoggerFactory.getLogger(CacheTestThread.class);
    private int op = 1000;
    private int id = 0;
    HTTPProtocol hp;
    public CacheTestThread(int operations,int id) {

        this.op = operations;
        this.id = id;
        hp = new HTTPProtocol("localhost",8182);
    }


    @Override
    public void run() {
        for(int i = 0;i<this.op;i++){
            String key = "thread1"+id;
            String value = "value"+id;
            Response r =  hp.setValue(key, value);
            if(r.getResponseCode()==200){
                Response rGet = hp.getValue(key);
                if(rGet.getResponseCode()==200){
                    if(!rGet.getResponse().equals(value)){
//                        logger.error("invalid value");
                    }
                }
            }

        }
    }



}
