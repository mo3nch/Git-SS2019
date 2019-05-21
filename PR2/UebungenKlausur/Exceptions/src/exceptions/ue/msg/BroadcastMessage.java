package exceptions.ue.msg;

public class BroadcastMessage extends Message
{
    private User from;

    public BroadcastMessage(String text, User from)
    {
        super(text);

        this.from = from;
    }

    public User getFrom()
    {
        return from;
    }
}
