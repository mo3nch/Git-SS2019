package stream.ue.textanalyzer;

public class ResultManagerDemo
{
    public static void main(String[] args)
    {
        ResultManager rm = new ResultManager("b");

        try
        {
            rm.read();

            rm.setPath("c");
            rm.write();
        }
        catch (TextInputInvalidFormatException e)
        {
            e.printStackTrace();
        }

    }
}
