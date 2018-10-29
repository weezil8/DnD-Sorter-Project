/*
 *D&D Sorting program 
 *By: Shane Leinbach
 *10/28/2018 
 * This program takes a list of D&D characters in a file and reads through the file
 * and pulls out the character and their skills and then based on user input it will sort
 * the characters out for the user in ascending order
 */
import java.util.*;
import java.io.*;
public class Sorter {
	public static void main(String[] args) throws FileNotFoundException {
		File charFile = new File("Files\\characters.txt");
		ArrayList<Character> Chars = new ArrayList<Character>();
		Scanner fileScanner = new Scanner(charFile);

		//While the File has a next line the scanner reads it
		while(fileScanner.hasNext())
		{
			//Takes the current line and stores it
			String Temp = fileScanner.nextLine();
			//sets the first line to be the name and class in one string for later use
			String classType = Temp;
			//jumps lines 
			Temp = fileScanner.nextLine();
			//Each one pares out the integer from each line at the colon and then stores 
			//it in a temp variable to be transfered to the list later
			int Strength = Integer.parseInt(Temp.replaceAll(".*:", ""));
			Temp = fileScanner.nextLine();
			int Dexterity = Integer.parseInt(Temp.replaceAll(".*:", ""));
			Temp = fileScanner.nextLine();
			int Constituion = Integer.parseInt(Temp.replaceAll(".*:", ""));
			Temp = fileScanner.nextLine();
			int Intelligence = Integer.parseInt(Temp.replaceAll(".*:", ""));
			Temp = fileScanner.nextLine();
			int Wisdom = Integer.parseInt(Temp.replaceAll(".*:", ""));
			Temp = fileScanner.nextLine();
			int Charisma = Integer.parseInt(Temp.replaceAll(".*:", ""));
			if(fileScanner.hasNextLine())
				fileScanner.nextLine();
			//Adds the scanned Character to the arraylist of characters with their skills 
			Chars.add(new Character(classType, Strength, Dexterity, Constituion, Intelligence, Wisdom, Charisma));
		}
		Scanner scan = new Scanner(System.in);
		//Boolean used to determine if their input is realm and will keep running 
		//until they put in the exit command
		boolean isInput = false;
		while (true) {
			// read user's input
			System.out.print("Enter the parameter you want to compare Characters by: ");
			//Asks for a comparing variable and then selects which to sort by and
			//does it through the massive ugly if statement
			String userInput = scan.nextLine();
			if (userInput.equalsIgnoreCase("Strength")) {
				isInput = true;
				for (Character x: Chars) 
					x.setTempCompare(x.Strength);
			}else if (userInput.equalsIgnoreCase("Dexterity")) {
				isInput = true;
				for (Character x: Chars) 
					x.setTempCompare(x.Dexterity);			
			}else if (userInput.equalsIgnoreCase("Constitution")) {
				isInput = true;
				for (Character x: Chars) 
					x.setTempCompare(x.Constitution);
			}else if (userInput.equalsIgnoreCase("Intelligence")) {
				isInput = true;
				for (Character x: Chars) 
					x.setTempCompare(x.Intelligence);
			}else if (userInput.equalsIgnoreCase("Wisdom")) {
				isInput = true;
				for (Character x: Chars) 
					x.setTempCompare(x.Wisdom);
			}else if (userInput.equalsIgnoreCase("Charisma")) {
				isInput = true;
				for (Character x: Chars) 
					x.setTempCompare(x.Charisma);
			}
			//Exiting case that was needed to end the program
			else if(userInput.equalsIgnoreCase("recursion!")){
				System.out.println("Goodbye Buddi!");
				break;
			}else {
				//Stops users from putting something they aren't suppose to
				System.out.println("That isn't a skill to compare by, try again Chief");
			}
			if(isInput == true) {
			// run the sorting from Java Collections
			Collections.sort(Chars, new CharacterCompare());
			// print the sorted Characters through another big ugly If statement 
			// that contains the correct skill
				if(userInput.equalsIgnoreCase("Strength")) {
					System.out.println("Sorted by Strength");
				for (Character x : Chars) 
					System.out.println(x+" ("+x.Strength+")");
				}if(userInput.equalsIgnoreCase("Dexterity")) {
					System.out.println("Sorted by Dexterity");
				for (Character x : Chars) 
					System.out.println(x+" ("+x.Dexterity+")");
				}if(userInput.equalsIgnoreCase("Constitution")) {
					System.out.println("Sorted by Constitution");
				for (Character x : Chars) 
					System.out.println(x+" ("+x.Constitution+")");
				}if(userInput.equalsIgnoreCase("Intelligence")) {
					System.out.println("Sorted by Intelligence");
				for (Character x : Chars) 
					System.out.println(x+" ("+x.Intelligence+")");
				}if(userInput.equalsIgnoreCase("Wisdom")) {
					System.out.println("Sorted by Wisdom");
				for (Character x : Chars) 
					System.out.println(x+" ("+x.Wisdom+")");
				}if(userInput.equalsIgnoreCase("Charisma")) {
					System.out.println("Sorted by Charisma");
				for (Character x : Chars) 
					System.out.println(x+" ("+x.Charisma+")");
				}
			}
		}
	}
}