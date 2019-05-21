package exceptions.ue.msg;

// supposed to extend MessengerException, however superclass nowhere to be found
public class MessageToSelfException extends MessengerException
{
    public MessageToSelfException(String message)
    {
        super(message);
    }
}
