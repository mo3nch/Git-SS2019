package exceptions.ue.account;

public class BankException extends Exception
{
    public BankException(Throwable cause)
    {
        super(cause);
    }

    public BankException(String s)
    {
        super(s);
    }
}
