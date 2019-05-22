package live.coding.time;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TimeClient {

    public static void main(String[] args) {

        System.out.println("connecting to server");
        try (Socket s = new Socket("localhost",1111);

             BufferedReader br =
                     new BufferedReader(
                             new InputStreamReader(
                                     s.getInputStream()))) {

            System.out.println("reading from server");
            String datetime = br.readLine();
            System.out.println("  -> datetime: " + datetime);


        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("exiting the client");
    }
}
