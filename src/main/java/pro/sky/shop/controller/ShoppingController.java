package pro.sky.shop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.shop.service.ShoppingCartService;

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
    public Set<Integer> addGoodsToShoppingCart (@RequestParam("id") List <Integer> goods) {
        return shoppingCartService.addGoodsToShoppingCart(goods);
    }

    @GetMapping(path ="/get")
    public Set<Integer> viewShoppingCart () {
        return shoppingCartService.getGoodsFromShoppingCart();
    }
}
