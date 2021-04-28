package hust.soict.hedspi.aims.order;

import hust.soict.hedspi.aims.utils.MyDate;
import hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;
public class Order {

	public static final int MAX_NUMBERS_ORDERED = 10;
	public static final int MAX_LIMITTED_ORDERS = 5;
	private static int nbOrders = 0;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	private MyDate dateOrdered;
	public Order(){
		nbOrders++;
		dateOrdered = new MyDate();
	}

	public static Order createOrder(){
		if(nbOrders == MAX_LIMITTED_ORDERS) {
			System.out.println("Max orders reach!");
			return null;
		}
		return new Order();
	}
	public void addMedia(Media a) {
		this.itemsOrdered.add(a);
	}
	public void removeMedia(Media a) {
		if(this.itemsOrdered.size()>0&&this.itemsOrdered.contains(a)==true) this.itemsOrdered.remove(a);
	}
	public void removeMedia(int ID) {
		for(Media a : itemsOrdered) {
			if(a.getId()==ID) itemsOrdered.remove(a);
		}
	}
	public float totalCost() {
		float total = 0;
		for(Media w: this.itemsOrdered) {
			total += w.getCost();
		}
		return total;
	}
	public void print() {
		System.out.println("***********************Order***********************");
		System.out.print("Date: ");
		dateOrdered.print();
		System.out.println("Ordered items: ");
		int i=1;
		for(Media media: itemsOrdered) {
			System.out.println(i + ". " + "DVD - " + media.getTitle() + " - " + media.getCategory() +
		             " - " + media.getCost());
		i++;
		}
		System.out.printf("Total cost: %.2f$%n", totalCost());
		System.out.println("***************************************************");
	}
	public boolean checkID(int id) {
		for(Media a : this.itemsOrdered) {
			if(a.getId()==id) return true;
		}
		return false;
	}
	/*public DigitalVideoDisc getALuckyItem(){
        if(qtyOrdered <= 1)
            return null;
        else{
            int random_int = (int)(Math.random() * qtyOrdered );
            itemsOrdered[random_int].setCost(0);
            return itemsOrdered[random_int];
        }
    }*/

}
