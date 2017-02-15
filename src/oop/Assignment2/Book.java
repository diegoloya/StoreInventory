package oop.Assignment2;

import java.io.Serializable;

/**
 * @author Diego Loya
 * Holds attributes and methods of a book
 */
public class Book extends Product implements Serializable{
	private int isbn;	//special attribute for book
	private String author;	//special attribute for book
	private String type;	//type of product
	/**
	 * Constructor for Book instances
	 * @param pt-product type, s- SKU, t-title, p-price, q-quantity
	 */
	public Book(int s, String t, float p, int q) {
		super(s, t, p, q);
		type="Book";
		System.out.println("Enter Isbn:");	
		isbn=Driver.sc.nextInt();
		Driver.sc.nextLine();
		System.out.println("Enter Author:");	
		author=Driver.sc.nextLine();
	}

	/**
	 * Prints the type of item and the four main attributes
	 */
	@Override
	void print() {
		System.out.printf("%-10s", type);
		super.print();
	}

	/**
	 * Calculates total shipping credit
	 * @param tempQuantity=number of items sold
	 * @return total shipping credit
	 */
	double totalShippingCredit(double tempQuantity){
		return (tempQuantity*3.99);
	}

	/**
	 * Calculates total commission
	 * @param tempQuantity=number of items sold
	 * @return total commission
	 */
	double totalCommission(double tempQuantity){
		return (tempQuantity*(getPrice()*0.15));
	}
	
	/**
	 * Prints all of the attributes, including special attribute
	 */
	void printsingle() {
		super.printsingle();
		System.out.print("\nisbn=");
		System.out.print(isbn);
		System.out.print("\nauthor=");
		System.out.print(author);
	}
	
}
