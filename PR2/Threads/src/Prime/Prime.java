package Prime;

public class Prime implements Runnable
{
    private long number;
    private boolean isPrime = true;

    public Prime(long number)
    {
        this.number = number;
    }

    private void CheckPrime()
    {
        for (int i = 2; i < number/2; ++i)
        {
            if (number % i == 0)
            {
                isPrime = false;
                break;
            }
        } //for (int i = 2; i < number/2; ++i)
    }

    @Override
    public void run()
    {
        CheckPrime();

        System.out.println("Number: " + number + ", isPrime = " + isPrime);
    }
}
