package cache;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class GetResource extends ServerResource {

    @Get
    public String doGet() {
        String key = getQuery().getValues("key");
        return CacheMap.get(key);
    }
}
