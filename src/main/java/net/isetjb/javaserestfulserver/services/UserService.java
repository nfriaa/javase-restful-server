package net.isetjb.javaserestfulserver.services;

import net.isetjb.javaserestfulserver.models.UserDao;
import net.isetjb.javaserestfulserver.models.User;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Context;

/**
 *
 * @author nafaa
 */
@Path("/UserService")
public class UserService
{
    // init :
    private static UserDao userDao = new UserDao();

    private static final String SUCCESS_XML = "<return><returnCode>1</returnCode><returnMessage>USER_CREATION_SUCCESS</returnMessage></return>";
    private static final String FAILURE_XML = "<return><returnCode>0</returnCode><returnMessage>USER_CREATION_FAILURE</returnMessage></return>";
    private static final String SUCCESS_JSON = "{\"returnCode\":1,\"returnMessage\":\"USER_CREATION_SUCCESS\"}";
    private static final String FAILURE_JSON = "{\"returnCode\":0,\"returnMessage\":\"USER_CREATION_FAILURE\"}";

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers()
    {
        return userDao.getUsers();
    }

    @GET
    @Path("/users/{userid}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("userid") int userid)
    {
        return userDao.getUser(userid);
    }

    @PUT
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String createUser(
            @FormParam("id") int id,
            @FormParam("name") String name,
            @FormParam("profession") String profession)
    {
        User user = new User(id, name, profession);
        int result = userDao.addUser(user);
        if (result == 1)
        {
            return SUCCESS_JSON;
        }

        return FAILURE_JSON;
    }

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String getHelloWorldMessage()
    {
        return "Hello World !";
    }
}
