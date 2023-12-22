package co.com.sofka.objeto;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Users {
    private String createdAt;

    private String name;

    private String id;

    private String job;
    @JsonProperty("createdAt")
    public String getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt (String createdAt)
    {
        this.createdAt = createdAt;
    }
    @JsonProperty("name")
    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }
    @JsonProperty("id")
    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }
    @JsonProperty("job")
    public String getJob ()
    {
        return job;
    }

    public void setJob (String job)
    {
        this.job = job;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [createdAt = "+createdAt+", name = "+name+", id = "+id+", job = "+job+"]";
    }
}
