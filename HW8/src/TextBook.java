import java.io.Serializable;
public class TextBook implements Serializable{
	private int sku;
	private String title;
	private double price;
	private int quantity;
	public TextBook(int sku, String title, double price, int quantity) {
		this.sku = sku;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
	}
	public int getSKU() {
		return sku;
	}
	public String getTitle() {
		return title;
	}
	public double getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
}
