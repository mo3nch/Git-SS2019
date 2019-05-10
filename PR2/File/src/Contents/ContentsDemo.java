package Contents;

import java.io.File;

public class ContentsDemo
{
    public static void main(String[] args)
    {
        File file = new File("D:\\OneDrive - FH CAMPUS 02\\Git\\PR2\\File");

        if (file.isDirectory())
        {
            File[] fileList = file.listFiles();
            long total = 0;

            for (File f: fileList)
            {
                System.out.println("filename: " + f.getName() + "; size: " + f.length());
                total += f.length();
            }

            System.out.println("total = " + total);
        }
    }
}
