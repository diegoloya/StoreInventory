package oop.Assignment2;

import java.io.Serializable;
import java.util.Scanner;

public class Book extends Product{
	private int isbn;
	private String author;
	private Scanner input;
	
	public Book(String pt,int s, String t, float p, int q) {
		super(pt, s, t, p, q);
		setIsbn();
	}

	
//	public void add(){
//		System.out.println("book add");	
//	}
	
	@Override
	void print() {
		System.out.printf("%-10s%-10d%-30s$%7.2f%14d", type, sku,title,price,quantity);
		
	}
	
	void printsingle() {
		super.printsingle();
		System.out.print("\nisbn=");
		System.out.print(isbn);
		System.out.print("\nauthor=");
		System.out.print(author);
		
		
	}
	
	public void setIsbn(){
		System.out.println("Enter Isbn:");	
		input = new Scanner(System.in);
		isbn=input.nextInt();
		System.out.println("Enter Author:");	
		input = new Scanner(System.in);
		author=input.nextLine();
		
	}
}
