package exceptions.ue.account;

import javax.security.auth.login.AccountNotFoundException;
import java.util.HashMap;

public class Bank
{
    private HashMap<String, Account> accounts = new HashMap<>();

    public void addAccount(String owner, double balance,
                           double overdraftFrame)
        throws BankException
    {
        if (accounts.containsKey(owner))
            throw new BankException("Owner already has an account!");

        accounts.put(owner, new Account(owner, balance, overdraftFrame));
    }

    public void transfer(String fromOwner, String toOwner, double amount)
        throws AccountNotFoundException, BankException
    {
        Account from = accounts.get(fromOwner);
        Account to = accounts.get(toOwner);

        if (from == null)
            throw new AccountNotFoundException("FromOwner not existing!");

        if (to == null)
            throw new AccountNotFoundException("ToOwner not existing!");

        try
        {
            from.credit(amount);
        }
        catch (NotEnoughMoneyException e)
        {
           throw new BankException(e);
        }

        to.debit(amount);
    }
}
