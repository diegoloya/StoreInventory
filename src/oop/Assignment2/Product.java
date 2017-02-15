package oop.Assignment2;
import java.io.Serializable;

/**
 * @author Diego Loya
 * Holds all common attributes of a product
 */
public abstract class Product implements Serializable{

	protected int sku;		//unique numeric code of movie
	protected String title;	//holds a string for title of the movie
	protected float price;	//currency value, $12.34
	protected int quantity;	//numeric value for quantity
	protected String type;	//Product type, Book, Movie, Toy
	
	/**
	 * Constructor for Product instances
	 * @param ty-product type, s- SKU, t-title, p-price, q-quantity
	 */
	Product(String ty,int s, String t, float p, int q){
		this.sku=s;
		this.title=t;
		this.price=p;
		this.quantity=q;
		this.type=ty;
	}
	
	/**
	 * *See sub classes for abstract methods*
	 */	
	abstract double totalShippingCredit(double tempQuantity);
	abstract double totalCommission(double tempQuantity);
	abstract void print();
	
	/**
	 * Getter for SKU code
	 * @return the value of SKU of specified instance
	 */
	int getSku(){
		return sku;
	}
	/**
	 * Getter for Title
	 * @return the value of title of specified instance
	 */
	String getTitle(){
		return title;
	}
	/**
	 * Total price = sold Items * item price   
	 * @param  tempQuantity = sold items
	 * @return total price
	 */	
	double totalPrice(double tempQuantity){
		return (tempQuantity*price);
	}
	
	/**
	 * Profit = [ (total price + shipping credit)-(total commission + cost of shipping)]   
	 * @param  tempCost = cost of shipping, tempQuantity = sold items
	 * @return total profit
	 */	
	double profit(double tempCost, double tempQuantity){
		return (totalPrice(tempQuantity)+totalShippingCredit(tempQuantity)-(totalCommission(tempQuantity)+tempCost));
		
	}
	/**
	 * Prints each of the attribute values 
	 */	
	void printsingle() {
		System.out.print("\nsku=" + sku);
		System.out.print("\nquantity=" + quantity);
		System.out.print("\nprice= $");
		System.out.printf("%.2f",price);
		System.out.print("\ntitle=" + title);
	}
	/**
	 * Reduces quantity of item when sale is processed
	 * @param  quant=quantity of sold items
	 * @return true if correct quantity and quantity was reduced, else returns false
	 */	
	boolean reduceQuant(int quant){
		if (this.quantity>=quant){
			this.quantity-=quant;
			return true;
		}
		else 
			System.out.print("***Error: Current quantity in stock is insufficient***");
		return false;
	}
	
	/**
	 * Resets quantity to original value if there was an error processing the sale
	 * @param  quant=quantity to be reset
	 */	
	void resetQuant(int quant){
		this.quantity+=quant;
	}

}





