package live.coding;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class MyUrlDemo {

    public static void main(String[] args) {

        try {
            URL site = new URL("https://en.wikipedia.org/wiki/Kirsty_Pealling");

            try(
                    BufferedReader br =
                        new BufferedReader(
                            new InputStreamReader(site.openStream()));

                    PrintWriter pw = new PrintWriter
                        (new FileWriter("data/lv/Kirsty_Pealling.html"));
            ) {

                String htmlLine;

                while((htmlLine = br.readLine())!=null) {
                    System.out.println(htmlLine);
                    pw.println(htmlLine);
                }

                pw.flush();

            }  catch (IOException e) {
                e.printStackTrace();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }


}
