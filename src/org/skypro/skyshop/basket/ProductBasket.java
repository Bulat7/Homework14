package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.stream.Collectors;

public class ProductBasket {

    private Map<String,LinkedList<Product>> basket = new HashMap<>();

    public void addProduct(Product product) {
        if (product != null ) {
            basket.computeIfAbsent(product.getName(), k -> new LinkedList<>()).add(product);
            System.out.println("Добавлен продукт - " + product.getName() + " цена - " + product.getPrice());
        }
    }

    public List<Product> getAllProduct() {
        return basket.values().stream().flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public int totalPrice() {
        return getAllProduct().stream()
                .filter(Objects::nonNull)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public void printBasket() {
        if (this.basket == null || totalPrice() == 0) {
            System.out.println("В корзине пусто");
            return;
        }
        getAllProduct().stream()
                .filter(Objects::nonNull)
                .forEach(System.out::println);
        System.out.println("Итого:" + totalPrice());
        System.out.println("Специальных товаров: " + getSpecialCount());
    }

    public boolean productChek(String productName) {
        return basket.containsKey(productName);
    }


    public int getSpecialCount() {

        return (int) getAllProduct().stream()
                .filter(Objects::nonNull)
                .filter(Product::isSpecial)
                .count();
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
