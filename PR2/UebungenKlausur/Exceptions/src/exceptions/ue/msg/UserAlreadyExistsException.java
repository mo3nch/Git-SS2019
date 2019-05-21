package exceptions.ue.msg;

// supposed to extend MessengerException, however superclass nowhere to be found
public class UserAlreadyExistsException extends Exception {

    public UserAlreadyExistsException(String message)
    {
        super(message);
    }
}
