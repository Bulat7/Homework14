package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private Product[] basket = new Product[5];
    private int count = 0;

    public void addProduct(Product newProduct) {
        if (count < basket.length) {
            basket[count] = newProduct;
            count++;
            System.out.println("Добавлен продукт - " + newProduct.getName() + " цена - " + newProduct.getPrice());
        } else {
            System.out.println("Невозможно добавить продукт");
        }
    }

    public int totalPrice() {
        int totalPrice = 0;
        for (Product prd : basket) {
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
        for (int i = 0; i < basket.length; i++) {
            var product = basket[i];
            if (product != null) {
                System.out.println(product);
            }
        }
        System.out.println("Итого:" + totalPrice());
        System.out.println("Специальных товаров: " + getSpecialCount());
    }

    public boolean productChek(String productName) {
        for (Product prd : basket) {
            if (prd == null) {
                continue;
            }
            if (prd.getName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void basketCleaner() {
        for (int i = 0; i < basket.length; i++) {
            basket[i] = null;
        }
        this.count = 0;
    }

    public int getSpecialCount() {
        int specialCount = 0;

        for (int i = 0; i < basket.length; i++) {
            var product = basket[i];

            if (product != null && product.isSpecial()) {
                specialCount++;
            }
        }
        return specialCount;

    }

}
