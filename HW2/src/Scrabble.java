/**
 * Represents a 4 Scrabble tiles and contains methods to make words out of said tiles.
 * 
 * 
 * @author Dan Bajda
 * @version 1.0
 */
public class Scrabble {
	private String l1;
	private String l2;
	private String l3;
	private String l4;
	private static String output = "";
	public boolean error = false;
	/**
	 * Scrabble constructor is used to instantiate a Scrabble object.
	 * @param l1 String parameter representing the first letter.
	 * @param l2 String parameter representing the second letter.
	 * @param l3 String parameter representing the third letter.
	 * @param l4 String parameter representing the fourth letter.
	 */
	public Scrabble(String l1, String l2, String l3, String l4) {
		this.l1 = l1;
		this.l2 = l2;
		this.l3 = l3;
		this.l4 = l4;
	}
	/**
	 * Sets a Scrabble object's first letter.
	 * @param l1 String parameter representing the first letter.
	 */
	public void setL1(String l1) {
		this.l1 = l1;
	}
	/**
	 * Sets a Scrabble object's second letter.
	 * @param l2 String parameter representing the second letter.
	 */
	public void setL2(String l2) {
		this.l2 = l2;
	}
	/**
	 * Sets a Scrabble object's third letter.
	 * @param l3 String parameter representing the third letter.
	 */
	public void setL3(String l3) {
		this.l3 = l3;
	}
	/**
	 * Sets a Scrabble object's fourth letter.
	 * @param l4 String parameter representing the fourth letter.
	 */
	public void setL4(String l4) {
		this.l4 = l4;
	}
	/**
	 * Returns a Scrabble's first letter
	 * @return l1 the local variable representing the first letter
	 */
	public String getL1() {
		return l1;
	}
	/**
	 * Returns a Scrabble's second letter
	 * @return l2 the local variable representing the second letter
	 */
	public String getL2() {
		return l2;
	}
	/**
	 * Returns a Scrabble's third letter
	 * @return l3 the local variable representing the third letter
	 */
	public String getL3() {
		return l3;
	}
	/**
	 * Returns a Scrabble's fourth letter
	 * @return l4 the local variable representing the fourth letter
	 */
	public String getL4() {
		return l4;
	}
	/**
	 * Returns a Scrabble's error message or every combination of letters
	 * @return l4 the local variable representing the fourth letter
	 */
	public String getOutput() {
		return output;
	}
	/**
	 * A method designed to check if the local variables Letter1, Letter2, Letter3, and Letter4.
	 * are all one and alphabetical character. The method edits the local String variable output according to the Letters.
	 */
	public void checkLetters() {
		if(l1.length() !=1 || l2.length() !=1 || l3.length() !=1 || l4.length() !=1) {
			output = "Please make sure you only entered one alphabetical character in to each box \n";
			error = true;
		}
		char a1 = l1.toUpperCase().charAt(0);
		char a2 = l2.toUpperCase().charAt(0);
		char a3 = l3.toUpperCase().charAt(0);
		char a4 = l4.toUpperCase().charAt(0);
		if(!Character.isLetter(a1) || !Character.isLetter(a2) || !Character.isLetter(a3) || !Character.isLetter(a4)) {
			output = "Please make sure all of your tiles are alphabetical characters \n";
			error = true;
		}
		else if (!error){
			output = "All the possible combination of characters will be displayed below: \n";
		}
	}
	/**
	 * a recursive method designed to create every possible permutation of the String str and append them to 
	 * the local String variable output.
	 * @param str is a String variable representing the characters you would like a permutation of.
	 * @param ans is a String variable representing one possible permutation of the String str.
	 */
	public static void permutations(String str,String ans){
			if (str.length() == 0) {
				output += ans + " ";
				return;
			}
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				String ros = str.substring(0, i) + str.substring(i + 1);
				permutations(ros, ans + ch);
			}
		}
}
