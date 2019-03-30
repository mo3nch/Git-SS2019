public class Episode42
{
    public static void main(String[] args)
    {
        Starship ship = new Starship("Enterprise");

        for (int i = 0; i < 50; i++)
        {
            ship.beamUp("Kirk", "Riga IV");
        }
    }
}
