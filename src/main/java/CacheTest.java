/**
 * User: Andrey
 * Date: 08.03.14
 * Time: 21:55
 */
public class CacheTest {

    public static void main(String[] args) {
        int threads = 10;
        int operations = 100;


        testCache(threads, operations);
    }

    private static void testCache(int threads, int operations) {

        for (int i = 0; i < threads; i++) {
            new CacheTestThread(operations, i).run();
        }

    }

}
