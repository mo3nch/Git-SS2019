package live.coding;

import java.io.*;
import java.net.Socket;

public class MySocketDemo {

    public static void main(String[] args) {

        try (
                Socket s = new Socket("www.mysite.at",80);
                BufferedWriter bw = new BufferedWriter(
                     new OutputStreamWriter(s.getOutputStream())
                );
                BufferedReader br = new BufferedReader(
                     new InputStreamReader(s.getInputStream())
                )
        ) {
            bw.write("GET / HTTP/1.1\r\nHost: www.mysite.at\r\n\r\n");
            bw.flush();

            String line;
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
