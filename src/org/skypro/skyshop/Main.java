package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

import java.util.Arrays;

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




        SearchEngine searchEngine = new SearchEngine(5);
        searchEngine.add(fixedBread);
        searchEngine.add(simpleApple);
        searchEngine.add(discountedRise);
        searchEngine.add(simpleGreenApple);
        searchEngine.add(simpleRedApple);
        try {
            System.out.println(searchEngine.findMostSuitable(simpleApple.getName()));
        } catch (NullElementException e) {
            System.out.println("Ошибка - " + e.getMessage());
        }
        finally {
            System.out.println("Поиск завершен.");

        }
        try {
            System.out.println(searchEngine.findMostSuitable("chili"));
        } catch (NullElementException e) {
            System.out.println("Ошибка - " + e.getMessage());
        }
        finally {
            System.out.println("Поиск завершен.");


        }


    }
}