package hust.soict.hedspi.aims.order;

import java.util.ArrayList;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.utils.MyDate;

public class Order {

	public static final int MAX_NUMBERS_ORDERED = 10;
	public static final int MAX_LIMITTED_ORDERS = 5;
	private static int nbOrders = 0;
	private ArrayList<Media> itemsOrdered = new ArrayList<>();
	private MyDate dateOrdered;
	private int id;
	public static int getNbOrders() {
		return nbOrders;
	}

	public int getId() {
		return id;
	}

	public Order() throws Exception {
		if (nbOrders >= MAX_LIMITTED_ORDERS) {
			System.out.println("The list of orders is full.");
			throw new Exception("Number of orders reached limit.");
		}
		else {
			dateOrdered = new MyDate();
			System.out.println(dateOrdered.print());
			System.out.println("Order has been created.");
			nbOrders++;
		}
	}
	
	public void addMedia(Media media) {
		if (itemsOrdered.size() >=10) {
			System.out.println("The order list is full");
		}
		else {
			itemsOrdered.add(media);
			System.out.println(media.getTitle() + " is added to the order list.");
		}
	}
	
	public void addMedia(Media ...mediaa) {
		if (mediaa == null) {
			System.out.println("No media to add.");
		}
		else if (itemsOrdered.size() >= 10) {
			System.out.println("The order list is full.");
		}else {
			if (itemsOrdered.size() + mediaa.length > 10) {
				System.out.println("Not enough slot for these items.");
			}
			else {
				for (int i = 0; i < mediaa.length; i++) {
					itemsOrdered.add(mediaa[i]);
					System.out.println(mediaa[i].getTitle() + " is added to the order list.");
				}
			}
		}
	}

	public void addMedia(Media media1, Media media2) {
		if (itemsOrdered.size() >= 10) {
			System.out.println("Not enough slot for these items.");
			System.out.println("The dvd " + media1.getTitle() + " could not be added.");
			System.out.println("The dvd " + media2.getTitle() + " could not be added.");
		}
		else {
			if (itemsOrdered.size() >= 9) {
				itemsOrdered.add(media1);
				System.out.println("The dvd "+media1.getTitle()+" is added.");
				System.out.println("The dvd "+media2.getTitle()+" could not be added.");
			}
			else {
				itemsOrdered.add(media1);
				System.out.println("The dvd "+media1.getTitle()+" is added.");
				itemsOrdered.add(media2);
				System.out.println("The dvd "+media2.getTitle()+" is added.");
			}
		}
	}

	public void removeMedia(Media media) {
		if (itemsOrdered.size() <= 0) {
			System.out.println("The Order list is empty.");
		}
		else {
			if(itemsOrdered.remove(media)) {
				System.out.println(media.getTitle() + " is removed from order list.");
			}
			else {
				System.out.println("No item in order list.");
			}
		}
	}
	
	public Media searchById(int id) {
		Media media =  this.itemsOrdered.stream().filter(o->o.getId()==id).findFirst().orElse(null);
        return media;
	}
	
	public float totalCost() {
		float sum = 0f;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			sum = sum + itemsOrdered.get(i).getCost();
		}
		return sum;
	}
	public void print() {
		for (int i = 0; i < itemsOrdered.size(); i++) {
			System.out.print(itemsOrdered.get(i).getTitle()+": ");
			System.out.println(itemsOrdered.get(i).getCost());
		}
	}
	
	public void prints() {
		System.out.println("******************Order******************");
		System.out.print("Date: ");
		System.out.println(dateOrdered.print());
		System.out.println("Ordered items:");
		for (int i = 0; i < itemsOrdered.size(); i++) {
			System.out.println(itemsOrdered.get(i).getTitle()+" "+itemsOrdered.get(i).getCategory()+" "+": "+itemsOrdered.get(i).getCost());
		}
		System.out.println("Total cost: "+totalCost());
	}
	
/*	public Media getALuckyItem() {
		if (itemsOrdered.size() < 1) {
			return null;
		}else {
			int index = (int)(Math.random()*itemsOrdered.size());
			itemsOrdered.get(index).setCost(0);
			return itemsOrdered.get(index);
		}
	}*/
	
}
