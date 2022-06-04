package pro.sky.shop.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import pro.sky.shop.data.DBGoods;
import pro.sky.shop.data.ShoppingCart;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@SessionScope
public class ShoppingCartService {
    private final ShoppingCart shoppingCart;
    private final DBGoods dbGoods;

    public ShoppingCartService (DBGoods dbGoods) {
        shoppingCart = new ShoppingCart();
        this.dbGoods = dbGoods;
    }

    public Set<Integer> addGoodsToShoppingCart(List<Integer> goods) {
        Set<Integer> adding = new HashSet<>();
        for (int i=0; i< goods.size(); i++) {
            if (dbGoods.getGoods().contains(goods.get(i))) {
                shoppingCart.addToShoppingCart(goods.get(i));
                adding.add(goods.get(i));
            }
        }
        return adding;
    }

    public Set<Integer> getGoodsFromShoppingCart() {
        return shoppingCart.getShoppingCart();
    }
}
