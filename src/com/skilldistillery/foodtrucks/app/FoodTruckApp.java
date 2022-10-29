package com.skilldistillery.foodtrucks.app;

import java.util.Scanner;

import com.skilldistillery.foodtrucks.entities.FoodTruck;

public class FoodTruckApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the food truck app!!");
		String foodType = "";
		int rating = -1;
		int menuChoice = 0;
		int index = 0;
		FoodTruck[] foodTruckList = new FoodTruck[5];
		FoodTruckApp foodTruckAppObject = new FoodTruckApp();

		System.out.println("Please enter food truck name:");
		String input = scanner.nextLine();
		while (!(input.equalsIgnoreCase("quit")) && index <= 4) {

			System.out.println("Enter the food type that " + input + " serves:");
			foodType = scanner.nextLine();

			System.out.println("Please enter the rating for " + input + ":");
			rating = scanner.nextInt();
			scanner.nextLine();
			while (rating < 0 || rating > 5) {
				System.out.println("Oops we rate on a scale of 0-5 please input another rating");
				rating = scanner.nextInt();
				scanner.nextLine();
				
			}

			FoodTruck truck = new FoodTruck(input, foodType, rating);
			foodTruckList[index] = truck;

			index++;
			if (index <= 4 ) {
				System.out.println("Please enter food truck name or quit to see menu:");
				input = scanner.nextLine();
				
			}

		}

		while (menuChoice != 4) {
			if (foodTruckList[0] == null) {
				System.out.println("oops you didn't enter any food trucks Goodbye...");
				break;
			}
			foodTruckAppObject.menu();
			menuChoice = scanner.nextInt();
			
			if (menuChoice == 1) {
				foodTruckAppObject.printList(foodTruckList);
			} else if (menuChoice == 2) {
				foodTruckAppObject.printAverage(foodTruckList);
				
			} else if (menuChoice == 3) {
				foodTruckAppObject.printMax(foodTruckList);
			
			} else if (menuChoice == 4) {
				System.out.println("GoodBye");
				break;
			} else {
				System.out.println("Command not recognized here is the menu again:");
			}
		}

		scanner.close();

	}

	private void printList(FoodTruck[] foodTruckList) {
		
		for (FoodTruck truck : foodTruckList) {
			if (truck != null) {
				System.out.println(truck);
			}
		}
	}

	private void printMax(FoodTruck[] foodTruckList) {
		int index = 0;
		int max = 0;
		String nameMax = "None";
		for (FoodTruck truck : foodTruckList) {
			if (truck == null) {
				continue;
			}
			index++;
			if (truck.getRating() > max) {
				max = truck.getRating();
				nameMax = truck.getName();
			}
		}
		System.out.println("The highest rated food truck is: " + nameMax + " with a rating of: " + max);
		
	}

	private void printAverage(FoodTruck[] foodTruckList) {
		
		int index = 0;
		int ratingSum = 0;
		for (FoodTruck truck : foodTruckList) {
			if (truck != null) {
				ratingSum += truck.getRating();
				index++;
			}else {
				break;
			}
		}
		double average = ratingSum / index; 
		System.out.println("average rating of the food trucks is: " + average);
		
	}

	private void menu() {
		System.out.println("Enter 1 to see list of all food trucks:");
		System.out.println("Enter 2 to see the average rating of all food trucks");
		System.out.println("Enter 3 to see the highest rated food truck");
		System.out.println("Enter 4 to quit program");
		
	}

}
