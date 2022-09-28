/**
 * Represents an item to be bought a store with an item name, price, and quantity of said item
 * 
 * @author Dan Bajda
 * @version 1.0
 */
public class SalesItem {
	private String item;
	private double price;
	private int quantity; 
	private double total;
	/**
	 * SalesItem constructor instantiates a SalesItem object
	 * @param item is a String that repesents the type of item.
	 * @param price is a double representing the price of said item.
	 * @param quantity is an int representing the quantity of items. 
	 */
	public SalesItem(String item, double price, int quantity) {
		this.item = item;
		this.price = price;
		this.quantity = quantity;
	}
	/**
	 * getItem() is a method that returns the local String variable item.
	 * @return the local String variable item.
	 */
	public String getItem() {
		return item;
	}
	/**
	 * setItem(i) is designed to set the local String variable item to i.
	 * @param i is a String to represent an item.
	 */
	public void setItem(String i) {
		item = i;
	}
	/**
	 * getPrice() is a method that returns the local double variable price.
	 * @return the local double variable price.
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * setPrice(p) is designed to set the local double variable price to p.
	 * @param p is a double to represent a price of an item.
	 */
	public void setPrice(double p) {
		price = p;
	}
	/**
	 * getQuantity() is a method that returns the local int variable quantity.
	 * @return the local int variable quantity.
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * 	setQuantity(q) is designed to set the local int variable quantity to q.
	 *  @param q is a int to represent a quantity of items.
	 */
	public void setQuantity(int q) {
		quantity = q;
	}
	/**
	*calcTotal() is a method that returns the product of the quantity of items and the price of a SalesItem.
	* @return a double representing the total of a SalesItem. 
	*/
	public double calcTotal() {
		return quantity * price;
	}
	/**
	 * toString() is a method that returns a formatted String including the item, price and quantity of the SalesItem.
	 * @return a String representing the formatted String of a SalesItem
	 */
	public String toString() {
		String output = item;
		for(int i = 0; i < 15 - item.length(); i++ ) {
			output += " ";
		}
		output += "$";
		if(price < 10.0) {
			output += "0" + price;
		}
		else {
			output += price;
		}
		for(int j = 0; j < 5; j++) {
			output += " ";
		}
		output += quantity;
		return output;
	}
}
