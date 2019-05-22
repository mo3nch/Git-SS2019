package stream.ue.filecopy;

import java.util.Scanner;

public class FileCopyDemo
{
    public static void main(String[] args)
    {
        // change this to where ever your files should be
        String resourcePath = "D:\\Git\\Git-SS2019\\PR2\\UebungenKlausur\\Streams\\res\\";

        Scanner console = new Scanner(System.in);

        System.out.println("Enter source file:");
        String inputFile = resourcePath + console.nextLine();

        System.out.println("Enter destination file:");
        String outputFile = resourcePath + console.nextLine();

        System.out.println("Starting copy process...");
        FileCopy fc = new FileCopy(inputFile, outputFile);
    }
}
