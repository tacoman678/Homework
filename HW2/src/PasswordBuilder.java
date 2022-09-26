import java.util.ArrayList;
/**
 * Represents and manipulates a password
 * 
 * @author Dan Bajda
 * @version 1.0
 */
public class PasswordBuilder {
	private String password;
	private String output = " "; 
	/**
	 * PasswordBuilder constructor is used to instantiate a PasswordBuilder object
	 * @param pass is a string parameter representing a password
	 */
	public PasswordBuilder(String pass) {
		password = pass;
	}
	/**
	 * getPassword() is a method that returns a PasswordBuilder's password
	 * @return the String variable local to the PasswordBuilder class password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * setPassword() is used to set the local variable of the PasswordBuilder class password to the desired string input
	 * @param is a string parameter representing a password
	 */ 	
	 public void setPassword(String pass) {
		password = pass;
	}
	 /**
	  * getOutput() is a method that returns the local variable of the PasswordBuilder class output
	  * @return the String variable local to the PasswordBuilder class output
	  */
	public String getOutput() {
		return output;
	}
	/**
	 * checkPassword() is a method designed to check whether a password is longer than 7 characters, shorter than 12 characters,
	 * and count the length and amount of blocks of characters in a password. Where a block is a String of the same characters.
	 * The method changes the value of output according to the password of the class PasswordBuilder.
	 */
	public void checkPassword() {
		if(password.length() <= 7) {
			output = "Please enter a password longer than 7 characters";
			return;
		}
		if(password.length() > 12) {
			output = "Please enter a password no longer than 12 characters";
			return;
		}
		if(password.contains(" ")) {
			output = "Please enter a password with no spaces";
			return;
		}
		int block = 0;
		String temp = "";
		ArrayList<String> blocks = new ArrayList<String>();
		int i = 0;
		while(i < password.length() - 1) {
			if(i < password.length()- 2 && password.charAt(i) == password.charAt(i+1)) {
				while(i < password.length()- 2 && password.charAt(i) == password.charAt(i+1)) {
					temp += password.charAt(i);
					i++;
				}
				i++;
				temp += password.charAt(i);
				blocks.add(temp);
				temp = "";
			}
			i++;
		}
		for(int j = 0; j < blocks.size();j++) {
			if(blocks.get(j).length() > block) {
				block = blocks.get(j).length();
			}
		}
		if(block > 2) {
			output = "The largest block in the your password is "+block+". This password can be made stronger by reducing the block to 2 or less";
			return;
		}
		output = "The largest block in the your password is "+block+". This is a decent password";
	}
}
