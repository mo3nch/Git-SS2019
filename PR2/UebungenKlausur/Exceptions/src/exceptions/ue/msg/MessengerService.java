package exceptions.ue.msg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessengerService
{
    private Map<String, User> users = new HashMap<>();
    private List<Message> history = new ArrayList<>();

    public void registerUser(User user)
            throws UserAlreadyExistsException
    {
        if (users.containsKey(user.getName()))
            throw new UserAlreadyExistsException("User " + user.getName() + " already exists!");

        users.put(user.getName(), user);
    }

    public void unregisterUser(User user)
        throws UserNotFoundException
    {
        if (!users.containsKey(user.getName()))
            throw new UserNotFoundException("User " + user.getName() + " not existing!");

        users.remove(user.getName());
    }

    public void sendDirectMessage(DirectMessage message)
            throws UserNotFoundException, UserOfflineException
    {
        if (!users.containsKey(message.getFrom().getName()))
            throw new UserNotFoundException("User " + message.getFrom() + " not existing!");

        if (!users.containsKey(message.getTo().getName()))
            throw new UserNotFoundException("User " + message.getTo() + " not existing!");

        if (users.get(message.getTo().getName())
                .getStatus().equals(User.STATUS_OFFLINE))
            throw new UserOfflineException("User " + message.getTo() + " is offline!");

        history.add(message);
        System.out.println("sent message = " + message.getText());
    }

    public void sendBroadcastMessage(BroadcastMessage message)
            throws UserNotAdminException
    {
        if (!message.getFrom().isAdmin())
            throw new UserNotAdminException("User " + message.getFrom() + " has insufficient power!");

        history.add(message);

        System.out.println("sent message = " + message.getText());
        for (Map.Entry<String, User> entry : users.entrySet())
        {
            if (!entry.equals(message.getFrom()))
                System.out.println("broadcasting to: " + entry.getValue().getName());
        }

    }
}
