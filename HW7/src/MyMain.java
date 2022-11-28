import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class MyMain {
	public static void main(String[] args) {
		String[] keywords;
		String data;
		HashTable hTable = new HashTable();
		ArrayList<CodeLine> lines = new ArrayList<CodeLine>();
		Timer stopwatch = new Timer();
		stopwatch.startTimer();
		try {
	        File myObj = new File("C:\\Users\\edste\\Downloads\\keywords.txt");
	        Scanner myReader = new Scanner(myObj);
	        while (myReader.hasNextLine()) {
	          data = myReader.nextLine();
	          keywords = data.split(" ");
	          for(int i = 0; i < keywords.length; i++) {
	        	  hTable.addKeyword(keywords[i]);
	          }
	        } myReader.close();
	        try {
	        	File code = new File("C:\\Users\\edste\\eclipse-workspace\\Student\\src\\Queue.java");
	        	Scanner myReader2 = new Scanner(code);
	        	while (myReader2.hasNextLine()) {
	        		data = myReader2.nextLine();
	        		if (data.contains("}") || data.contains(";") || data.contains("{")) {
						lines.add(new CodeLine(data.trim(),hTable.getKeyWords()));
					}
	        	}
	        	for(int i=0;i<hTable.getKeyWords().size();i++) {
	        		hTable.addHashValue(hashFunction(hTable.getKeyword(i),hTable.getKeyWords().size()));
	        		int freq = 0;
	        		for(int j=0;j<lines.size();j++) {
	        			if(lines.get(j).getContains(i)==1) {
	        				freq++;
	        			}
	        		}
	        		hTable.addFrequency(freq);
	        	}
	        	
	        } catch (FileNotFoundException e){
	        	System.out.println("An error occurred.");
		        e.printStackTrace();
	        }
	      } catch (FileNotFoundException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
		stopwatch.stopTimer();
		System.out.println("Total Number of Lines Read: " + lines.size());
		System.out.println("Keywords\t Hash Value\t Frequency\t");
		for(int i = 0; i < hTable.getKeyWords().size(); i++) {
			System.out.println(hTable.getKeyword(i) + "\t\t"+ hTable.getHashValue(i) + "\t\t" + hTable.getFrequency(i));
		}
		System.out.println("Time Taken(ms): " + stopwatch.getTimeElapsed());
	}
	public static int hashFunction(String word, int numKeywords) {
		int g = 31;
		int hashCode = word.length() + 26*(int)word.charAt(0) + g*(int)word.charAt(word.length()-1)%numKeywords; 
		return hashCode;
	}
}
