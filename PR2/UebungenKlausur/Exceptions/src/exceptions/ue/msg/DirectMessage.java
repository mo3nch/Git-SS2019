package exceptions.ue.msg;

public class DirectMessage extends Message
{
    private User from;
    private User to;

    public DirectMessage(String text, User from, User to)
            throws MessageToSelfException
    {
        super(text);

        if (from.equals(to))
            throw new MessageToSelfException("Sender and recipient cannot be the same!");

        this.from = from;
        this.to = to;
    }

    public User getFrom()
    {
        return from;
    }

    public User getTo()
    {
        return to;
    }

    @Override
    public String toString()
    {
        return "DirectMessage{" +
                "from=" + from +
                ", to=" + to +
                ", text=" + this.getText() +
                ", datetime=" + this.getDatetime() +
                '}';
    }
}
