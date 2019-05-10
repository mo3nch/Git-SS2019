package Counter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter implements Runnable
{
    private static int count = 0;
    private static Object lockCount = "";
    private static Lock lockOCount = new ReentrantLock();

    @Override
    public void run()
    {
        for (int i = 0; i < 1000000; i++)
        {
            increase();
        }
    }

    // sync lösung
//    public void increase()
//    {
//        synchronized (lockCount)
//        {
//            count++;
//        }
//    }

    public void increase()
    {
        lockOCount.lock();
        try
        {
            count++;
        }
        finally
        {
            lockOCount.unlock();
        }
    }

    public int getCount()
    {
        return count;
    }
}
