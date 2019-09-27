/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novaes.shopping.cart.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

/**
 *
 * @author kbos
 */
@Component
public class ShoppingCart {

    private final List<ShoppingCartItem> itens;

    public ShoppingCart() {
        this.itens = new ArrayList<>();
    }

    public void addItem(ShoppingCartItem item) {
        this.itens.add(item);
    }

    public List<ShoppingCartItem> getItens() {
        return itens
                .stream()
                .sorted(Comparator.comparing(ShoppingCartItem::getName).thenComparing(ShoppingCartItem::getPrice))
                .collect(Collectors.toList());
    }

    public Double getTotal() {
        return itens.stream().map(ShoppingCartItem::getPrice).reduce((a, b) -> a + b).orElse(0D);
    }

}
