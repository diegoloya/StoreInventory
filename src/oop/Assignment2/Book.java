package oop.Assignment2;

import java.io.Serializable;

public class Book extends Product implements Serializable{
	private int isbn;
	private String author;
	
	public Book(String pt,int s, String t, float p, int q) {
		super(pt, s, t, p, q);
		setIsbnAuthor();
	}

	@Override
	void print() {
		type="Book";
		System.out.printf("%-10s%-10d%-30s$%7.2f%14d", type, sku,title,price,quantity);
		
	}
	
	double getCommission(){
		double commission=(price*.15);
		return commission;
	}
	
	double totalShippingCredit(double tempQuantity){
		return (tempQuantity*3.99);
	}
	
	double totalCommission(double tempQuantity){
		return (tempQuantity*(price*0.15));
	}
	
//	double profit(double tempCost, double tempQuantity){
//		return (totalPrice(tempQuantity)+totalShippingCredit(tempQuantity)-(totalCommission(tempQuantity)+tempCost));
//		
//	}
	
	double getShipping(){
		double shipping=3.99;
		return shipping;
	}
	
	void printsingle() {
		super.printsingle();
		System.out.print("\nisbn=");
		System.out.print(isbn);
		System.out.print("\nauthor=");
		System.out.print(author);
	}
	
	double getPrice(){
		return price;
	}
	
	public void setIsbnAuthor(){
		System.out.println("Enter Isbn:");	
		isbn=Driver.sc.nextInt();
		Driver.sc.nextLine();
		System.out.println("Enter Author:");	
		author=Driver.sc.nextLine();
	}
}
