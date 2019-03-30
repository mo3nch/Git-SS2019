package exceptions.ue.account;

public class BankDemo
{
    public static void main(String[] args)
    {
        Bank bank = new Bank();

        System.out.println("Adding accounts now...");
        try
        {
            bank.addAccount("Susi", 1000.00, 500.00);
            bank.addAccount("Peter", 1000.00, 500.00);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        System.out.println("Transferring valid money...");
        try
        {
            bank.transfer("Susi", "Peter", 1200.00);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        System.out.println("Transferring invalid money...");
        try
        {
            bank.transfer("Susi", "Peter", 400.00);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        System.out.println("Adding Susi again...");
        try
        {
            bank.addAccount("Susi", 1000.00, 500.00);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        System.out.println("Invalid account...");
        try
        {
            bank.transfer("Herbert", "Peter", 400.00);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }
}
