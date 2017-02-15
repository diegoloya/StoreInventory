package oop.Assignment2;

import java.util.Comparator;

/**
 * @author Diego Loya
 * Implementation of comparator
 */
public class ProductBySku implements Comparator<Product>{
	/**
	 * Implementation of comparator.  Sorts ArrayList according to SKU value
	 * @param two objects of type Product
	 * @return 1, 0, or -1 if obj1 is less than, equal to, or greater than obj2
	 */
	public int compare(Product obj1, Product obj2) {
		int obj1Sku = obj1.getSku();
		int obj2Sku = obj2.getSku();
		if (obj1Sku<obj2Sku) return -1;
		if (obj1Sku==obj2Sku) return 0;
		return 1;
	}
}
