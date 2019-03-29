import java.util.Objects;

public class Cart implements Comparable<Cart>
{
    private String username;
    private int numArticles;
    private int totalItems;
    private double totalAmount;

    public Cart(String username, int numArticles, int totalItems, double totalAmount)
    {
        this.username = username;
        this.numArticles = numArticles;
        this.totalItems = totalItems;
        this.totalAmount = totalAmount;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public int getNumArticles()
    {
        return numArticles;
    }

    public void setNumArticles(int numArticles)
    {
        this.numArticles = numArticles;
    }

    public int getTotalItems()
    {
        return totalItems;
    }

    public void setTotalItems(int totalItems)
    {
        this.totalItems = totalItems;
    }

    public double getTotalAmount()
    {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount)
    {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString()
    {
        return "Cart{" +
                "username='" + username + '\'' +
                ", numArticles=" + numArticles +
                ", totalItems=" + totalItems +
                ", totalAmount=" + totalAmount +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return numArticles == cart.numArticles &&
                totalItems == cart.totalItems &&
                Double.compare(cart.totalAmount, totalAmount) == 0 &&
                Objects.equals(username, cart.username);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(username, numArticles, totalItems, totalAmount);
    }

    @Override
    public int compareTo(Cart o)
    {
        return (((Double)o.totalAmount).compareTo(this.totalAmount));
    }
}
