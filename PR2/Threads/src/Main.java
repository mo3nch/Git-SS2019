import Clock.Clock;
import Counter.Counter;
import Prime.Prime;

import java.io.IOException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        // Beispiel Primzahlen
//        Thread t1 = new Thread(new Prime(1989990047));
//        Thread t2 = new Thread(new Prime(1891999939));
//        Thread t3 = new Thread(new Prime(1891999940));
//
//        try
//        {
//            t1.start();
//            //t1.join();
//            t2.start();
//            //t2.join();
//            t3.start();
//        }
//        catch (Exception e)
//        {}

        // Beispiel Uhr
//        Clock c = new Clock();
//        Thread t1 = new Thread(c);
//
//        t1.start();
//
//        Scanner scanner = new Scanner(System.in);
//        String line = scanner.nextLine();
//
//        c.pleaseStop();

        // Beispiel Counter

        Counter toCheck = new Counter();
        Thread t1 = new Thread(new Counter());
        Thread t2 = new Thread(new Counter());

        try
        {
            t1.start();
            t2.start();

            t1.join();
            t2.join();

            System.out.println("Count = " + toCheck.getCount());
        }
        catch (Exception e)
        {

        }

    }
}
