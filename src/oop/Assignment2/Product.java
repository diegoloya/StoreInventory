package oop.Assignment2;
import java.io.Serializable;

/**
 * @author Diego Loya
 * Holds all the attributes of a movie
 */
public abstract class Product implements Serializable{

	protected int sku;		//unique numeric code of movie
	protected String title;	//holds a string for title of the movie
	protected float price;	//currency value, $12.34
	protected int quantity;	//numeric value for quantity
	protected String type;
	
	/**
	 * Constructor for Movie instances
	 * @param s- SKU, t-title, p-price, q-quantity
	 */
	Product(String ty,int s, String t, float p, int q){
		this.sku=s;
		this.title=t;
		this.price=p;
		this.quantity=q;
		this.type=ty;
	}
	
	/**
	 * Getter for SKU code
	 * @return the value of SKU of specified instance
	 */
	int getSku(){
		return sku;
	}

	String getTitle(){
		return title;
	}
	//All process functions
	double totalPrice(double tempQuantity){
		return (tempQuantity*price);
	}
	abstract double totalShippingCredit(double tempQuantity);
	abstract double totalCommission(double tempQuantity);
	double profit(double tempCost, double tempQuantity){
		return (totalPrice(tempQuantity)+totalShippingCredit(tempQuantity)-(totalCommission(tempQuantity)+tempCost));
		
	}
	/**
	 * Prints the attribute values of specified instance
	 */
	abstract void print();
	
	void printsingle() {
		System.out.print("\nsku=");
		System.out.print(sku);
		System.out.print("\nquantity=");
		System.out.print(quantity);
		System.out.print("\nprice=");
		System.out.print("$");
		System.out.printf("%.2f",price);
		System.out.print("\ntitle=");
		System.out.print(title);
	}
	
	boolean reduceQuant(int quant){
		if (this.quantity>=quant){
			this.quantity-=quant;
			return true;
		}
		else 
			System.out.print("***Error: Current quantity in stock is insufficient***");
		return false;
	}
	
	void resetQuant(int quant){
		this.quantity+=quant;
	}

}





