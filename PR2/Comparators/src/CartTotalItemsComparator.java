import java.util.Comparator;

public class CartTotalItemsComparator implements Comparator<Cart>
{
    @Override
    public int compare(Cart o1, Cart o2)
    {
        return ((Integer)o1.getTotalItems()).compareTo(o2.getTotalItems());
    }
}
