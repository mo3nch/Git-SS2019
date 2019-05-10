public class Main {

    public static void main(String[] args) {
        FileSplitter fs = new FileSplitter("D:\\test.txt");

        TextAnalyzer ta1 = new TextAnalyzer(fs.getEven());
        TextAnalyzer ta2 = new TextAnalyzer(fs.getOdd());

        Thread t1 = new Thread(ta1);
        Thread t2 = new Thread(ta2);

        t1.start();
        t2.start();

        try
        {
            t1.join();
            t2.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println(ta1);


    }
}
