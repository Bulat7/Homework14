package org.skypro.skyshop.product;

import java.util.LinkedList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> elements;

    public SearchEngine() {
        this.elements = new LinkedList<>();
    }

    public Searchable[] search(String query) {
        Searchable[] searchables = new Searchable[5];
        int count = 0;
        for (Searchable sch : elements) {
            if (sch.searchTerm().contains((query))) {
                searchables[count] = sch;
                System.out.println("Элемент найден: " + sch.getStringRepresentation());
                count++;
                if (count == 5) {
                    return searchables;
                }
            }

        }
        return searchables;
    }

    public void printAll(){
        for(Searchable sch : elements) {
                System.out.println(sch.getStringRepresentation());

        }
    }
    public Searchable findMostSuitable (String search) throws BestResultNotFound {
        if(search == null || search.isEmpty()) {
            throw new BestResultNotFound("BestResultNotFound");
        }

        Searchable searchable = null;
        int count = 0;

        for(Searchable src : elements) {

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
            elements.add(searchable);
        } else {
            System.out.println("Добавьте продукт для сравнения!");
        }
    }
}
