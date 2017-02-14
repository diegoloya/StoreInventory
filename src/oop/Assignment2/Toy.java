package oop.Assignment2;

import java.io.Serializable;
import java.util.Scanner;

public class Toy extends Product implements Serializable{
	private int weight;
	
	public Toy(String pt, int s, String t, float p, int q) {
		super(pt, s, t, p, q);
		setWeight();
	}
	
	@Override
	void print() {
		type="Toy";
		System.out.printf("%-10s%-10d%-30s$%7.2f%14d", type, sku,title,price,quantity);
		
	}

	
	double totalCommission(double tempQuantity){
		return (tempQuantity*(price*0.15));
	}
	
	double totalShippingCredit(double tempQuantity){
		int roundedWeight=((weight/16)+1);
		double shipping=( 4.49 + (0.5*(roundedWeight)));
		return (tempQuantity*shipping);
	}

	
	void printsingle() {
		super.printsingle();
		System.out.print("\nweight=");
		System.out.print(weight);
		
	}
	public void setWeight(){
		System.out.println("Enter weight:");	
		weight=Driver.sc.nextInt();
	}
}
