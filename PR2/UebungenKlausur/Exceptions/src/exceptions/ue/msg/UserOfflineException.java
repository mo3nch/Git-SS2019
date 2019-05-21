package exceptions.ue.msg;

// supposed to extend MessengerException, however superclass nowhere to be found
public class UserOfflineException extends Exception {
    public UserOfflineException(String message)
    {
        super(message);
    }
}
