package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {

    private Map<String,Product> basket = new HashMap<>();

    public void addProduct(Product product) {
        if (product!= null ) {
            basket.put(product.getName(), product);
            System.out.println("Добавлен продукт - " + product.getName() + " цена - " + product.getPrice());
        }
    }

    public int totalPrice() {
        int totalPrice = 0;
        for (Product prd : basket.values()) {
            if (prd != null) {
                totalPrice += prd.getPrice();
            }
        }
        return totalPrice;
    }

    public void printBasket() {
        if (this.basket == null || totalPrice() == 0) {
            System.out.println("В корзине пусто");
            return;
        }
        for (var product : basket.values()) {
            if (product != null) {
                System.out.println(product);
            }
        }
        System.out.println("Итого:" + totalPrice());
        System.out.println("Специальных товаров: " + getSpecialCount());
    }

    public boolean productChek(String productName) {
        return basket.containsKey(productName);
    }


    public int getSpecialCount() {
        int specialCount = 0;

        for(var product : basket.values()) {
            if(product != null && product.isSpecial()) {
                specialCount++;
            }
        }
        return specialCount;
    }

    public List<Product> removeProduct(String name) {
        List<Product> rp = new LinkedList<>();
        Product removedProduct = basket.remove(name);
        if(removedProduct != null) {
            rp.add(removedProduct);
        }
        return rp;
    }

}
