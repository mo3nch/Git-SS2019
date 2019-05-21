package exceptions.ue.msg;

// supposed to extend MessengerException, however superclass nowhere to be found
public class UserNotFoundException extends Exception {
    public UserNotFoundException(String message)
    {
        super(message);
    }
}
