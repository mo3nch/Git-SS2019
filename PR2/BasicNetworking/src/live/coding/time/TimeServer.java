package live.coding.time;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class TimeServer {

    public static void main(String[] args) {

        try {

            System.out.println("binding server socket to port 1111");
            ServerSocket seso  = new ServerSocket(1111);
            int counter = 0;

            while(true) {

                if(++counter > 3) {
                    System.out.println("too many clients handled");
                    break;
                }

                System.out.println("waiting for clients...");

                try(
                        Socket socket = seso.accept();
                        BufferedWriter bw =
                            new BufferedWriter(
                                new OutputStreamWriter(socket.getOutputStream()));
                ) {
                    LocalDateTime ldt = LocalDateTime.now();
                    System.out.println("  -> sending to client "+counter+": " + ldt);
                    bw.write(ldt.toString());
                    bw.newLine();
                    bw.flush();
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("exiting the server");
    }
}
