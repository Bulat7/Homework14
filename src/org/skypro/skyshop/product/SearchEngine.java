package org.skypro.skyshop.product;

import java.util.*;

public class SearchEngine {

    private final Map<String, Searchable> elements = new TreeMap<>();
    //private final List<Searchable> elements;

    public SearchEngine() {

    }

    public Map<String,Searchable> search(String query) {
        Map<String,Searchable> searchResult = new TreeMap<>();
        for (Searchable sch : elements.values()) {
            if (sch.searchTerm().contains((query))) {
                searchResult.put(sch.searchTerm(), sch);
                System.out.println("Элемент найден: " + sch.getStringRepresentation());
            }

        }
        return searchResult;
    }

    public void printAll(){
        for(Searchable sch : elements.values()) {
                System.out.println(sch.getStringRepresentation());

        }
    }
    public Searchable findMostSuitable (String search) throws BestResultNotFound {
        if(search == null || search.isEmpty()) {
            throw new BestResultNotFound("BestResultNotFound");
        }

        Searchable searchable = null;
        int count = 0;

        for(Searchable src : elements.values()) {

            String term = src.searchTerm();
            int gap = term.length() - term.replace(search,"").length();
            int currentCount = gap / search.length();
            if(currentCount > count) {
                count = currentCount;
                searchable = src;
            }
        }
        if (searchable == null) {
            throw new BestResultNotFound("BestResultNotFound");
        }
        return searchable;
    }

    public void add(Searchable searchable) {
        if(searchable != null ) {
            elements.put(searchable.searchTerm(), searchable);
        } else {
            System.out.println("Добавьте продукт для сравнения!");
        }
    }
}
