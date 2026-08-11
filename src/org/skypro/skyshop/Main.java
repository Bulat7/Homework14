package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

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

        basket.printBasket();

        basket.basketCleaner();

        basket.printBasket();


    }
}