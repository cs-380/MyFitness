
import java.util.Scanner;

public class createUser {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please input a screen name:");
			String name = input.nextLine();
		System.out.println("Please input your age:");
			int age = input.nextInt();
		System.out.println("Please input your current weight:");
			double curWeight = input.nextDouble();
		System.out.println("Please input your weight goal:");
			double goalWeight = input.nextDouble();
			
		User person = new User(name, age, curWeight, goalWeight);
		
		System.out.println("Is this you?");
			person.printUser();
	}
}
