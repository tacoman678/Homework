import java.util.ArrayList;
/**
 * Represents a collection of SalesItem objects and manipulates them to gather a total of all SalesItems and a desired format.
 * @version 1.0
 * @author Dan Bajda
 */
public class SalesSlip {
	private String output = "";
	ArrayList<SalesItem> slip;
	/**
	 * The SalesSip() constructor instantiates an ArrayList of SalesItems.
	 */
	public SalesSlip() {
		 slip = new ArrayList<SalesItem>();
	}
	/**
	 * addSalesItem(SalesItem s) adds a SalesItem object to the ArrayList.
	 * @param s is a SalesItem object containing a item, price and quantity.
	 */
	public void addSalesItem(SalesItem s) {
		slip.add(s);
	}
	/**
	 * computeTotal() multiplies all of the prices of the SalesItem's contained in the SalesSlip ArrayList of SalesItems
	 * by all of the SalesItem's quantity and adds them together to get a final total.
	 * @return a String of the final total formatted to two decimal places.
	 */
	public String computeTotal() {
		double total = 0;
		if(slip.size() >= 1) {
			for(int i = 0; i < slip.size(); i++) {
				total += slip.get(i).getPrice() * slip.get(i).getQuantity();
			}
		}
		else {
			output = "Please enter some sales items";
			return output;
		}
		if(total < 10.00) {
			output = "$0" + String.format("%.2f", total);
			return output;
		}
		output = "$" + String.format("%.2f", total);
		return output;
	}
	/**
	 * toString() is used to format all of the SalesItems contained within the ArrayList local to the class.
	 * @return a String that is list of all the SalesItems variables (item, price, and quantity) on seperate lines.
	 */
	public String toString() {
		String output = "";
		if(slip.size() < 1) {
			output = "Please enter some sales items";
			return output;
		}
		for (int i = 0; i < slip.size(); i++){
			output += slip.get(i).toString() + "\n";
		}
		return output;
	}
}
