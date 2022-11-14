import java.util.ArrayList;
public class ProgramCounter {
	/* each denote the number of for loops, while loops, and if/else statements and total lines within a program*/
	private int cfor, cwhile, cif, totlines;
	/* an ArrayList containing all the method headers of all the methods within a program */
	private ArrayList<String> methodHeaders;
	public ProgramCounter() {
		cfor = 0;
		cwhile = 0;
		cif = 0;
		totlines = 0;
		methodHeaders = new ArrayList<String>();
	}
	public void addFor() {
		cfor++;
	}
	public void addWhile() {
		cwhile++;
	}
	public void addIf() {
		cif++;
	}
	public void addLine() {
		totlines++;
	}
	public void addMethodHeader(String str) {
		methodHeaders.add(str);
	}
	public int getFor() {
		return cfor;
	}
	public int getWhile() {
		return cwhile;
	}
	public int getIf() {
		return cif;
	}
	public ArrayList<String> getMethodHeaders(){
		return methodHeaders;
	}
	public int getLines() {
		return totlines;
	}
}
