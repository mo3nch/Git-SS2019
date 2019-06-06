package stream.ue.textanalyzer;

import java.util.HashMap;

public class TextAnalyzer
{
    private TextAnalyzer(String fileName, ResultManager resultManager)
    {
        resultManager.setPath(fileName);

        try
        {
            resultManager.read();
        }
        catch (TextInputInvalidFormatException e)
        {
            e.printStackTrace();
        }

        for (HashMap.Entry<Character, Integer> e:
        resultManager.getResults().entrySet())
        {

        }
    }
}
