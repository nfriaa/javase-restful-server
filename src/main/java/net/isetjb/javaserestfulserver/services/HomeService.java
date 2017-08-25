package net.isetjb.javaserestfulserver.services;

import javafx.scene.input.DataFormat;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author nafaa
 */
@Path("/")
public class HomeService
{
    @GET
    //@Path("/") // pas de path => on utiliser celui de la classe
    @Produces(MediaType.TEXT_HTML)
    public String getHomePage()
    {
        String html = "";
        html += "<h1>Serveur Rest [ Accueil ]</h1>"
                + "<hr/>"
                + "<em>Bienvenue dans notre application REST... </em>"
                + "<br/><br/>"
                + "Exemples d'URLs : "
                + "<br/><br/>"
                + "<a href=\"apropos/\">/apropos</a>"
                + "<br/><br/>"
                + "<a href=\"UserService/test/\">/UserService/test</a>"
                + "<br/><br/>"
                + "<a href=\"UserService/users/\">/UserService/users</a>"
                + "<br/><br/>"
                + "<a href=\"UserService/users/2\">/UserService/users/2</a>";
        return html;
    }

    @GET
    @Path("/apropos")
    @Produces(MediaType.TEXT_HTML)
    public String getAproposPage()
    {
        return "<h1>Serveur Rest [ A propos ]</h1><hr/><em>Page Apropos ici... <br/><a href=\"/\">Accueil</a></em>";
    }
}
