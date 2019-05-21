package exceptions.ue.msg;

// supposed to extend MessengerException, however superclass nowhere to be found
public class UserNotAdminException extends Exception {
    public UserNotAdminException(String message)
    {
        super(message);
    }
}
