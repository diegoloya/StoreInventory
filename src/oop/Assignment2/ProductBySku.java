package oop.Assignment2;

import java.util.Comparator;

public class ProductBySku implements Comparator<Product>{
	
	public int compare(Product obj1, Product obj2) {
		int obj1Sku = obj1.getSku();
		int obj2Sku = obj2.getSku();
		if (obj1Sku<obj2Sku) return -1;
		if (obj1Sku==obj2Sku) return 0;
		return 1;
	}
}
