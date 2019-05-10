import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TextAnalyzer implements Runnable
{
    private ArrayList<String> strings;

    @Override
    public String toString()
    {
        return "TextAnalyzer{" +
                "countChars=" + countChars +
                "hits=" + hits +
                '}';
    }

    private static int countChars = 0;
    private static Lock countLock = new ReentrantLock();

    private static HashMap<Character, Integer> hits = new HashMap<>();
    private static Lock hitsLock = new ReentrantLock();

    public TextAnalyzer(ArrayList<String> strings)
    {
        this.strings = strings;
    }

    @Override
    public void run()
    {
        String toAnalyze;

        try
        {
            for (int i = 0; i < strings.size(); ++i)
            {
                toAnalyze = strings.get(i);

                System.out.println("Trying to get lock for thread " + Thread.currentThread());
                if (countLock.tryLock(1, TimeUnit.MILLISECONDS))
                {
                    try
                    {
                        analyze(toAnalyze);
                    }
                    finally
                    {
                        countLock.unlock();
                    }
                }
                else
                {
                    --i;
                    System.out.println("Couldn't acquire lock");
                }
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("Interrupted Exception occured");
        }

    }

    public void analyze(String toAnalyze)
    {
        countChars += toAnalyze.length();

        Character currentChar;
        Integer currentCharCount;
        for (int i = 0; i < toAnalyze.length(); ++i)
        {
            currentChar = toAnalyze.charAt(i);

            if (hits.containsKey(currentChar))
            {
                currentCharCount = hits.get(currentChar);
                hits.replace(currentChar, ++currentCharCount);
            }
            else
                hits.put(currentChar, 1);
        }
    }
}
