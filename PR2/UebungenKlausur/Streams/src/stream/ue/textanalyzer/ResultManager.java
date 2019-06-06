package stream.ue.textanalyzer;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ResultManager
{
    private HashMap<Character, Integer> results = new HashMap<>();
    private String path;
    private static String ressourcePath = "D:\\OneDrive - FH CAMPUS 02\\Git\\PR2\\UebungenKlausur\\Streams\\res\\";
    private ArrayList<String> inputLines = new ArrayList<>();

    public ResultManager(String path)
    {
        this.path = path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public HashMap<Character, Integer> getResults()
    {
        return results;
    }

    public void read()
            throws TextInputInvalidFormatException
    {
        readLines();

        fillMap();
    }

    private void fillMap()
            throws TextInputInvalidFormatException
    {
        for (String line :
                inputLines)
        {
            String[] columns = line.split(":");

            if (columns.length != 2)
                throw new TextInputInvalidFormatException("Invalid number of columns!");

            if (columns[0].length() > 1)
                throw new TextInputInvalidFormatException("Key too long!");

            results.put((Character)columns[0].charAt(0), Integer.valueOf(columns[1]));
        }
    }

    private void readLines()
    {
        File f = new File(ressourcePath + path);

        FileInputStream fis = null;
        BufferedInputStream bis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        try
        {
            fis = new FileInputStream(f);
            bis = new BufferedInputStream(fis);
            isr = new InputStreamReader(bis);
            br = new BufferedReader(isr);
            
            String line;
            while((line = br.readLine()) != null)
            {
                inputLines.add(line);
            }

        }
        catch (FileNotFoundException e)
        {
            System.out.println("This file is gone!");
        }
        catch (IOException e)
        {
            System.out.println("Something went wrong!");
        }
        finally
        {
            try
            {
                br.close();
                isr.close();
                bis.close();
                fis.close();
            }
            catch (IOException e)
            {
                System.out.println("Something went wrong closing everything!");
            }

        }
    }

    public void write()
    {
        File f = new File(ressourcePath + path);
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        
        try
        {
            fos = new FileOutputStream(f);
            bos = new BufferedOutputStream(fos);

            for (HashMap.Entry<Character, Integer> entry:
                    results.entrySet())
            {
                byte[] key = Character.toString(entry.getKey()).getBytes();
                byte[] value = Integer.toString(entry.getValue()).getBytes();

                bos.write(key);
                bos.write((int) ':');
                bos.write(value);
                bos.write((int) '\r');
                bos.write((int) '\n');
                bos.flush();
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                bos.close();
                fos.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }
    }
}
