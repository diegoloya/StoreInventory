package oop.Assignment2;
import java.io.Serializable;

/**
 * @author Diego Loya
 * Holds all the attributes of a movie
 */
public class Product implements Serializable {

	
	private int sku;		//unique numeric code of movie
	private String title;	//holds a string for title of the movie
	private float price;	//currency value, $12.34
	private int quantity;	//numeric value for quantity
	
	/**
	 * Constructor for Movie instances
	 * @param s- SKU, t-title, p-price, q-quantity
	 */
	Movie(int s, String t, float p, int q){
		this.sku=s;
		this.title=t;
		this.price=p;
		this.quantity=q;
	}
	/**
	 * Getter for SKU code
	 * @return the value of SKU of specified instance
	 */
	int getSku(){
		return sku;
	}

	/**
	 * Prints the attribute values of specified instance
	 */
	void print(){

		//System.out.format("%-10d%-30s%6.2f%14d",sku,title,price,quantity);
		
		System.out.printf("%-10d%-30s$%7.2f%14d", sku,title,price,quantity);
	}
}



