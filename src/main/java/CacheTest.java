/**
 * User: Andrey
 * Date: 08.03.14
 * Time: 21:55
 */
public class CacheTest {

    public static void main(String[] args) {
        int threads = 100;
        int operations = 100;


        testCache(threads, operations);
    }

    private static void testCache(int threads, int operations) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < threads; i++) {
            new CacheTestThread(operations, i).run();
        }
        System.out.println((System.currentTimeMillis()-start)/1000D);

    }

}
