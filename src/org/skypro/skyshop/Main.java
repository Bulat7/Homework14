package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

import java.util.LinkedList;
import java.util.List;

class App{
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();
        try {
            Product fixedBread = new FixPriceProduct(null);
        } catch (IllegalArgumentException e){
            System.out.println("Ошибка! " + e.getMessage());
        }
        try {
        Product simpleApple = new SimpleProduct("GreenApple", -2);
        } catch (IllegalArgumentException e){
            System.out.println("Ошибка! " + e.getMessage());
        }

        try {
            Product discountedProduct = new DiscountedProduct("Rise", 10,-20 );
        } catch (IllegalArgumentException e){
            System.out.println("Ошибка! " + e.getMessage());
        }

        Product fixedBread = new FixPriceProduct("Bread");
        Product simpleApple = new SimpleProduct("Apple", 20);
        Product discountedRise = new DiscountedProduct("Rise", 100,20 );
        Product simpleGreenApple = new SimpleProduct("GreenApple", 15);
        Product simpleRedApple = new SimpleProduct("RedApple", 25);




        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(fixedBread);
        searchEngine.add(simpleApple);
        searchEngine.add(discountedRise);
        searchEngine.add(simpleGreenApple);
        searchEngine.add(simpleRedApple);
        try {
            System.out.println(searchEngine.findMostSuitable(simpleApple.getName()));
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка - " + e.getMessage());
        }
        finally {
            System.out.println("Поиск завершен.");

        }
        try {
            System.out.println(searchEngine.findMostSuitable("chili"));
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка - " + e.getMessage());
        }
        finally {
            System.out.println("Поиск завершен.");

        }
        searchEngine.add(fixedBread);
        try {
            System.out.println(searchEngine.findMostSuitable("apple"));
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка - " + e.getMessage());
        }
        finally {
            System.out.println("Поиск завершен.");

        }

        ProductBasket productBasket = new ProductBasket();
        productBasket.addProduct(fixedBread);
        productBasket.addProduct(simpleGreenApple);
        productBasket.addProduct(simpleApple);
        productBasket.addProduct(simpleRedApple);
        productBasket.addProduct(discountedRise);

        System.out.println("\n18 lesson:");
        List<Product> deletedProduct = productBasket.removeProduct("Apple");
        System.out.println(deletedProduct);
        System.out.println("------------");
        productBasket.printBasket();
        System.out.println("------------");
        List<Product> deletedProduct1 = productBasket.removeProduct("Vine");
        if (deletedProduct1.isEmpty()){
            System.out.println("Список пуст.");
        }
        System.out.println("------------");
        productBasket.printBasket();




    }
}