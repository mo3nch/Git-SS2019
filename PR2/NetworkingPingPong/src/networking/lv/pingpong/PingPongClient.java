package networking.lv.pingpong;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class PingPongClient
{
    public static void main(String[] args)
    {
        System.out.println("Connecting to Server");

        try
        {
            Socket socket = new Socket("localhost", 3333);

            System.out.println("Successfully connected");

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream()));

            Scanner cin = new Scanner(System.in);
            String input;

            while (true)
            {
                input = cin.nextLine();
                if (input == null || input.equals("quit"))
                    break;

                bw.write(input);
                bw.newLine();
                bw.flush();

                System.out.println("received: " + br.readLine());
            }

            socket.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
