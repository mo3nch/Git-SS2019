package sorting.ue.carts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CartDemo {
    public static void main(String[] args) {
        // The main list for all sorting demos
        ArrayList<Cart> cartsMaster = new ArrayList<>();
        cartsMaster.add(new Cart("User1", 21, 20, 501.00));
        cartsMaster.add(new Cart("User5", 1, 1, 10.00));
        cartsMaster.add(new Cart("User3", 3, 4, 100.00));
        cartsMaster.add(new Cart("User2", 2, 2, 70.00));


        // Copy of the masterList for standard Sort of Cart class
        ArrayList<Cart> cartsClass = new ArrayList<>(cartsMaster);
        Collections.sort(cartsClass);
        System.out.println("cartsClass = \n" + cartsClass);


        // Copy of the master List for UserNameComparator
        ArrayList<Cart> cartsUsername = new ArrayList<>(cartsMaster);
        Collections.sort(cartsUsername, new CartUsernameComparator());
        System.out.println("cartsUsername = \n" + cartsUsername);


        // Copy of the master List for CartTotalItemsComparator
        ArrayList<Cart> cartsTotalItems = new ArrayList<>(cartsMaster);
        Collections.sort(cartsTotalItems, new CartTotalItemsComparator());
        System.out.println("cartsTotalItems = \n" + cartsTotalItems);


        // Copy of the master List for the anonymous comparator
        // But seriously, never do this in reallife. People will hate you!
        ArrayList<Cart> cartsAnonymous = new ArrayList<>(cartsMaster);
        Collections.sort(cartsAnonymous, new Comparator<Cart>() {
            @Override
            public int compare(Cart cart, Cart t1) {
                double meanCart = cart.getTotalAmount() / cart.getTotalItems();
                double meanT1 = t1.getTotalAmount() / t1.getTotalItems();

                if (meanCart < meanT1)
                    return -1;
                else if (meanCart > meanT1)
                    return 1;
                return 0;
            }
        });
        System.out.println("cartsAnonymous = \n" + cartsAnonymous);

    }
}
