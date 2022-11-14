public class CodeLine {
	/*each individual line of code */
	private String line;
	public CodeLine(String line) {
		this.line = line;
	}
	public boolean getFor() {
		if(line.contains("for")) {
			return true;
		}
		return false;
	}
	public boolean getWhile() {
		if(line.contains("while")) {
			return true;
		}
		return false;
	}
	public boolean getIf() {
		if(line.contains("if") || line.contains("else")) {
			return true;
		}
		return false;
	}
	public boolean methodHeader() {
		if(!line.contains("for") && !line.contains("while") && !line.contains("if") && !line.contains("else") && line.contains("(")) {
			if(line.contains("private") || line.contains("public")) {
				return true;
			}
		}
		return false;
	}
	public String getCodeLine() {
		return line;
	}
}
