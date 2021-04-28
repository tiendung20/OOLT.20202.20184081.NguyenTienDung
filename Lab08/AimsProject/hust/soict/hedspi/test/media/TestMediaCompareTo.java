package hust.soict.hedspi.test.media;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestMediaCompareTo {

	public static void main(String[] args) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, "Roger Allers", 87);	
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", 24.95f,"George Lucas", 124);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Alladin", "Animation", 18.99f,"John Musker", 90);
		
		java.util.Collection collection = new java.util.ArrayList();
		collection.add(dvd1);
		collection.add(dvd2);
		collection.add(dvd3);
		
		java.util.Iterator iterator = collection.iterator();
		
		System.out.println("-------------------------------------");
		System.out.println("The DVDs currently in the order are: ");
		
		while (iterator.hasNext()) {
		    System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
		}
		
		java.util.Collections.sort((java.util.List)collection);
		
		iterator = collection.iterator();
		System.out.println("-------------------------------------");
		System.out.println("The DVDs in sorted order are: ");
		
		while (iterator.hasNext()) {
		    System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
		}
		
		System.out.println("--------------------------------------");
	}

}
