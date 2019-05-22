package networking.lv.pingpong;


import java.io.*;
import java.net.Socket;

public class PingPongServerRunnable implements Runnable
{
    private final Socket socket;

    public PingPongServerRunnable(Socket socket)
    {
        this.socket = socket;
    }

    @Override
    public void run()
    {
        processClient();
    }

    private void processClient()
    {
        try
        {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream()));

            String input;

            while ((input = br.readLine()) != null)
            {
                switch (input)
                {
                    case "ping":
                        bw.write("pong");
                        break;
                    case "pong":
                        bw.write("ping");
                        break;
                    default:
                        bw.write("error");
                }

                bw.newLine();
                bw.flush();
            }

            System.out.println("Client disconnected");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
