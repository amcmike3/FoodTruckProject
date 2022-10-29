package com.skilldistillery.foodtrucks.entities;

public class FoodTruck {

	private static int nextTruckId = 0;
	private int rating;
	private String name;
	private String foodType;
	private int id;
	
	public FoodTruck(String name, String foodType, int rating) {
		this.name = name;
		this.foodType = foodType;
		this.rating = rating;
		this.id = nextTruckId;
		nextTruckId++;
	}
	public String toString() {
		String answer = (this.id + ": " + this.name +
				" serves " + this.foodType + " and has a rating of: " +
				this.rating);
		return answer;
	}
	public String getName() {
		return name;
	}
	public int getRating() {
		return rating;
	}
}
