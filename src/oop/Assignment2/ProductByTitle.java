package oop.Assignment2;

import java.util.Comparator;

public class ProductByTitle implements Comparator<Product>{
    public int compare(Product obj1, Product obj2) {
        return obj1.getTitle().compareTo(obj2.getTitle());
    }

}
