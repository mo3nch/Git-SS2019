package networking.lv.pingpong;

import com.sun.jmx.snmp.tasks.Task;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class PingPongServer
{
    private static int counter = 0;

    public static void main(String[] args)
    {
        try
        {
            System.out.println("binding server socket to port 3333");
            ServerSocket seso = new ServerSocket(3333);

            while (true)
            {
                System.out.println("Waiting for client ...");

                if(++counter > 3) {
                    System.out.println("too many clients handled");
                    break;
                }

                Socket socket = seso.accept();
                Thread t = new Thread ( new PingPongServerRunnable(socket));

                t.start();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}
