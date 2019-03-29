import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CartTest
{
    public static void main(String[] args)
    {
        Cart c1 = new Cart("x", 8, 9, 40.0);
        Cart c2 = new Cart("a", 1, 1, 60.0);
        Cart c3 = new Cart("y", 2, 2, 20.0);
        Cart c4 = new Cart("b", 4, 7, 10.0);
        Cart c5 = new Cart("c", 3, 3, 90.0);

        ArrayList<Cart> carts = new ArrayList<>();
        carts.add(c1);
        carts.add(c2);
        carts.add(c3);
        carts.add(c4);
        carts.add(c5);

        Collections.sort(carts);
        System.out.println("Standard: \n");
        printCarts(carts);

        Collections.sort(carts, new CartTotalItemsComparator());
        System.out.println("Items: \n");
        printCarts(carts);

        Collections.sort(carts, new CartUserNameComparator());
        System.out.println("Name: \n");
        printCarts(carts);

        Collections.sort(carts, new Comparator<Cart>()
        {
            @Override
            public int compare(Cart o1, Cart o2)
            {
                Double d1 = o1.getTotalAmount()/o1.getTotalItems();
                Double d2 = o2.getTotalAmount()/o2.getTotalItems();

                return (d1.compareTo(d2));
            }
        });
        System.out.println("Anonymous: \n");
        printCarts(carts);

    }

    static void printCarts(ArrayList<Cart> carts)
    {
        for (Cart cart : carts) {
            System.out.println(cart);
        }
    }
}
