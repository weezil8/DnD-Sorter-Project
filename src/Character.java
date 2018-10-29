import java.util.Comparator;
//Class for the Characters to store the Skills name and class in to be compared
public class Character implements Comparable<Character> {
	// All the details about the character 
	public String classTypeName;
	public int Strength;
	public int Dexterity;
	public int Constitution;
	public int Intelligence;
	public int Wisdom;
	public int Charisma;
	private int tempCompare;
	//Base constructor
	Character() {
		classTypeName = "";
		Strength = Dexterity = Constitution = Intelligence = Wisdom = Charisma = 0;
	}
	//Constructor for all the skills, Name, and Class, used to add Characters to the array list in the main
	Character(String ClassType, int Strength, int Dexterity, int Constitution, int Intelligence, int Wisdom, int Charisma) {
		this.classTypeName = ClassType;
		this.Strength= Strength;
		this.Dexterity= Dexterity;
		this.Constitution = Constitution;
		this.Intelligence = Intelligence;
		this.Wisdom = Wisdom;
		this.Charisma = Charisma;
	}
	//sets the comparing variable
	public void setTempCompare(int tempCompare) {
		this.tempCompare = tempCompare;
	}
	//Takes a Character import to compare to the other Characters
	public int compareTo(Character Character) {
		if (this.tempCompare < Character.tempCompare) return -1;
		if (this.tempCompare == Character.tempCompare) return 0;
		if (this.tempCompare > Character.tempCompare) return 1;
		return 0;
	}
	//Prints the characters Class name and skill to sort By
	public String toString() {
		return classTypeName;
//		return classTypeName + " - Skills:\nSTR: "+Strength+"\nDEX: "+Dexterity+"\nCON: "+Constitution+"\nINT: "+Intelligence+"\nWIS: "+Wisdom+"\nCHAR: "+Charisma+"\n" ;
	}
}
//Character Comparer of two characters based on the skill
class CharacterCompare implements Comparator<Character> {
	public int compare(Character Char1, Character Char2) {
		return Char1.compareTo(Char2);
	}
}