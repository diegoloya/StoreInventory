package oop.Assignment2;

import java.util.Scanner;

@SuppressWarnings("serial")
public class Movie extends Product {
	private int upc;
	private Scanner input;
	
	public Movie(String pt,int s, String t, float p, int q) {
		super(pt, s, t, p, q);
		setUpc();
	}

	
//	public void add(){
//		System.out.println("movie add");	
//	}
	
	@Override
	void print() {
		System.out.printf("%-10s%-10d%-30s$%7.2f%14d", type, sku,title,price,quantity);
		
	}
	
	void printsingle() {
		super.printsingle();
		System.out.print("\nupc=");
		System.out.print(upc);
		
	}
	
	public void setUpc(){
		System.out.println("Enter upc:");	
		input = new Scanner(System.in);
		upc=input.nextInt();
	}
}
