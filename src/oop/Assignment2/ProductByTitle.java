package oop.Assignment2;

import java.util.Comparator;

/**
 * @author Diego Loya
 * Implementation of comparator
 */
public class ProductByTitle implements Comparator<Product>{
	
	/**
	 * Implementation of comparator.  Sorts ArrayList according to title value
	 * @param two objects of type Product
	 * @return 1, 0, or -1 if obj1 is less than, equal to, or greater than obj2
	 */
    public int compare(Product obj1, Product obj2) {
        return obj1.getTitle().compareTo(obj2.getTitle());
    }

}
