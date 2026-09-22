package org.skypro.skyshop.product;

import java.util.*;

public class SearchEngine {

    private final Set<Searchable> elements = new HashSet<>();

    public SearchEngine() {
    }

    public Set<Searchable> search(String query) {
        Comparator<Searchable> comparator = Comparator
                .comparingInt((Searchable sch) -> sch.getName().length()).reversed()
                .thenComparing((Searchable sch) -> sch.getName());
        Set<Searchable> searchResult = new TreeSet<>(comparator);
        for (Searchable sch : elements) {
            if (sch.searchTerm().toLowerCase().contains((query.toLowerCase()))) {
                searchResult.add(sch);
            }

        }
        return searchResult;
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
