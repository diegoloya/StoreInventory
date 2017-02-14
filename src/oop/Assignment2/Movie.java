package oop.Assignment2;

import java.io.Serializable;

public class Movie extends Product implements Serializable{
	private int upc;
	
	public Movie(String pt,int s, String t, float p, int q) {
		super(pt, s, t, p, q);
		setUpc();
	}

	
	@Override
	void print() {
		type="Movie";
		System.out.printf("%-10s%-10d%-30s$%7.2f%14d", type, sku,title,price,quantity);
		
	}
	
	double getCommission(){
		double commission=(price*.12);
		return commission;
	}
	
	double getShipping(){
		double shipping=2.98;
		return shipping;
	}
	
	void printsingle() {
		super.printsingle();
		System.out.print("\nupc=");
		System.out.print(upc);
		
	}
	
	double getPrice(){
		return price;
	}
	
	public void setUpc(){
		System.out.println("Enter upc:");	
		upc=Driver.sc.nextInt();
	}
}
