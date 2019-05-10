package exceptions.ue.transporter;

public class Starship
{
    private String name;
    private Transporter transporter = new Transporter();

    public Starship(String name)
    {
        this.name = name;
    }

    public void beamUp(String person, String from)
    {
        try
        {
            transporter.beam(person, from, name, true);
            System.out.println(person + " sent to " + name);
        }
        catch (TransportMalfunctionException e)
        {
            e.printStackTrace();
        }
        finally
        {
            transporter.shutdown();
        }
    }
}
