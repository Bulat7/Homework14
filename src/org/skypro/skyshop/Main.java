package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

import java.util.Arrays;

class App{
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        Product simpleApple = new SimpleProduct("GreenApple", 100);
        Product discontedRise = new DiscountedProduct("Rise", 50,25);
        Product fixedPaper = new FixPriceProduct("Paper");
        Product discountedBread = new DiscountedProduct("WhiteBread", 80,40);

        basket.addProduct(simpleApple);
        basket.addProduct(discontedRise);
        basket.addProduct(fixedPaper);
        basket.addProduct(discountedBread);

        // Проверка работы поискового движка

        SearchEngine engine = new SearchEngine(5);

        engine.add(simpleApple);
        engine.add(discontedRise);
        engine.add(fixedPaper);
        engine.add(discountedBread);

        Searchable[] results = engine.search("Bread");
        for (int i = 0; i < 5; i++) {
            if( results[i] != null) {
                System.out.println(results[i].getStringRepresentation());
            }
        }

        Article article = new Article("Обзор нового гаджета", "Текст");
        Article article1 = new Article("Статья из газеты Вечерние зори", "Текст");
        Article article2 = new Article("Анекдоты", "Текст");
        Article article3 = new Article("Записки поэта", "Текст");
        Article article4 = new Article("Гороскоп", "Текст");
        Article article5 = new Article("Объявления", "Текст");

        engine.add(article);
        engine.add(article1);
        engine.add(article2);
        engine.add(article3);
        engine.add(article4);
        engine.add(article5);

        engine.printAll();
        engine.clearEngine();

        engine.add(article);
        engine.add(article1);
        engine.add(article2);
        engine.add(article3);
        engine.add(article4);
        engine.add(article5);

        engine.printAll();

        engine.search("зори");
        engine.search("поэт");

















    }
}