package sem1.fproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Calculates the results of the skating competition.
 */
public class Ice {
	
	private static final String PATH = "./data/skaters.txt";
	
	public static void main(String[] a) throws FileNotFoundException {
		//Initializing variables.
		File file = new File(PATH);
		Scanner in = new Scanner(file);
		Skaters[] sk = new Skaters[6];
		
		//Reading data.
		for(int i = 0; i < sk.length; i++) {
			sk[i] = new Skaters(
					in.nextLine(),//first name.
					in.nextLine(),//last name.
					in.nextLine(),//country.
					in.nextLine().split(" "),//technical
					in.nextLine().split(" ")//performance
			);
			System.out.println("read: " + sk[i].toString());
		}
		
		//Sorting array.
		for(int i = 0; i < sk.length; i++) {
			for(int s = 0; s < sk.length; s++) {
				if(sk[i].getAverage() > sk[s].getAverage()) {
					Skaters temp =  sk[s].copy();
					sk[s] = sk[i].copy();
					sk[i] = temp;
				}
			}
		}
		
		//Displaying sorted array.
		System.out.println("Sorted:");
		for(Skaters s : sk) {
			System.out.println(s.toString());
		}
	}
}
