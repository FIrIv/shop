package pro.sky.shop.controller;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.shop.exception.BadRequestException;
import pro.sky.shop.service.ShoppingCartService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/store/order")
public class ShoppingController {
    private final ShoppingCartService shoppingCartService;

    public ShoppingController (ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping(path ="/add")
    public Set<Integer> addGoodsToShoppingCart (@RequestParam("id") List <String> goods) {
        List <Integer> items = new ArrayList<>();
        for (int i=0; i<goods.size(); i++) {
            try {
                items.add(Integer.parseInt(goods.get(i)));
            } catch (RuntimeException e) {
                throw new BadRequestException();
            }
        }
        return shoppingCartService.addGoodsToShoppingCart(items);
    }

    @GetMapping(path ="/get")
    public Set<Integer> viewShoppingCart () {
        return shoppingCartService.getGoodsFromShoppingCart();
    }
}
