package client;

/**
 * User: Andrey
 * Date: 09.03.14
 * Time: 17:02
 */
public interface CacheProtocol {

    public Response getValue(String key) throws Exception;

    public Response putValue(String key, String value) throws Exception;
}
