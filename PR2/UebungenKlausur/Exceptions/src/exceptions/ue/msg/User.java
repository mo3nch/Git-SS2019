package exceptions.ue.msg;

import java.util.Objects;

public class User
{
    public static String STATUS_ONLINE  = "online";
    public static String STATUS_OFFLINE = "offline";

    private String name;
    private String status;
    private boolean isAdmin;

    public User(String name, String status, boolean isAdmin)
            throws IllegalArgumentException
    {
        if (!status.equals(this.STATUS_ONLINE) &&
            !status.equals(this.STATUS_OFFLINE))
            throw new IllegalArgumentException("status: " + status + " is not allowed!");

        this.name = name;
        this.status = status;
        this.isAdmin = isAdmin;
    }

    public String getName()
    {
        return name;
    }

    public String getStatus()
    {
        return status;
    }

    public boolean isAdmin()
    {
        return isAdmin;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public void setAdmin(boolean admin)
    {
        isAdmin = admin;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name);
    }
}
