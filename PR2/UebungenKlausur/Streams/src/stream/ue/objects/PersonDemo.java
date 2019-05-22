package stream.ue.objects;

import java.util.Scanner;

public class PersonDemo
{
    // change this to where ever your files should be
    static String resourcePath = "D:\\Git\\Git-SS2019\\PR2\\UebungenKlausur\\Streams\\res\\";

    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        System.out.println("What do you want to do? (r/w): ");
        String action = console.nextLine();
        switch (action)
        {
            case "r":
            {
                System.out.println("Please enter source filename: ");
                String inputFile = console.nextLine();
                readStuff(inputFile);
                break;
            }
            case "w":
            {
                System.out.println("Please enter destination filename: ");
                String outputFile = console.nextLine();

                writeStuff(outputFile);
                break;
            }
            default:
                System.out.println("How bout no?");
        }


    }

    static void readStuff(String inputFile)
    {
        PersonManager pm = new PersonManager();

        pm.loadPerson(resourcePath + inputFile);
    }

    static void writeStuff(String outputFile)
    {
        PersonManager pm = new PersonManager();

        Person p1 = new Person("Iron", "Man", 43);
        Person p2 = new Person("Incredible", "Hulk", 40);
        Person p3 = new Person("Captain", "America", 125);

        pm.addPerson(p1);
        pm.addPerson(p2);
        pm.addPerson(p3);

        pm.savePerson(resourcePath + outputFile);
        System.out.println("Please check " + outputFile + " for results.");
    }
}
