package hust.soict.hedspi.aims;

import java.util.Scanner;

import hust.soict.hedspi.aims.order.Order;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
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
	public static void showMedia() {
		System.out.println("Please choose type of item");
		System.out.println("--------------------------------");
		System.out.println("1. Book");
		System.out.println("2. CD");
		System.out.println("3. DVD");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	private static void addBook(Order anOrder,  Scanner input) {
		//Scanner input = new Scanner(System.in);
		System.out.println("ID: ");
		int id = input.nextInt();
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
				System.out.println("Enter again");
			}
		} while (numOfAuthors <= 0);
		for (int i = 0; i < numOfAuthors; i++) {
			System.out.println("Enter author's name: ");
			String author = input.next();
			book.addAuthor(author);
		}
		if(anOrder.checkID(id)==false) anOrder.addMedia(book);
		else System.out.println("Error ID");
		//input.close();
	}
	private static void addCD(Order anOrder, Scanner input) {
		//Scanner input = new Scanner(System.in);
		System.out.println("ID: ");
		int id = input.nextInt();
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
		
		DigitalVideoDisc disc = new DigitalVideoDisc(id,title,category,cost, director, length);
		if(anOrder.checkID(id)==false) anOrder.addMedia(disc);
		else System.out.println("Error ID");
		//input.close();
	}
	
	private static void addDVD(Order anOrder, Scanner input) {
		//Scanner input = new Scanner(System.in);
		System.out.println("ID: ");
		int id = input.nextInt();
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
        DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category, cost, director, length);
        String choose;
        do{
            System.out.println("Play test (Y or N): ");
            choose = input.next();
            if(choose.equals("Y")){
                dvd.play();
            }
            else if(choose.equals("N")){}
            else
                System.out.println("Error");
        }while(!choose.equals("N"));
        if(anOrder.checkID(id)==false) anOrder.addMedia(dvd);
		else System.out.println("Error ID");
        //input.close();
    }

	public static void main(String[] args) {
		int select;
		Scanner input = new Scanner(System.in);
		Order anOrder = null;
		do {
			showMenu();
			select = input.nextInt();
			switch(select) {
			case 1:
				anOrder = new Order();
				if(anOrder!=null) System.out.println("Order has been successfully created");
				break;
			case 2:
				if (anOrder == null) {
					System.out.println("Order has not been created");
					break;
				}
				int choose = 0;
				do {
					showMedia();
					choose = input.nextInt();
					switch (choose) {
						case 1:
							addBook(anOrder,input);
							break;
						case 2:
							addCD(anOrder,input);
							break;
						case 3:
							addDVD(anOrder,input);
							break;
						default:
							break;
					}
				} while (choose!=0);
				break;
			case 3:
				if (anOrder == null) {
					System.out.println("Order has not been created");
					break;
				}
				System.out.println("Select item: ");
				int id = input.nextInt();
				anOrder.removeMedia(id);
				break;
            case 4:
            	if (anOrder == null) {
					System.out.println("Order has not been created");
					break;
				}
            	anOrder.print();
				break;
            default:
                break;
			}
		}while(select!=0);
		input.close();

	}
}
