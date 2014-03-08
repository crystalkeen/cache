/**
 * User: Andrey
 * Date: 08.03.14
 * Time: 21:55
 */
public class CacheTestThread implements Runnable {
    private int op = 1000;
    private int id = 0;
    public CacheTestThread(int operations,int id) {
        this.op = operations;
        this.id = id;
    }

    @Override
    public void run() {
        for(int i = 0;i<this.op;i++){
            String key = "thread1"+id;
            String value = "value"+id;
        }
    }



}
