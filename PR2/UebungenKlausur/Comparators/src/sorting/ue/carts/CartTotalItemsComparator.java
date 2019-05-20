package sorting.ue.carts;

import java.util.Comparator;

public class CartTotalItemsComparator implements Comparator<Cart> {
    @Override
    public int compare(Cart cart, Cart t1) {
        if (cart.getTotalItems() < t1.getTotalItems())
            return -1;
        else if (cart.getTotalItems() > t1.getTotalItems())
            return 1;
        return 0;
    }
}
