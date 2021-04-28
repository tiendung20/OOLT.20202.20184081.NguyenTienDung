package hust.soict.hedspi.test.media;
import hust.soict.hedspi.aims.media.Book;

public class BookTest {
	public static void main(String[] args) {
		 Book book = new Book(1,"Example 1","Example 1",12f);
		 book.addAuthor("Ex1");
		 book.setContent("Test content 1");
		 book.toString();
	}
}
