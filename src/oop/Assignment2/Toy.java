package oop.Assignment2;

import java.io.Serializable;
import java.util.Scanner;

public class Toy extends Product {
	private int weight;
	private Scanner input;
	
	
	public Toy(String pt, int s, String t, float p, int q) {
		super(pt, s, t, p, q);
		setWeight();
	}

//	public void add(){
//		System.out.println("toy add");	
//	}
	
	
	@Override
	void print() {
		System.out.printf("%-10s%-10d%-30s$%7.2f%14d", type, sku,title,price,quantity);
		
	}
	
	void printsingle() {
		super.printsingle();
		System.out.print("\nweight=");
		System.out.print(weight);
		
	}
	public void setWeight(){
		System.out.println("Enter weight:");	
		input = new Scanner(System.in);
		weight=input.nextInt();
	}
}
