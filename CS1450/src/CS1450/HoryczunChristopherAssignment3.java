package CS1450;

/*
 * Name: Christopher Horyczun
 * Class: CS1450 (M/W)
 * Due Date: September 17, 2025 (MW)
 * Assignment #3
 * Description: To use what we learned about abstract classes, interfaces, and ArrayLists. We will
 * create a table that shows dog breeds to there abilities.
*/


import java.io.*;
import java.util.*;

public class HoryczunChristopherAssignment3 {

	public static void main(String[] args) throws IOException {
		
		//Open File
		File inputFile = new File("Dogs.txt");
        Scanner input = new Scanner(inputFile);
        
        int numDogs = input.nextInt();
        Dog[] dogs = new Dog[numDogs];
        
        //Sort into an array
        for (int i = 0; i < numDogs; i++) {
        	String breed = input.next();
        	String name = input.next();
        	int service = input.nextInt();
        	int herd = input.nextInt();
        	int hunt = input.nextInt();
        	int protect = input.nextInt();

            // Create specific breed objects based on the breed name
        	if (breed.equalsIgnoreCase("BorderCollie")) {
        		dogs[i] = new BorderCollie(name, service, herd, protect);
        	} else if (breed.equalsIgnoreCase("Boxer")) {
        		dogs[i] = new Boxer(name, service, herd, hunt, protect);
			} else if (breed.equalsIgnoreCase("GermanShepherd")) {
        		dogs[i] = new GermanShepherd(name, service, herd, protect);
       		} else if (breed.equalsIgnoreCase("GoldenRetriever")) {
       			dogs[i] = new GoldenRetriever(name, service, hunt);
            }
        }//end of for loop
        
        input.close();
        
        //Find Protectors
        ArrayList<Dog> protectors = findProtectors(dogs);
        
        System.out.println("DOGS THAT PROTECT");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.printf("%-10s %-12s %-35s %-20s%n", "Dog", "Protection", "Temperament", "Breed");
        System.out.println("--------------------------------------------------------------------------------");
        for (Dog d : protectors) {
        	Protector p = (Protector) d;
        	System.out.printf("%-10s %-12d %-35s %-20s%n",
        			d.getName(), p.protect(), d.temperament(), d.getBreed());
        }//end of for loop
        System.out.println();

        //Best Protector Section
        Dog bestProtector = findBestProtector(protectors);
        Protector bp = (Protector) bestProtector;
        System.out.println("BEST PROTECTING DOG");
        System.out.println("----------------------");
        System.out.println("Name: " + bestProtector.getName());
        System.out.println("Breed: " + bestProtector.getBreed());
        System.out.println("Temperament: " + bestProtector.temperament());
        System.out.println("Protecting Ability: " + bp.protect());
        System.out.println();
        
        //Find most Common
        String commonAbility = findMostCommonAbility(dogs);
        System.out.println("MOST COMMON ABILITY FOR THE DOGS");
        System.out.println("--------------------------------");
        System.out.println(commonAbility + " is the most common ability among the given dogs");
        
	}//Main
	
	public static ArrayList<Dog> findProtectors(Dog[] dogs) {
		ArrayList<Dog> protectors = new ArrayList<>();
		for (Dog d : dogs) {
			if (d instanceof Protector) {
				Protector p = (Protector) d;
				if (p.protect() > 0) {
					protectors.add(d);
                }//end of if-statement
            }//end of if-statement
        }//end of for loop
        return protectors;
    }//end of findProtectors

	public static Dog findBestProtector(ArrayList<Dog> protectors) {
		Dog best = protectors.get(0);
		int max = ((Protector) best).protect();
		for (Dog d : protectors) {
			Protector p = (Protector) d;
			if (p.protect() > max) {
				best = d;
				max = p.protect();
            }//end of if-statement
        }//end of for loop
        return best;
	}//end of findBestProtector
	
	public static String findMostCommonAbility(Dog[] dogs) {
		int serviceCount = 0, herdCount = 0, huntCount = 0, protectCount = 0;
		
		for (Dog d : dogs) {
			if (d instanceof Server && ((Server) d).serve() > 0) serviceCount++;
			if (d instanceof Herder && ((Herder) d).herd() > 0) herdCount++;
			if (d instanceof Hunter && ((Hunter) d).hunt() > 0) huntCount++;
			if (d instanceof Protector && ((Protector) d).protect() > 0) protectCount++;
        }//end of for loop
		
		int max = Math.max(Math.max(serviceCount, herdCount),
				Math.max(huntCount, protectCount));
		
		if (max == serviceCount) return "Service";
		if (max == herdCount) return "Herd";
		if (max == huntCount) return "Hunt";
		
		return "Protect";
    }//end of findMostCommonAbility
	
}//Assignment #3

interface Server {
	//Must return ability from 0-10
    int serve();
}//server

interface Herder {
	//Must return ability from 0-10
	int herd();
}//herder

interface Hunter {
	//Must return ability from 0-10
	int hunt();
}//hunter

interface Protector {
	//Must return ability from 0-10
	int protect();
}//protector

abstract class Dog {
	
	//private Data Type
	private String name;
	private String breed;
	
	//Getter and Setters
	public String getName() {
		return name;
	}
	
	public String getBreed() {
		return breed;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setBreed(String breed) {
		this.breed = breed;
	}
	
	//Abstract method
	public abstract String temperament();
}//Dog Class

//SubClasses
class BorderCollie extends Dog implements Server, Herder, Protector {
	
	//Private data Types
	private int serviceAbility;
	private int herdAbility;
	private int protectAbility;
	
	//Constructor
	public BorderCollie (String name, int serviceAbility, int herdAbility, int protectAbility) {
		setName(name);
		setBreed("Border Collie");
		this.serviceAbility = serviceAbility;
		this.herdAbility = herdAbility;
		this.protectAbility = protectAbility;
	}//public BorderCollie
	
	@Override
	public int serve() {
		return serviceAbility;
	}//serve
	
	@Override
	public int herd() {
		return herdAbility;
	}//herd
	
	@Override
	public int protect() {
		return protectAbility;
	}//protect
	
	@Override
	public String temperament() {
		return "Intelligent, tenacious, energetic";
	}//temperament

}//border collie


class Boxer extends Dog implements Server, Herder, Protector, Hunter {
	
	//Private data Types
	private int serviceAbility;
	private int herdAbility;
	private int huntAbility;
	private int protectAbility;
	
	//Constructor
	public Boxer (String name, int serviceAbility, int herdAbility, int protectAbility, int huntAbility) {
		setName(name);
		setBreed("Boxer");
		this.serviceAbility = serviceAbility;
		this.herdAbility = herdAbility;
		this.huntAbility = huntAbility;
		this.protectAbility = protectAbility;
	}//public Boxer
	
	@Override
	public int serve() {
		return serviceAbility;
	}//serve
	
	@Override
	public int herd() {
		return herdAbility;
	}//herd
	
	@Override
	public int hunt() {
		return huntAbility;
	}//hunt
	
	@Override
	public int protect() {
		return protectAbility;
	}//protect
	
	@Override
	public String temperament() {
		return "Fearless, confident, brave";
	}//temperament

}//boxer

class GermanShepherd extends Dog implements Server, Herder, Protector {
	
	//Private data Types
	private int serviceAbility;
	private int herdAbility;
	private int protectAbility;
	
	//Constructor
	public GermanShepherd (String name, int serviceAbility, int herdAbility, int protectAbility) {
		setName(name);
		setBreed("German Shepherd");
		this.serviceAbility = serviceAbility;
		this.herdAbility = herdAbility;
		this.protectAbility = protectAbility;
	}//public GermanShepherd
	
	@Override
	public int serve() {
		return serviceAbility;
	}//serve
	
	@Override
	public int herd() {
		return herdAbility;
	}//herd
	
	@Override
	public int protect() {
		return protectAbility;
	}//protect
	
	@Override
	public String temperament() {
		return "Confident, watchful, courageous";
	}//temperament

}//German Shepherd

class GoldenRetriever extends Dog implements Server, Hunter {
	
	//Private data Types
	private int serviceAbility;
	private int huntAbility;
	
	//Constructor
	public GoldenRetriever (String name, int serviceAbility, int huntAbility) {
		setName(name);
		setBreed("Golden Retriever");
		this.serviceAbility = serviceAbility;
		this.huntAbility = huntAbility;
	}//public BorderCollie
	
	@Override
	public int serve() {
		return serviceAbility;
	}//serve
	
	@Override
	public int hunt() {
		return huntAbility;
	}//hunt
	
	@Override
	public String temperament() {
		return "Confident, watchful, courageous";
	}//temperament

}//Golden Retriever