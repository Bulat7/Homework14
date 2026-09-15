package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {

    private Map<String,LinkedList<Product>> basket = new HashMap<>();

    public void addProduct(Product product) {
        if (product != null ) {
            basket.computeIfAbsent(product.getName(), k -> new LinkedList<>()).add(product);
            System.out.println("Добавлен продукт - " + product.getName() + " цена - " + product.getPrice());
        }
    }

    public int totalPrice() {
        int totalPrice = 0;
        for (List<Product> prdList : basket.values()) {
            if (prdList != null) {
                for (Product product : prdList) {
                    if (product != null) {
                        totalPrice += product.getPrice();
                    }
                }
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
        for(List<Product> productList : basket.values()) {
            if (productList != null) {
            for (Product product : productList) {
                if (product != null && product.isSpecial()) {
                    specialCount++;
                }
            }
        }

        }return specialCount;
    }

    public List<Product> removeProduct(String name) {
        List<Product> removedProductList = basket.remove(name);

        if (removedProductList == null) {
            System.out.println("Такого товара не существует!");
            return new LinkedList<>();
        }
        return removedProductList;
    }
}
