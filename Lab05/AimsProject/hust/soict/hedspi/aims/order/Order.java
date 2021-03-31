package hust.soict.hedspi.aims.order;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.utils.MyDate;
public class Order {

	public static final int MAX_NUMBERS_ORDERED = 10;
	public static final int MAX_LIMITTED_ORDERS = 5;
	private static int nbOrders = 0;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
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
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered>=MAX_NUMBERS_ORDERED) System.out.println("The order is almost full");
		else {
			this.itemsOrdered[this.qtyOrdered] = disc;
			System.out.println("The disc has been added");
			this.qtyOrdered++;
		}
	}
	/*public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		if(dvdList.length >= MAX_NUMBERS_ORDERED) System.out.println("The order is almost full");
		else {
			for(int i=0;i < dvdList.length;i++) {
				this.itemsOrdered[i] = dvdList[i];
			}
		}
	}*/
	public void addDigitalVideoDisc(DigitalVideoDisc ...dvdList) {
		if(this.qtyOrdered >= MAX_NUMBERS_ORDERED) {
			System.out.println("The order is almost full");
			System.exit(0);
		}
		for(DigitalVideoDisc disc: dvdList) {
			if(qtyOrdered < MAX_NUMBERS_ORDERED) {
				itemsOrdered[qtyOrdered] = disc;
				qtyOrdered++;
				System.out.println("Add " + disc.getTitle() + " successfull");
			} else {
				System.out.println("The order is full, can't add anymore!");
				System.exit(0);
			}
		}
	}
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
		if(qtyOrdered-2>MAX_NUMBERS_ORDERED) {
			addDigitalVideoDisc(dvd1);
			addDigitalVideoDisc(dvd2);
		}
		else if(qtyOrdered-1>MAX_NUMBERS_ORDERED) {
			addDigitalVideoDisc(dvd1);
			System.out.println("The dvd "+ dvd2.getTitle()+" could not be added.");			
		}
		else {
			System.out.println("The item quantity has reached its limit.");
		}
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int i,j,kt=this.qtyOrdered;
		for(i=0;i<this.qtyOrdered;i++) {
			if(this.itemsOrdered[i].getTitle().equals(disc.getTitle())) {
				for(j=i;j<this.qtyOrdered-1;j++) {
					this.itemsOrdered[j] = this.itemsOrdered[j+1];
				}
				this.qtyOrdered--;
				break;
			}
		}
		if(kt == this.qtyOrdered) System.out.println("Disc not found");
		else System.out.println("The disc has been removed");
	}
	public float totalCost() {
		int i;
		float total = 0;
		for(i=0;i<this.qtyOrdered;i++) {
			total += this.itemsOrdered[i].getCost();
		}
		return total;
	}
	public void print() {
		System.out.println("***********************Order***********************");
		System.out.print("Date: ");
		dateOrdered.print();
		System.out.println("Ordered items: ");
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.printf("%d. %-50s%-20s%-30s%5ds%10.2f$%n",i+1,itemsOrdered[i].getTitle(),itemsOrdered[i].getCategory(),itemsOrdered[i].getDirector(),itemsOrdered[i].getLength(),itemsOrdered[i].getCost());
		}
		System.out.printf("Total cost: %.2f$%n", totalCost());
		System.out.println("***************************************************");
	}
	public DigitalVideoDisc getALuckyItem(){
        if(qtyOrdered <= 1)
            return null;
        else{
            int random_int = (int)(Math.random() * qtyOrdered );
            itemsOrdered[random_int].setCost(0);
            return itemsOrdered[random_int];
        }
    }

}
