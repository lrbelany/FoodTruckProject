package com.skilldistillery.foodtruck.app;
import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.FoodTruck;
public class FoodTruckApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		FoodTruckApp fta = new FoodTruckApp();
		
		fta.run(input, fta);

		
		input.close();
		System.exit(0);

	}

	public void run(Scanner input, FoodTruckApp fta) {
		FoodTruck[] trucks = new FoodTruck[100];
		boolean loop = false;

	
		trucks = fta.enterTruckInfo(input);

		do {
			
			printMenu();

		
			loop = menuSelection(input, trucks);
		} while (loop);

	}

	public FoodTruck[] enterTruckInfo(Scanner input) {
		FoodTruck[] ft;
		String nameQuit = "";
		
		
		ft = new FoodTruck[5];
						
		for(int i = 0; i < ft.length; i++) {
			ft[i] = new FoodTruck();
System.out.println("\nPick Your Top " + (ft.length - i) + " Food Trucks");
System.out.println("Enter Truck Name/QUIT: ");
	System.out.println("Please Enter Truck #" + (i + 1) + "'s Info...");
			nameQuit = input.nextLine();
			
			if(nameQuit.equalsIgnoreCase("Quit")) {
				FoodTruck[] shortenedFTArr = new FoodTruck[i];
		for(int j = 0; j < shortenedFTArr.length; j++) {
					shortenedFTArr[j] = ft[j];
				}
				return shortenedFTArr;
			}
			else {
				  ft[i].setName(nameQuit);
				System.out.print("Enter Food Type: ");
				  ft[i].setFoodType(input.nextLine());
				System.out.print("Enter User Rating: ");
		ft[i].setUserRating(input.nextDouble());
				input.nextLine();
			}
		}
		
		return ft;
		
	}
	
	public void printMenu() {
		System.out.println("\n********Food Truck Menu********");
		System.out.println(" Please Make a Selection (1-4) ");
		System.out.println("1. List existing Food Trucks");
		System.out.println("2. Get Average User Rating for ALL Food Trucks");
		System.out.println("3. Get Highest Rated Food Truck");
		System.out.println("4. Quit the App");
	}
	
	public boolean menuSelection(Scanner input, FoodTruck[] ft) {
		char choice = input.next().charAt(0);
		switch(choice) {
		case '1': 
		
			listTrucks(ft);
			break;
		case '2':
	
			getAvgRating(ft);			
			break;
		case '3':
			
			getHighestRated(ft);
			break;
		case '4':
			System.out.println("Take Care See You Later!!!!");
			return false;
		default:
			System.err.println("\nERROR - Invalid Menu Selection. Try again.\n");
			break;
		}

		
		return true;
	}



	public void listTrucks(FoodTruck[] ft) {

		for(int i = 0; i < ft.length; i++) {
			System.out.println(ft[i].toString());
		}
	}

	public void getAvgRating(FoodTruck[] ft) {
		
		int count = ft.length;
		double sum = 0;
		
		for(int i = 0; i < ft.length; i++) {
			sum += ft[i].getUserRating();
		}
		
		System.out.printf("\nAverage Food Truck Rating: %.2f\n", (double)sum / count);
		
	}

	public void getHighestRated(FoodTruck[] ft) {
		
		double maxRating = 0;
		FoodTruck[] hRFTArray = new FoodTruck[ft.length];
		int count = 0;
		
		
		for(int i = 0; i < ft.length; i++) {
			if(maxRating <= ft[i].getUserRating()) {
				maxRating = ft[i].getUserRating();
			}
		}
		
		
		for(int i = 0; i < ft.length; i++) {
			if(maxRating <= ft[i].getUserRating()) {
				hRFTArray[count] = ft[i];
				count++;
			}
		}


		System.out.println("\nThe Highest Rated Food Truck(s):");
		for(int i = 0; i < hRFTArray.length; i++) {
			if(hRFTArray[i] != null) {
				System.out.println(hRFTArray[i].toString());
			}
		}
	}
}