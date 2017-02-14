package oop.Assignment2;

import java.util.Scanner;

@SuppressWarnings("serial")
public class Book extends Product{
	private int isbn;
	private String author;
	private Scanner input;
	
	public Book(String pt,int s, String t, float p, int q) {
		super(pt, s, t, p, q);
		setIsbnAuthor();
	}

	@Override
	void print() {
		System.out.printf("%-10s%-10d%-30s$%7.2f%14d", type, sku,title,price,quantity);
		
	}
	
	double getCommission(){
		double commission=(price*.15);
		return commission;
	}
	
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
		input = new Scanner(System.in);
		isbn=input.nextInt();
		System.out.println("Enter Author:");	
		input = new Scanner(System.in);
		author=input.nextLine();
	}
}
