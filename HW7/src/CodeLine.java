import java.util.ArrayList;
public class CodeLine {
	/*each individual line of code */
	private String line;
	private ArrayList<String> keywords;
	private ArrayList<Integer> contains;
	public CodeLine(String line, ArrayList<String> keywords) {
		this.line = line;
		this.keywords = new ArrayList<String>(keywords);
		contains = new ArrayList<Integer>();
		for(int i = 0;i<keywords.size();i++) {
			if(line.contains(keywords.get(i))) {
				contains.add(1);
			}
			else {
				contains.add(0);
			}
		}
	}
	public int getContains(int index) {
		return contains.get(index);
	}
	public String getCodeLine() {
		return line;
	}
}
