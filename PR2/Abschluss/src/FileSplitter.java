import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileSplitter
{
    ArrayList<String> even = new ArrayList<>();
    ArrayList<String> odd = new ArrayList<>();

    public FileSplitter(String filename)
    {
        int lineNumber = 0;

        try
        {
            FileInputStream fis = new FileInputStream(filename);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

            String line;

            while (true)
            {
                line = reader.readLine();
                if (line == null)
                    break;

                ++lineNumber;

                if (lineNumber % 2 == 0)
                    even.add(line);
                else
                    odd.add(line);
            }
        }
        catch (IOException e)
        {
            System.out.println("This file is gone!");
        }


    }

    public ArrayList<String> getEven()
    {
        return even;
    }

    public ArrayList<String> getOdd()
    {
        return odd;
    }
}
