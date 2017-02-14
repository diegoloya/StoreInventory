package oop.Assignment2;
import java.util.*;

/**
 * @author Diego Loya
 * Creates and interacts with a collection of movies in inventory 
 */
public class Inventory  {
	
	public int s;	//numeric value of a movie's unique code
	public Scanner input;	//will hold value from user input
	public ArrayList<Product> list = new ArrayList<Product>();
	public Product temp;
	
	/**
	 * Creates an instance of Movie using user input and adds to arrayList
	 */
	void addMovie(){
		
		String t;	//Holds user input for title of movie
		float p;	//Holds user input for price of movie
		int q;		//Holds user input for quantity of movie
		String pt;
		
		
		System.out.println("Enter product type:");	
		input = new Scanner(System.in);
		pt=input.nextLine();
		
		System.out.println("Enter the SKU (numbers only!):");			
		if(input.hasNextInt()){
			s=input.nextInt();
			
															
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
		input = new Scanner(System.in);
		t=input.nextLine();
		
		System.out.println("Enter the price:");
		if(input.hasNextFloat()){
			p=input.nextFloat();
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
		if(input.hasNextInt()){
			q=input.nextInt();
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
			Product newMovie = new Movie(pt,s, t, p, q);
			list.add(newMovie);
           break;
        case "t" :
			Product newToy = new Toy(pt,s,t,p,q);
			list.add(newToy);
			break;
        case "b" :
			Product newBook = new Book(pt,s,t,p,q);
			list.add(newBook);
           break;
       
        default :
           System.out.println("**has to be m b t");
     }
		System.out.print("\n***Product has been added***\n");
	}

				
	/**
	 * Takes input from user to search in inventory, if found it removes from inventory.
	 */
	void removeMovie(){
		System.out.println("Enter the SKU of the movie to be removed:");
		input = new Scanner(System.in);
		if(input.hasNextInt()){
			s=input.nextInt();
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
				System.out.print("\n***Movie has been removed***\n");
			}
		}
		if (flag==0)
			System.out.print("\n***Movie is not in Inventory***\n");

	}

	/**
	 * Displays the contents of arrayList by using print() method from Movie class
	 */
	void displayBySku(){

		if (list.size()==0){
			System.out.print("\n***Movie is empty***\n");
			return;
		}
		
		System.out.format("\n%-10s%-10s%-30s%7s%16s","Type","SKU","Title","Price","Quantity");
		System.out.println("\n----------------------------------------------------------------------");
		
		Comparator<Product> comp = new ProductBySku();
	    Collections.sort(list, comp);
		
		for (int i = 0; i < list.size(); i++){
			Product temp = list.get(i);
			temp.print();
			System.out.println();
			
		}
	}
	
	void displayByTitle(){

		if (list.size()==0){
			System.out.print("\n***Movie is empty***\n");
			return;
		}
		
		System.out.format("\n%-10s%-10s%-30s%7s%16s","Type","SKU","Title","Price","Quantity");
		System.out.println("\n-----------------------------------------------------------------------");
		
		Comparator<Product> comp = new ProductByTitle();
	    Collections.sort(list, comp);
		
		for (int i = 0; i < list.size(); i++){
			Product temp = list.get(i);
			temp.print();
			System.out.println();	
		}
	}
	/**
	 * Takes user input, searches for the movie, and displays info if found
	 */
	void displayMovie(){
		
		System.out.println("Enter the SKU to view information:");
		input = new Scanner(System.in);
		if(input.hasNextInt()){
			s=input.nextInt();
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
			System.out.print("\n***Movie is not in Inventory***\n");	
	}

	void process(){
		int tempSku;
		int tempQuantity = 0;
		float tempCost = 0;
		temp=null;
		
		System.out.println("Enter the SKU of sold items:");	
		input = new Scanner(System.in);
		tempSku=input.nextInt();
		
		System.out.println("Enter quantity sold ");	
		input = new Scanner(System.in);
		tempQuantity=input.nextInt();
		
		System.out.println("Enter the cost of shipping");	
		input = new Scanner(System.in);
		tempCost=input.nextInt();
		
		
		for (int i = 0; i < list.size(); i++){
			temp = list.get(i);
			if (tempSku==temp.getSku()){
				temp.reduceQuant(tempQuantity);
			}
		}
		
		
//		
//		if(input.hasNextInt()){
//			tempSku=input.nextInt();
//		}
//		else{
//			System.out.print("\n***SKU needs to be numbers only***\n");
//			return;
//		}
//				
//		int flag=0;
//		
//		for (int i = 0; i < list.size(); i++){
//			temp = list.get(i);
//			
//			if (tempSku==temp.getSku()){
//				flag=1;
//				System.out.println("Enter the quantity of sold items");
//				if(input.hasNextInt()){
//					tempQuantity=input.nextInt();
//					if (temp.reduceQuant(tempQuantity)){
//						System.out.println("Enter the cost to ship sold items:");	
//						input = new Scanner(System.in);
//						if(input.hasNextFloat()){
//							tempCost=input.nextFloat();
//							if (tempCost<=0){
//								System.out.print("\n***Price needs to be greater than $0.00***\n");
//								temp.resetQuant(tempQuantity);
//								return;
//							}
//						}
//						else{
//							System.out.print("\n***Price needs to be numbers & decimals only***\n");
//							temp.resetQuant(tempQuantity);
//							return;
//						}
//					}
//					else
//						return;
//				}
//			}
//		}
//		if (flag==0){
//			System.out.print("\n***Movie is not in Inventory***\n");
//			return;
//		}
		System.out.print("\nquantity sold");
		System.out.print(tempQuantity);
		System.out.print("\ntemp.getPrice()");
		System.out.printf("%s%.2f","$",temp.getPrice());
		System.out.print("\ntemp.getShipping(): ");
		System.out.printf("%s%.2f","$",temp.getShipping());
		System.out.print("\ntemp.getCommision()");
		System.out.printf("%s%.2f","$",temp.getCommission());
		System.out.print("\n");
		
		double totalPrice = (tempQuantity*temp.getPrice());
		double totalShippingCredit = (tempQuantity*temp.getShipping());
		double totalCommission = (tempQuantity* (temp.getCommission()));
		double profit = (totalPrice+totalShippingCredit-(totalCommission+tempCost));
		
		System.out.print("\nTotal Price: ");
		System.out.printf("%s%.2f","$",totalPrice);
		System.out.print("\nTotal shipping Credit: ");
		System.out.printf("%s%.2f","$",totalShippingCredit);
		System.out.print("\nTotal Commission: ");
		System.out.printf("%s%.2f","$",totalCommission);
		System.out.print("\nProfit: ");
		System.out.printf("%s%.2f","$",profit);
		System.out.print("\n");
		
		
		
		
		
		
		
		
		

		
		
	}
	
}

