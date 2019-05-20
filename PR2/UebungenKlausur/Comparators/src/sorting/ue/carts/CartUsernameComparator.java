package sorting.ue.carts;

import java.util.Comparator;

public class CartUsernameComparator implements Comparator<Cart> {
    @Override
    public int compare(Cart cart, Cart t1) {
        return cart.getUsername().compareTo(t1.getUsername());
    }
}
