package cache;

import client.HttpProtocol;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 * Created by tty on 3/30/2014.
 */
public class SimpleOkServise extends ServerResource {


    @Get
    public String doGet(){
        return "ok";

    }

}
