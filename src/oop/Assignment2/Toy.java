package oop.Assignment2;
import java.io.Serializable;

/**
 * @author Diego Loya
 * Holds attributes and methods of a toy
 */
public class Toy extends Product implements Serializable{
	private int weight; //special attribute for toy
	
	/**
	 * Constructor for Book instances
	 * @param pt-product type, s- SKU, t-title, p-price, q-quantity
	 */
	public Toy(String pt, int s, String t, float p, int q) {
		super(pt, s, t, p, q);
		System.out.println("Enter weight:");	
		weight=Driver.sc.nextInt();
	}
	
	/**
	 * Prints all of the attributes, including special attribute
	 */
	@Override
	void print() {
		type="Toy";
		System.out.printf("%-10s%-10d%-30s$%7.2f%14d", type, sku,title,price,quantity);
		
	}

	/**
	 * Calculates total commission
	 * @param tempQuantity=number of items sold
	 * @return total commission
	 */
	double totalCommission(double tempQuantity){
		return (tempQuantity*(price*0.15));
	}
	
	/**
	 * Calculates total shipping credit
	 * @param tempQuantity=number of items sold
	 * @return total shipping credit
	 */
	double totalShippingCredit(double tempQuantity){
		int roundedWeight=((weight/16)+1);
		double shipping=( 4.49 + (0.5*(roundedWeight)));
		return (tempQuantity*shipping);
	}

	/**
	 * Prints all of the attributes, including special attribute
	 */
	void printsingle() {
		super.printsingle();
		System.out.print("\nweight=");
		System.out.print(weight);
	}

}
