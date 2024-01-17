import java.util.Scanner;
public class AverageValue {
	public static void main(String[] args) {
		// write your solution here
		double sum = 0;
		Scanner scanner = new Scanner (System.in);
		int count = 0;
		double small = 9999;
		double large = 0;

		while (true) {
			System.out.print("Enter an integer (-1 to exit): ");
			double input = scanner.nextDouble();
			double num = input;

			if (input > 0) {
				sum = sum + num;

				if (num > large) {
					large = input;
				}

				if (num < small) {
					small = input;
				}

				count++;
			}

			if (num < 0) {
				break;
			}
		}

		if (count == 0) {
			return;
		} 

		else {
			double MiddleAverage = (sum - small - large)/1;
			System.out.println("The middle average is: " + MiddleAverage);
				
		}
	}
}
