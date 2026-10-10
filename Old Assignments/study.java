import java.util.Scanner;

public class study {
	public static void main (String[]args) {
		Scanner input = new Scanner (system.in);
		System.out.println("how is your day");
		String yourDay = nextLine();
		if (yourDay == 'Good'){
			System.out.println("It good that you are have a\s" + yourDay + "!");
		} else {
			System.out.println("Im sorry to hear that you day has been" + yourDay);
		}
	}
}