package exceptions.ue.account;

public class Account
{
    private String owner;
    private double balance;
    private double overdraftFrame;

    public void credit(double amount) throws NotEnoughMoneyException
    {
        if (amount > (balance + overdraftFrame))
            throw new NotEnoughMoneyException();

        balance -= amount;

        if (balance < 0)
        {
            overdraftFrame += balance;
            balance = 0;
        }
    }

    public void debit(double amount)
    {
        balance+=amount;
    }

    public String getOwner()
    {
        return owner;
    }

    public double getBalance()
    {
        return balance;
    }

    public double getOverdraftFrame()
    {
        return overdraftFrame;
    }

    public Account(String owner, double balance, double overdraftFrame)
    {
        this.owner = owner;
        this.balance = balance;
        this.overdraftFrame = overdraftFrame;
    }
}
