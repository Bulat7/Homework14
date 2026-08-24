package org.skypro.skyshop.product;

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
    public String searchTerm() {
        return name + "\n" + article;
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getStringRepresentation() {
        return name + " - " +getContentType();
    }
}
