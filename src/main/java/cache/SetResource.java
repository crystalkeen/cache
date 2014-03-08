package cache;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class SetResource extends ServerResource {
    @Get
    public String doGet() {

        String key = getQuery().getValues("key");
        String value = getQuery().getValues("value");
        String lifeTime = getQuery().getValues("time");

        CacheMap.put(key, value, Long.valueOf(lifeTime));

        return "ok";
    }
}