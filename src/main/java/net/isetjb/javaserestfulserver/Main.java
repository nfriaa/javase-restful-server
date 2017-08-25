package net.isetjb.javaserestfulserver;

import java.net.URI;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

// obligatoire pour le fonctionnement du jar exécutable (convestion object to json) :
import org.glassfish.jersey.jackson.JacksonFeature;
//import javax.ws.rs.ext.MessageBodyWriter;

/**
 *
 * @author nafaa
 */
public class Main
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //URI baseUri = UriBuilder.fromUri("http://localhost/").port(5050).build();
        //URI baseUri = UriBuilder.fromUri("http://0.0.0.0/").port(Integer.parseInt(args[0])).build();
        URI baseUri = UriBuilder.fromUri("http://0.0.0.0/").port(5050).build();

        // uniquement une classe :
        //ResourceConfig config = new ResourceConfig(HomeService.class);
        // pour prendre en charge tout le package :
        ResourceConfig config = new ResourceConfig().packages(true, "net.isetjb.javaserestfulserver.services");

        // obligatoire pour le fonctionnement du jar exécutable (conversion object to json) :
        config.register(JacksonFeature.class);
        // obligatoire pour le fonctionnement du jar exécutable (convesion object to xml) :
        //config.register(JacksonJaxbXMLProvider.class);

        try
        {
            // start grizzly http server :
            HttpServer server = GrizzlyHttpServerFactory.createHttpServer(baseUri, config);
            System.out.println("Serveur Grizzly isStarted ===> " + server.isStarted());

            //server.shutdownNow();
            System.out.println("Press CTRL+C to stop the server...");
        } catch (Exception e)
        {
            System.out.println(e);
        }

    }

}
