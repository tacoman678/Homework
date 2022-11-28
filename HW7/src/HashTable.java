import java.util.ArrayList;
public class HashTable {
	private ArrayList<String> keywords;
	private ArrayList<Integer> hashValue;
	private ArrayList<Integer> frequency;
	public HashTable() {
		keywords = new ArrayList<String>();
		hashValue = new ArrayList<Integer>();
		frequency = new ArrayList<Integer>();
	}
	public void addKeyword(String a) {
		keywords.add(a);
	}
	public void addHashValue(int hash) {
		hashValue.add(hash);
	}
	public void addFrequency(int freq) {
		frequency.add(freq);
	}
	public String getKeyword(int index) {
		return keywords.get(index);
	}
	public int getHashValue(int index) {
		return hashValue.get(index);
	}
	public int getFrequency(int index) {
		return frequency.get(index);
	}
	public int getNumKeywords() {
		return keywords.size();
	}
	public ArrayList<String> getKeyWords(){
		return keywords;
	}
}
