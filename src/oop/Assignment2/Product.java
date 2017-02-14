package oop.Assignment2;
import java.io.Serializable;
import java.util.Comparator;

/**
 * @author Diego Loya
 * Holds all the attributes of a movie
 */
@SuppressWarnings("serial")
public abstract class Product implements Serializable{

	
	int sku;		//unique numeric code of movie
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

	//public abstract void add();
	
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
	
	void reduceQuant(int quant){
		this.quantity-=quant;
	}
	
}





