package org.skypro.skyshop.product;

public interface Searchable {
    String getName();
    String searchTerm();
    String getContentType();
    default String getStringRepresentation(){
        return searchTerm() + " - " + getContentType();
    }

}
