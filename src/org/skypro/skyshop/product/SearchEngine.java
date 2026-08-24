package org.skypro.skyshop.product;

public class SearchEngine {
    private Searchable[] elements;
    private int size = 0;

    public SearchEngine(int capacity) {
        this.elements = new Searchable[capacity];
    }

    public Searchable[] search(String query) {
        Searchable[] searchables = new Searchable[5];
        int count = 0;
        for (int i = 0; i < elements.length; i++) {
            if(elements[i] != null && elements[i].searchTerm().contains(query)) {
                searchables[count] = elements[i];
                System.out.println("Элемент найден: " + elements[i].getStringRepresentation());
                count++;
                if(count == 5) {
                    return searchables;
                }
            }
        }
        return searchables;
    }

    public void add(Searchable item) {
        if( size < this.elements.length) {
            this.elements[size] = item;
            size++;
        }
    }
    public void printAll(){
        for(int i = 0; i < this.elements.length; i++) {
            if(this.elements[i] != null){
                System.out.println(this.elements[i].getStringRepresentation());
            }

        }
    }

    public void clearEngine() {
        for(int i = 0; i < this.elements.length; i++) {
            this.elements[i] = null;
        }
        this.size = 0;
        System.out.println("\n Engine is clear \n");
    }
}
