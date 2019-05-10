package Clock;

import java.util.Date;

public class Clock implements Runnable
{
    private boolean shouldRun = true;

    public void pleaseStop()
    {
        shouldRun = false;
    }

    @Override
    public void run()
    {
        while (shouldRun == true)
        {
            Date d = new Date();
            System.out.println(d.toString());

            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

}
