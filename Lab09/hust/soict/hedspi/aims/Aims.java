package hust.soict.hedspi.aims;

import java.util.Scanner;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.order.Order;

public class Aims {

	public static void main(String[] args) throws Exception{
		int choose;
		Scanner input = new Scanner(System.in);
		Order anOrder = null;
		do {
			showMenu();
			choose = input.nextInt();
			switch (choose) {
			case 0:
				System.out.println("End!");
				break;
			case 1:
				anOrder = new Order();
				System.out.println("Created an Order!");
				break;
			case 2:
				if (anOrder == null) {
					System.out.println("Order has not been created");
					break;
				}
				
				System.out.println("Please choose type of item");
				System.out.println("1. Book");
				System.out.println("2. Digital Video Disc");
				System.out.println("3. CompactDisc");
				System.out.println("0. Cancel");
				System.out.println("--------------------------------");
				System.out.println("Please choose a number: 0-1-2-3");
				int choice = input.nextInt();
				
				switch (choice) {
				case 1:
					addBook(anOrder, input);
					break;
				case 2:
					addDisc(anOrder, input);
					break;
				case 3:
					addCompactDisc(anOrder, input);
					break;
				default:
					break;
				}
				break;
			case 3:
				if (anOrder == null) {
					System.out.println("Order has not been created");
					break;
				}
				System.out.println("Enter ID to remove: ");
				int id = input.nextInt();
				if (anOrder.searchById(id)==null) {
					System.out.println("Does not exist");
				}
				else {
					anOrder.removeMedia(anOrder.searchById(id));
					System.out.println("Item has been deleted");
				}
				break;
			case 4:
				if (anOrder == null) {
					System.out.println("Order has not been created");
					break;
				}
				anOrder.prints();
				break;
			default:
				break;
			}
		} while (choose>0&&choose<5);
		input.close();
	}
	
	public static void showMenu(){
		System.out.println();
        System.out.println("\tOrder Management Application");
        System.out.println("_____________________");
        System.out.println("1. Create new order");
        System.out.println("2. Add item to the order");
        System.out.println("3. Delete item by id");
        System.out.println("4. Display the items list of order");
        System.out.println("0. Exit");
        System.out.println("_____________________");
        System.out.println("Please choose a number: 0-1-2-3-4");

    }
	
	private static void addDisc(Order anOrder, Scanner input) {
		int id;
		do {
			System.out.println("Enter ID: ");
			id = input.nextInt();
			if (anOrder.searchById(id) != null) {
				System.out.println("Item already exists. Try again.");
			}
		} while (anOrder.searchById(id)!=null);
		System.out.println("Enter title: ");
		String title = input.next();
		System.out.println("Enter category: ");
		String category = input.next();
		System.out.println("Enter cost: ");
		float cost = input.nextFloat();
		System.out.println("Enter director: ");
		String director = input.next();
		System.out.println("Enter length: ");
		int length = input.nextInt();
		
		DigitalVideoDisc disc = new DigitalVideoDisc(title, category, director, length, cost, id);
		anOrder.addMedia(disc);
		
		player();
		int p = input.nextInt();
		switch (p) {
		case 1:
			disc.play();
			break;
		case 2:
			break;
		default:
			break;
		}
	}
	
	private static void addBook(Order anOrder, Scanner input) {
		int id;
		do {
			System.out.println("Enter ID: ");
			id = input.nextInt();
			if (anOrder.searchById(id) != null) {
				System.out.println("Item already exists. Try again.");
			}
		} while (anOrder.searchById(id)!=null);
		
		System.out.println("Enter title: ");
		String title = input.next();
		System.out.println("Enter category: ");
		String category = input.next();
		System.out.println("Enter cost: ");
		float cost = input.nextFloat();
		
		Book book = new Book(id, title, category, cost);
		int numOfAuthors = 0;
		do {
			System.out.println("Enter number of authors: ");
			numOfAuthors = input.nextInt();
			if (numOfAuthors <= 0) {
				System.out.println("Number of authors is invalid. Try again.");
			}
		} while (numOfAuthors <= 0);
		for (int i = 0; i < numOfAuthors; i++) {
			System.out.println("Enter author's name: ");
			String author = input.next();
			book.addAuthor(author);
		}
		anOrder.addMedia(book);
	}
	
	private static void addCompactDisc(Order anOrder, Scanner input) {
		int id;
		do {
			System.out.println("Enter ID: ");
			id = input.nextInt();
			if (anOrder.searchById(id) != null) {
				System.out.println("Item already exists. Try again.");
			}
		} while (anOrder.searchById(id)!=null);
		System.out.println("Enter title: ");
		String title = input.next();
		System.out.println("Enter category: ");
		String category = input.next();
		System.out.println("Enter cost: ");
		float cost = input.nextFloat();
		System.out.println("Enter artist: ");
		String artist = input.next();
		
		
		CompactDisc cd = new CompactDisc(id, title, category, cost, artist);
		
		System.out.println("Enter the number of tracks add:");
		int n = input.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.println("Enter title: ");
			String titleString = input.next();
			System.out.println("Enter length: ");
			int length = input.nextInt();
			cd.addTrack(new Track(titleString, length));
		}
		
		anOrder.addMedia(cd);
		
		player();
		String p = input.next();
		switch (p) {
		case "Y":
			cd.play();
			break;
		case "N":
			break;
		default:
			break;
		}
	}
	
	public static void player() {
		System.out.println("Do you want to play CD/DVD? (Y or N):");
	}

}
