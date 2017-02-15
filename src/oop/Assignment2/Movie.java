package oop.Assignment2;
import java.io.Serializable;

/**
 * @author Diego Loya
 * Holds attributes and methods of a movie
 */
public class Movie extends Product implements Serializable{
	private int upc; //special attribute for movie
	private String type; //type of product
	/**
	 * Constructor for Movie instances
	 * @param pt-product type, s- SKU, t-title, p-price, q-quantity
	 */
	public Movie(int s, String t, float p, int q) {
		super(s, t, p, q);
		type="Movie";
		System.out.println("Enter upc:");	
		upc=Driver.sc.nextInt();
	}

	/**
	 * Prints the type of the product and attributes of that instance 
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
		return (tempQuantity*2.98);
	}
	/**
	 * Calculates total commission
	 * @param tempQuantity=number of items sold
	 * @return total total commission
	 */
	double totalCommission(double tempQuantity){
		return (tempQuantity*(getPrice()*0.12));
	}
	/**
	 * Prints all of the attributes, including special attribute
	 */
	void printsingle() {
		super.printsingle();
		System.out.print("\nupc=");
		System.out.print(upc);
	}

}
