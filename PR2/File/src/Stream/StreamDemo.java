package Stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StreamDemo
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("D:\\OneDrive - FH CAMPUS 02\\Git\\PR2\\File\\Demo.txt");

        FileInputStream fis = null;

        try
        {
            fis = new FileInputStream(file);

            int byteRead;
            while((byteRead = fis.read()) != -1)
            {
                char[] input = Character.toChars(byteRead);
                System.out.print(input[0]);
            }

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (fis != null)
                fis.close();
        }
    }

}
