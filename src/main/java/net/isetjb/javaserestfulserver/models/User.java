package net.isetjb.javaserestfulserver.models;

/**
 *
 * @author nafaa
 */
import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class User implements Serializable
{
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String profession;

    public User()
    {
    }

    public User(int id, String name, String profession)
    {
        this.id = id;
        this.name = name;
        this.profession = profession;
    }

    @XmlElement
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @XmlElement
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @XmlElement
    public String getProfession()
    {
        return profession;
    }

    public void setProfession(String profession)
    {
        this.profession = profession;
    }

}
