package net.isetjb.javaserestfulserver.models;

import java.util.ArrayList;
import java.util.List;

//import javax.json.Json;
/**
 *
 * @author nafaa
 */
public class UserDao
{
    public List<User> userList = new ArrayList<User>();

    public UserDao()
    {
        User user1 = new User(1, "aaa", "bbb");
        User user2 = new User(2, "vvv", "www");
        User user3 = new User(3, "xxx", "yyy");
        User user4 = new User(4, "hhh", "uuu");
        User user5 = new User(5, "ggg", "eee");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
    }

    public List<User> getUsers()
    {
        return userList;
    }

    public User getUser(int id)
    {
        for (User user : userList)
        {
            if (user.getId() == id)
            {
                return user;
            }
        }
        return null;
    }

    public int addUser(User tempUser)
    {
        boolean userExists = false;
        for (User user : userList)
        {
            if (user.getId() == tempUser.getId())
            {
                userExists = true;
                break;
            }
        }
        if (!userExists)
        {
            System.out.println(">>> Ajout de User... / userList size : " + userList.size());
            this.userList.add(tempUser);
            System.out.println(">>> User ajouté avec succès / userList size : " + userList.size());
            return 1;
        }
        return 0;
    }
}
