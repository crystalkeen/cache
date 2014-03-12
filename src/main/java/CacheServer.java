import cache.GetResource;
import cache.PutResource;
import org.restlet.Component;
import org.restlet.data.Protocol;
import org.restlet.resource.ServerResource;
import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.apache.commons.daemon.DaemonInitException;
import org.restlet.routing.Router;

public class CacheServer extends ServerResource implements Daemon {

    public static void main(final String[] args) throws Exception {
        runServer(8182);
    }

    private static void runServer(int port) throws Exception {
        final Component component = new Component();
        component.getServers().add(Protocol.HTTP, port);
        final Router router = new Router(component.getContext().createChildContext());

        router.attach("/get", GetResource.class);
        router.attach("/put", PutResource.class);

        component.getDefaultHost().attach("/scan", router);
        component.start();
    }


    @Override
    public void init(DaemonContext daemonContext) throws DaemonInitException, Exception {

    }

    @Override
    public void start() throws Exception {

    }

    @Override
    public void stop() throws Exception {

    }

    @Override
    public void destroy() {

    }
}
