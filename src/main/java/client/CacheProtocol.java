package client;

/**
 * User: Andrey
 * Date: 09.03.14
 * Time: 17:02
 */
public interface CacheProtocol {

    public Response getValue(String key);

    public Response setValue(String key, String value);
}
