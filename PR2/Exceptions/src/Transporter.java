public class Transporter
{
    public void beam (String person, String from, String to, boolean urgent)
            throws TransportMalfunctionException
    {
        if (urgent == true && Math.random() < 0.5)
            throw new TransportMalfunctionException();
    }

    public void shutdown()
    {
        System.out.println("Transporter shut down");
    }
}
