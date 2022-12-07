import java.util.ArrayList;
import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BookStore {
	private ArrayList<TextBook> inventory = new ArrayList<TextBook>();

	public BookStore() {
		try {
			FileInputStream fileIn = new FileInputStream("myObject.ser");
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(fileIn));
			inventory = (ArrayList<TextBook>) in.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void addTextBook() {
		Scanner obj = new Scanner(System.in);
		System.out.println("Please enter a title of the textbook: ");
		String title = obj.nextLine();
		System.out.println("Please enter a SKU (Stock Keeping Unit must be an integer): ");
		int sku = obj.nextInt();
		System.out.println("Please enter a price of the textbook in the format dollars.cents: ");
		double price = obj.nextDouble();
		System.out.println("Please enter a quantity of the desired textbook to add as an integer: ");
		int quantity = obj.nextInt();
		inventory.add(new TextBook(sku, title, price, quantity));
		try {
			FileOutputStream fileOut = new FileOutputStream("myObject.ser");
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(fileOut));
			try {
				out.writeObject(inventory);
			} catch (IOException e) {
				e.printStackTrace();
			}
			out.close();
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void removeTextBook() {
		boolean contains = false;
		Scanner obj = new Scanner(System.in);
		System.out.println(
				"Please enter a SKU (Stock Keeping Unit must be an integer) of the textbook you would like to remove: ");
		int sku = obj.nextInt();
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).getSKU() == sku) {
				inventory.remove(i);
				contains = true;
			}
		}
		if (contains) {
			try {
				FileOutputStream fileOut = new FileOutputStream("myObject.ser");
				ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(fileOut));
				try {
					out.writeObject(inventory);
				} catch (IOException e) {
					e.printStackTrace();
				}
				out.close();
				fileOut.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Book is not in the inventory");
		}
	}

	public void displayInfo() {
		boolean contains = false;
		Scanner obj = new Scanner(System.in);
		System.out.println(
				"Please enter a SKU (Stock Keeping Unit must be an integer) of the textbook you would like to see: ");
		int sku = obj.nextInt();
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).getSKU() == sku) {
				System.out.println("SKU \t Title \t Price \t Quantity \n" + inventory.get(i).getSKU() + "\t"
						+ inventory.get(i).getTitle() + "\t" + inventory.get(i).getPrice() + "\t"
						+ inventory.get(i).getQuantity());
				contains = true;
			}
		}
		if (!contains) {
			System.out.println("Book is not in the inventory");
		}
	}

	public void displayInventory() {
		if (inventory.size() == 0) {
			System.out.println("whoa, such empty");
		} else {
			System.out.println("SKU \t Title \t Price \t Quantity");
			for (int i = 0; i < inventory.size(); i++) {
				System.out.println(inventory.get(i).getSKU() + "\t" + inventory.get(i).getTitle() + "\t"
						+ inventory.get(i).getPrice() + "\t" + inventory.get(i).getQuantity());
			}
		}
	}

	public static void main(String[] args) {
		// TEST CASE:
		// Create a BookStore, you will need to add a textbook in order for the
		// constructor to run without error
		// because the file myObject.ser does not exist yet
		BookStore b = new BookStore();
		b.displayInventory();
		b.addTextBook();
		b.displayInventory();
		b.removeTextBook();
		b.displayInventory();
		// To check if inventory is the same across different instances of the
		// BookStore, create another instance of BookStore a
		// add a book and see if the inventory is the same on the other instance b
		BookStore a = new BookStore();
		a.displayInventory();
		// inventory should be the same as the last inventory call
		a.addTextBook();
		// run program again to see if the textbook added to BookStore a can be seen on
		// the first call of the displayInventory for BookStore b
	}
}
