package oop.Assignment2;
import java.util.*;

/**
 * @author Diego Loya
 * Creates and interacts with a collection of products in inventory 
 */
public class Inventory {
	
	private int s;	//numeric value of a movie's unique code
	ArrayList<Product> list = new ArrayList<Product>();
	private Product temp;
	
	/**
	 * Default constructor, creates an empty inventory
	 */
	public Inventory() {
	}
	
	
	/**
	 * Creates an instance of requested product using user input and adds to arrayList
	 */
	void addProduct(){
		
		String t;	//Holds user input for title of movie
		float p;	//Holds user input for price of movie
		int q;		//Holds user input for quantity of movie
		String pt;
		
		
		System.out.println("Enter product type:");	
		System.out.println("m=movie, b=book, t=toy");	
		Driver.sc.nextLine();	
		pt=Driver.sc.nextLine();
		
		switch(pt) {
        case "m" :
        case "M" :
        case "t" :
        case "T" :
        case "b" :
        case "B" :
			System.out.println("Enter the SKU (numbers only!):");			
			if(Driver.sc.hasNextInt()){
				s=Driver.sc.nextInt();
				
																
				for (int i = 0; i < list.size(); i++){		
					Product temp = list.get(i);
					
					if (s==temp.getSku()){
						System.out.print("\n***SKU must be unique***\n");
						return;
					}
				}
			}
			else{
				System.out.print("\n***SKU needs to be numbers only***\n");
				return;
			}
			
			System.out.println("Enter the movie title:");
			Driver.sc.nextLine();
			t=Driver.sc.nextLine();
			
			System.out.println("Enter the price:");
			if(Driver.sc.hasNextFloat()){
				p=Driver.sc.nextFloat();
				if (p<=0){
					System.out.print("\n***Price needs to be greater than $0.00***\n");
					return;
				}
				
			}
			else{
				System.out.print("\n***Price needs to be numbers & decimals only***\n");
				return;
			}
			
			System.out.println("Enter the quantity:");
			if(Driver.sc.hasNextInt()){
				q=Driver.sc.nextInt();
				if (q<0){
					System.out.print("\n***Quantity has to be greater or equal to 0***\n");
					return;
				}
					
			}
			else{
				System.out.print("\n***Quantity needs to be numbers only***\n");
				return;
			}
			
			switch(pt) {
	        case "m" :
	        case "M" :
				Product newMovie = new Movie(s, t, p, q);
				list.add(newMovie);
	           break;
	        case "t" :
	        case "T" :
				Product newToy = new Toy(s,t,p,q);
				list.add(newToy);
				break;
	        case "b" :
	        case "B" :
				Product newBook = new Book(s,t,p,q);
				list.add(newBook);
	           break;
			}
			System.out.print("\n***Product has been added***\n");
	           break;
        default :
           System.out.println("*** Product type can only be m, b, or t.");
           break;
		}
	}


				
	/**
	 * Takes input from user to search in inventory, if found it removes from inventory.
	 */
	void removeProduct(){
		System.out.println("Enter the SKU of the product to be removed:");
		if(Driver.sc.hasNextInt()){
			s=Driver.sc.nextInt();
		}
		else{
			System.out.print("\n***SKU needs to be numbers only***\n");
			return;
		}
		int flag=0;
		for (int i = 0; i < list.size(); i++){
			Product temp = list.get(i);
			
			if (s==temp.getSku()){
				flag=1;
				list.remove(temp);
				System.out.print("\n***Product has been removed***\n");
			}
		}
		if (flag==0)
			System.out.print("\n***Product is not in inventory***\n");

	}

	/**
	 * Displays the inventory sorted by SKU value
	 */
	void displayBySku(){

		if (list.size()==0){
			System.out.print("\n***Inventory is empty***\n");
			return;
		}
		
		System.out.format("\n%-10s%-10s%-30s%7s%16s","Type","SKU","Title","Price","Quantity");
		System.out.println("\n---------------------------------------------------------------------------");
		
		Comparator<Product> comp = new ProductBySku();
	    Collections.sort(list, comp);
		
		for (int i = 0; i < list.size(); i++){
			Product temp = list.get(i);
			temp.print();
			System.out.println();
			
		}
	}
	/**
	 * Displays the inventory sorted by title
	 */
	void displayByTitle(){

		if (list.size()==0){
			System.out.print("\n***Inventory is empty***\n");
			return;
		}
		
		System.out.format("\n%-10s%-10s%-30s%7s%16s","Type","SKU","Title","Price","Quantity");
		System.out.println("\n---------------------------------------------------------------------------");
		
		Comparator<Product> comp = new ProductByTitle();
	    Collections.sort(list, comp);
		
		for (int i = 0; i < list.size(); i++){
			Product temp = list.get(i);
			temp.print();
			System.out.println();	
		}
	}
	/**
	 * Takes user input, searches for the product, and displays info if found
	 */
	void displayProduct(){
		
		System.out.println("Enter the SKU to view information:");
		if(Driver.sc.hasNextInt()){
			s=Driver.sc.nextInt();
		}
		else{
			System.out.print("\n***SKU needs to be numbers only***\n");
			return;
		}
		int flag=0;
		for (int i = 0; i < list.size(); i++){
			Product temp = list.get(i);
			if (temp.getSku()==s){
				
				flag=1;
				temp.printsingle();
				System.out.println();
			}
		}
		if (flag==0)
			System.out.print("\n***Product is not in inventory***\n");	
	}

	void process(){
		int tempSku;
		int tempQuantity = 0;
		float tempCost = 0;
		temp=null;
		
		System.out.println("Enter the SKU of sold items:");	
		
		if(Driver.sc.hasNextInt()){
			tempSku=Driver.sc.nextInt();
		}
		else{
			System.out.print("\n***SKU needs to be numbers only***\n");
			return;
		}
				
		int flag=0;
		
		for (int i = 0; i < list.size(); i++){
			temp = list.get(i);
			
			if (tempSku==temp.getSku()){
				flag=1;
				System.out.println("Enter the quantity of sold items");
				if(Driver.sc.hasNextInt()){
					tempQuantity=Driver.sc.nextInt();
					if (temp.reduceQuant(tempQuantity)){
						System.out.println("Enter the cost to ship sold items:");	
						if(Driver.sc.hasNextFloat()){
							tempCost=Driver.sc.nextFloat();
							if (tempCost<=0){
								System.out.print("\n***Price needs to be greater than $0.00***\n");
								temp.resetQuant(tempQuantity);
								return;
							}
						}
						else{
							System.out.print("\n***Price needs to be numbers & decimals only***\n");
							temp.resetQuant(tempQuantity);
							return;
						}
					}
					else
						return;
				}				

				System.out.print("\nTotal Price: ");
				System.out.printf("%s%.2f","$",temp.totalPrice(tempQuantity));
				System.out.print("\nTotal shipping Credit: ");
				System.out.printf("%s%.2f","$", temp.totalShippingCredit(tempQuantity));
				System.out.print("\nTotal Commission: ");
				System.out.printf("%s%.2f","$",temp.totalCommission(tempQuantity));
				System.out.print("\nProfit: ");
				System.out.printf("%s%.2f","$",temp.profit(tempCost, tempQuantity));
				System.out.print("\n");	
			}
		}
		if (flag==0){
			System.out.print("\n***Movie is not in Inventory***\n");
			return;
		}
		
	}
	
}

