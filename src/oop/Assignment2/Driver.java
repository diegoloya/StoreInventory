package oop.Assignment2;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
/**
 * @author Diego Loya
 * Displays menu and takes input from user
 */
public class Driver {
	
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * Displays menu, takes user input, and calls corresponding action
	 */

	public static void main(String[] args) {
	
		int choice;		//holds user input for desired action
		Inventory test = new Inventory();
		
		try {
			FileInputStream fis = new FileInputStream("inventory.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			test.list = (ArrayList<Product>)ois.readObject();
			fis.close();
			} catch (FileNotFoundException fnfe) {
				//first time running program
			} catch (IOException ioe) {
				System.out.println("Error: " + ioe);
				return; //exit main
			} catch (ClassNotFoundException cnfe) {
				System.out.println("Error: " + cnfe);
				return; //exit main
			}
	
		do {
			System.out.println("\nOnline Store Inventory Menu \n");
			System.out.println("1. Add product \n2. Remove product \n3. Find product by SKU \n4. "
					+ "Display inventory sorted by sku \n5. Display inventory sorted by title \n6. Process a sale \n7. Quit the Program \n");
			System.out.println("Enter your choice:");
			choice=sc.nextInt();
			
			switch (choice){
			case 1:
				test.addProduct();
				break;
			case 2:
				test.removeProduct();
				break;
			case 3:
				test.displayProduct();
				break;
			case 4:
				test.displayBySku();
				break;
			case 5:
				test.displayByTitle();
				break;
			case 6:
				test.process();
				break;
			case 7:
				System.out.print("\nProgram terminated..");
				break;
			default:
				System.out.print("\nInvalid Selection");
			}
			
		}while(choice!=7);
		
		   //the following code writes the objects to the file:
	    try {
	    	FileOutputStream fos = new FileOutputStream("inventory.dat");
	    	ObjectOutputStream oos = new ObjectOutputStream(fos);
	    	oos.writeObject(test.list); //ArrayList & contents are serializable
	    	fos.close();
	    } 
	    catch (IOException e) {
	    	System.out.println("Problem with file output");
	    }   
	}
}


