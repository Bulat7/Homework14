package org.skypro.skyshop.product;

public abstract class Product implements Searchable {
    private final String name;

    public Product(String name) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("Введено некорректное имя.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String searchTerm() {
        return this.name;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

}
