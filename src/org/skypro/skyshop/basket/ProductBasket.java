package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private List<Product> basket = new LinkedList<>();

    public void addProduct(Product product) {
        if (product!= null ) {
            basket.add(product);
            System.out.println("Добавлен продукт - " + product.getName() + " цена - " + product.getPrice());
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
        for (int i = 0; i < basket.size(); i++) {
            var product = basket.get(i);
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


    public int getSpecialCount() {
        int specialCount = 0;

        for (int i = 0; i < basket.size(); i++) {
            var product = basket.get(i);

            if (product != null && product.isSpecial()) {
                specialCount++;
            }
        }
        return specialCount;

    }

    public List<Product> removeProduct(String name) {
        List<Product> rp = new LinkedList<>();

        Iterator<Product> iterator = basket.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();

            if(product.getName().equals(name)) {
                rp.add(product);
                iterator.remove();
            }
        }
        return rp;


    }

}
