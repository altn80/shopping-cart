/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.shopping.cart;

import com.novaes.shopping.cart.domain.ShoppingCart;
import com.novaes.shopping.cart.domain.ShoppingCartItem;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author kbos
 */
public class ShoppingCartTest {

    @Test
    public void testEmptyShoppingCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Assert.assertEquals(new Double(0d), shoppingCart.getTotal());
    }

    @Test
    public void testShoppingCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(new ShoppingCartItem(1, "Test1", 2.5d));
        shoppingCart.addItem(new ShoppingCartItem(5, "Test5", 5.5d));
        shoppingCart.addItem(new ShoppingCartItem(3, "Test3", 2.0d));
        shoppingCart.addItem(new ShoppingCartItem(2, "Test2", 1.5d));
        shoppingCart.addItem(new ShoppingCartItem(4, "Test4", 3.0d));

        // Verify sorting
        Assert.assertEquals(1, shoppingCart.getItens().get(0).getId());
        Assert.assertEquals(2, shoppingCart.getItens().get(1).getId());
        Assert.assertEquals(3, shoppingCart.getItens().get(2).getId());
        Assert.assertEquals(4, shoppingCart.getItens().get(3).getId());
        Assert.assertEquals(5, shoppingCart.getItens().get(4).getId());
        // Verify total
        Assert.assertEquals(new Double(14.5d), shoppingCart.getTotal());

    }

}
