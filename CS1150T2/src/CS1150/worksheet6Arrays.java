package CS1150;

import java.util.Random;

public class worksheet6Arrays {

	public static void main(String[] args) {
		int[] randomNum = new int[50];
		for (int i = 0; i < 50; i++) {
			randomNum[i]= (int)(Math.random() * 10);
			System.out.println(randomNum[i]);
		}//for loop
	}//Main

}//Worksheet 6
