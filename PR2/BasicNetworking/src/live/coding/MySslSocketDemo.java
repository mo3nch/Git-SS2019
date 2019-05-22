package live.coding;

import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.Socket;

public class MySslSocketDemo {

    public static void main(String[] args) {

        try (
            Socket s = SSLSocketFactory.getDefault()
                            .createSocket("www.orf.at",443);

            BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(s.getOutputStream())
            );

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(s.getInputStream())
            )
        ) {

            bw.write("GET / HTTP/1.1\r\nHost: www.orf.at\r\n\r\n");
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
