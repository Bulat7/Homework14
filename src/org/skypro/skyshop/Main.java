package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

class App{
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        basket.addProduct(new Product("Milk", 100));
        basket.addProduct(new Product("Bread", 50));
        basket.addProduct(new Product("Cheese", 300));
        basket.addProduct(new Product("Meat",500));
        basket.addProduct(new Product("Rise", 100));
        basket.addProduct(new Product("Vodka", 300));

        basket.basketCleaner();

        basket.addProduct(new Product("Milk", 100));
        basket.addProduct(new Product("Bread", 50));
        basket.addProduct(new Product("Cheese", 300));
        basket.printBasket();

        System.out.println(basket.totalPrice());

        System.out.println(basket.productChek("Milk"));
        System.out.println(basket.productChek("Apple"));

        basket.basketCleaner();

        basket.printBasket();

        System.out.println(basket.totalPrice());

        System.out.println(basket.productChek("Milk"));

    }
}