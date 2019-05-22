package stream.ue.filecopy;

import java.io.*;

public class FileCopy
{
    public FileCopy(String input, String output)
    {
        try
        {
            FileInputStream fr = new FileInputStream(new File(input));
            BufferedInputStream bis = new BufferedInputStream(fr);

            FileOutputStream fo = new FileOutputStream(new File(output));
            BufferedOutputStream bos = new BufferedOutputStream(fo);

            int byteRead;
            while ((byteRead = bis.read()) != -1)
            {
                bos.write(byteRead);
            }

            bos.flush();
            bos.close();
            bis.close();

            fr.close();
            fo.close();

            System.out.println("File copy completed.");
        } catch (FileNotFoundException e)
        {
            System.out.println("Holy shit your file is gone!");
        } catch (IOException e)
        {
            System.out.println("Well something went wrong with a stream!");
        }
    }
}
