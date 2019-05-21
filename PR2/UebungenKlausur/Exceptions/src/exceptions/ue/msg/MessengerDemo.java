package exceptions.ue.msg;

import java.util.ArrayList;
import java.util.List;

public class MessengerDemo
{
    public static void main(String[] args)
    {
        MessengerService messengerService = new MessengerService();
        List<Message> pendingMessages = new ArrayList<>();

        // to prove that the exception gets caught this block stands alone
        try
        {
            User err = new User("Will Throw", "unsure", false);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("caught exception: " + e);
        }

        try
        {
            User u1 = new User("Tywin", "online", false);
            User u2 = new User("Cersei", "offline", false);
            User u3 = new User("Tyrione", "online", true);
            User u4 = new User("Jaime", "online", false);

            messengerService.registerUser(u1);
            messengerService.registerUser(u2);
            messengerService.registerUser(u3);
            messengerService.registerUser(u4);

            pendingMessages.add(new DirectMessage("The things you do for love...", u4, u2));
            pendingMessages.add(new DirectMessage("Whatcha doin' tonight?", u2, u4));
            pendingMessages.add(new DirectMessage("Take this!", u3, u1));
            pendingMessages.add(new BroadcastMessage("urghhhh...!", u1));
            pendingMessages.add(new BroadcastMessage("Hah hah hah hah stain' alive", u3));
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("caught IllegalArgumentException: " + e);
        }
        catch (MessengerException e)
        {
            System.out.println("caught MessengerException: " + e);
        }
        catch (UserAlreadyExistsException e)
        {
            System.out.println("caught UserAlreadyExistsException: " + e);
        }


        for (Message m :
                pendingMessages)
        {
            try
            {
                // no idea if we ever learned reflection like this
                // thats the only way i figured to send everything out of a single loop
                if (m.getClass() == DirectMessage.class)
                    messengerService.sendDirectMessage((DirectMessage) m);
                else
                    messengerService.sendBroadcastMessage((BroadcastMessage)m);
            }
            catch (UserNotFoundException e)
            {
                System.out.println("caught UserNotFoundException: " + e);
            } catch (UserOfflineException e)
            {
                System.out.println("caught UserOfflineException: " + e);
            } catch (UserNotAdminException e)
            {
                System.out.println("caught UserNotAdminException: " + e);
            }
        }
    }
}
