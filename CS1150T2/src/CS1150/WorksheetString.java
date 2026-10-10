package CS1150;

import java.util.Scanner;

public class WorksheetString {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		// TODO Auto-generated method stub
		System.out.println("Enter Password");
		String password = input.nextLine();
		while (!password.equals("Indian Summer")) {
			System.out.println(password + " is not a valid password, try again. Enter password again: ");
			password = input.nextLine();

		}
		if (password.equals("Indian Summer")) {
		System.out.println("First character in the password is: " + password.charAt(0));
		System.out.println("Last character in the password is: " + password.charAt(password.length() - 1));
		}
	}
}
