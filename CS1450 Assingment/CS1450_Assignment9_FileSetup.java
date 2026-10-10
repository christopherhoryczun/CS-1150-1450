import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CS1450_Assignment9_FileSetupSpring2026 {

	public static void main(String[] args) throws IOException {
		
		final String FILE_NAME = "Railcars.txt";	 

		// Setup the file reference variable to refer to the text file
		File fileName = new File(FILE_NAME);
		
		// Create the file that the elephants will be written to
		PrintWriter railcarsFile = new PrintWriter (fileName);

		Scanner input = new Scanner (System.in);
		System.out.print ("s for student file, g for grader file: ");
		String fileType = input.nextLine();

		// The values being written to the file are: 
		// Railcar number, freight, destination city 	
	
		if (fileType.equalsIgnoreCase("S")) {
			// *** GIVE THIS ONE TO CLASS

			railcarsFile.println("109 military Washington DC");
			railcarsFile.println("521 parrots West Palm Beach");      // Insert as first
			railcarsFile.println("817 military Charleston");		  // Insert in middle	
			railcarsFile.println("500 coal West Palm Beach");		  // Insert after 1st
			railcarsFile.println("214 coal Orlando");
			railcarsFile.println("245 parrots Orlando");
			railcarsFile.println("814 autos Charleston");
			railcarsFile.println("108 autos Washington DC");
			railcarsFile.println("507 autos West Palm Beach");
			railcarsFile.println("562 parrots West Palm Beach");
			railcarsFile.print("117 coal Washington DC");
			
			System.out.println();
			System.out.println("Student Railcars.txt file created in eclipse_workspace directory");
		}
		else {
			// *** USE THIS TO GRADE

			System.out.println();
			System.out.println("Grader Railcars.txt file created in eclipse_workspace directory");
			System.out.println("There are 2 less rail cars in the file");
			System.out.println("Changes the rail car # to make grader at a glance easier");
			System.out.println("To test that students didn't make assumptions on file size");
			
			railcarsFile.println("108 military Washington DC");
			railcarsFile.println("101 parrots West Palm Beach");
			railcarsFile.println("106 military Charleston");
			railcarsFile.println("102 coal West Palm Beach");
			railcarsFile.println("104 coal Orlando");
			railcarsFile.println("105 parrots Orlando");
			railcarsFile.println("107 autos Charleston");
			railcarsFile.println("109 autos Washington DC");
			railcarsFile.print("103 autos West Palm Beach");
			////railcarsFile.println("562 parrots West Palm Beach");  - removed
			////railcarsFile.println("117 coal Washington DC"); - removed
			
		}
		
		input.close();
		railcarsFile.close();
	}

}
