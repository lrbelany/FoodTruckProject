package com.skilldistillery.foodtruck.entities;

	public class FoodTruck {
		
		private static int truckCount = 0;
		private int truckID = 0;
		private String name = null;
		private String foodType = null;
		private double userRating = 0.0;
		
		public FoodTruck() {
			setTruckID();
		}
		
		public FoodTruck(String name, String foodType, double userRating) {
		
			setTruckID();
			this.name = name;
			this.foodType = foodType;
			this.userRating = userRating;
		}
		
		private void setTruckID() {
		
			truckCount++;
			this.truckID = truckCount;
		}

		public int getTruckID() {
			return truckID;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getFoodType() {
			return foodType;
		}

		public void setFoodType(String foodType) {
			this.foodType = foodType;
		}

		public double getUserRating() {
			return userRating;
		}

		public void setUserRating(double userRating) {
			this.userRating = userRating;
		}

		
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("FoodTruck ID: ");
			builder.append(truckID);
			builder.append(", Name: ");
			builder.append(name);
			builder.append(", Food Type: ");
			builder.append(foodType);
			builder.append(", User Rating: ");
			builder.append(userRating);
			return builder.toString();
		}
	}