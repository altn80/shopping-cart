/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.shopping.cart.controller;

import com.novaes.shopping.cart.domain.ShoppingCart;
import com.novaes.shopping.cart.domain.ShoppingCartItem;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kbos
 */
@RestController
public class ShoppingCartController {
    
    @Autowired
    ShoppingCart shoppingCart;
    
    
    @PostConstruct
    void init() {
        shoppingCart.addItem(new ShoppingCartItem(5, "Wine", 10.5d));
        shoppingCart.addItem(new ShoppingCartItem(1, "Beer", 2.7d));
        shoppingCart.addItem(new ShoppingCartItem(4, "Rice", 1.5d));
        shoppingCart.addItem(new ShoppingCartItem(2, "Coke", 3.8d));
        shoppingCart.addItem(new ShoppingCartItem(3, "Steak", 13.5d));
    }

    @RequestMapping("/shoppingCart")
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

}
