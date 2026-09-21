package org.skypro.skyshop.product;

import java.util.Objects;

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

    @Override
    public String toString() {
        return  name;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return  true;
        if(!(obj instanceof Product)) return false;
        return Objects.equals(name, ((Product)obj).name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
