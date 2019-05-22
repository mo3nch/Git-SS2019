package stream.ue.objects;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonManager
{
    private List<Person> people = new ArrayList<>();

    public void addPerson(Person p)
    {
        people.add(p);
    }

    public void savePerson(String path)
    {
        File f = new File(path);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try
        {
            fos = new FileOutputStream(f);
            oos = new ObjectOutputStream(fos);

            for (Person p : people)
            {
                oos.writeObject(p);
                oos.flush();
            }

            oos.close();
            fos.close();
        } catch (FileNotFoundException e)
        {
            System.out.println("Congratulations, your file is gone!");
        } catch (IOException e)
        {
            System.out.println("Something happened in the fileIO!");
        }
    }

    public void loadPerson(String path)
    {
        File f = new File(path);
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try
        {
            Person p;
            Object o;
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);

            while(true)
            {
                o = ois.readObject();
                if (o == null)
                    break;

                if (o instanceof Person)
                {
                    p = (Person)o;
                    System.out.println("Imported: " + p);
                    people.add(p);
                }
            }
        } catch (EOFException e)
        {
            // do nothing. End of file is nice ;)
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Congratulations, your file is gone!");
        } catch (IOException e)
        {
            System.out.println("Something happened in the fileIO!");
        } catch (ClassNotFoundException e)
        {
            System.out.println("What if you just user superheroes huh?");
        }
        finally
        {
            try
            {
                ois.close();
                fis.close();
            } catch (IOException e)
            {
                System.out.println("All is lost!");
            }
        }
    }
}
