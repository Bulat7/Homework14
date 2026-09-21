package org.skypro.skyshop.product;

import java.util.Objects;

public final class Article implements Searchable {
    private final String name;
    private final String article;

    public Article(String name, String article) {
        this.name = name;
        this.article = article;
    }

    @Override
    public String toString() {
        return name + "\n" + article;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String searchTerm() {
        return name + "\n" + article;
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(!(obj instanceof Article)) return false;
        return Objects.equals(name, ((Article)obj).name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
