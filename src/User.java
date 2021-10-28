
public class User {
	
	private String userName;
	private int age;
	private double currentWeight;
	private double goalWeight;
	
	public String getUserName() {
		return userName;
	}
	
	public int getAge() {
		return age;
	}
	
	public double getCurrentWeight() {
		return currentWeight;
	}
	
	public double getGoalWeight() {
		return goalWeight;
	}
	
	public void setUserName(String newName) {
		userName = newName;
	}
	
	public void setAge(int newAge) {
		age = newAge;
	}
	
	public void setCurrentWeight(double newCurWeight) {
		currentWeight = newCurWeight;
	}
	
	public void setGoalWeight(double newGoalWeight) {
		goalWeight = newGoalWeight;
	}
	
	public void printUser() {
		System.out.println("Name: " + userName);
		System.out.println("Age: " + age);
		System.out.println("Current Weight: " + currentWeight);
		System.out.println("Weight Goal: " + goalWeight);
	}
	
	public User() {
	
	}
	
	public User(String newName, int newAge, double newCurWeight, double newGoalWeight) {
		userName = newName;
		age = newAge;
		currentWeight = newCurWeight;
		goalWeight = newGoalWeight;
	}
		
}
