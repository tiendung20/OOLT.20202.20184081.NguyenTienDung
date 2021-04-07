package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.order.Order;

import java.util.Scanner;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
public class Aims {
	
	public static void showMenu() {
		System.out.println("Order Management Application: ");
		System.out.println("--------------------------------");
		System.out.println("1. Create new order");
		System.out.println("2. Add item to the order");
		System.out.println("3. Delete item by id");
		System.out.println("4. Display the items list of order");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}

	public static void main(String[] args) {
		int select;
		int n = 0, check = 0;
		int orderID, itemId;
		Scanner input = new Scanner(System.in);
		Order anOrder = null;
		do {
			showMenu();
			select = Integer.parseInt(input.nextLine());
			switch(select) {
			case 1:
				anOrder = anOrder.createOrder();
				check = 1;
				System.out.println("Order created");
				break;
			case 2:
				if (anOrder == null) {
					System.out.println("Order is not be created yet.");
					break;
				}
				int choose = 0;
				Media media = null;
				do {
					System.out.println("--------------------------------");
					System.out.println("Please choose type of item");
					System.out.println("1. Digital Video Disc");
					System.out.println("2. Book");
					System.out.println("3. Cancel");
					System.out.println("--------------------------------");
					System.out.println("Choose: ");
					choose = Integer.parseInt(input.nextLine());
					switch (choose) {
						case 1:
							media = new DigitalVideoDisc();
							break;
						case 2:
							media = new Book();
							break;
						default:
							break;
					}
				} while (choose!=1&&choose!=2);
				if (choose == 1 || choose == 2) {
					String title;
					int id;
					float cost;
					String category;
					System.out.println("ID: ");
					id = input.nextInt();
					input.nextLine();
					System.out.println("Title: ");
					title = input.nextLine();
					System.out.println("Category: ");
					category = input.nextLine();
					System.out.println("Cost: ");
					cost = input.nextFloat();
					media.setId(id);
					media.setTitle(title);
					media.setCategory(category);
					media.setCost(cost);
					anOrder.addMedia(media);
				}
				break;
			case 3:
				if (anOrder == null) {
					System.out.println("Order is not be created yet.");
					break;
				}
				System.out.println("What item do you want to delete? ");
				int id = input.nextInt();
				anOrder.removeMedia(id);
				break;
            case 4:
            	if (anOrder == null) {
					System.out.println("Order is not be created yet.");
					break;
				}
            	anOrder.print();
				break;
            default:
                break;
			}
		}while(select!=0);

	}
}
