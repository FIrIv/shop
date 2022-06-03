package pro.sky.shop.data;

import org.springframework.web.context.annotation.SessionScope;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ShoppingCart {
    private final Set<Integer> shoppingCart;

    public ShoppingCart () {
        shoppingCart = new HashSet<>();
    }

    public Set<Integer> getShoppingCart() {
        return shoppingCart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return Objects.equals(shoppingCart, that.shoppingCart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shoppingCart);
    }

    public void addToShoppingCart (Integer i) {
        shoppingCart.add(i);
    }
}
