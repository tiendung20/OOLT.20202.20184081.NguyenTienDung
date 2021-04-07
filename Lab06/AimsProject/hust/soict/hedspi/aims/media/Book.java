package hust.soict.hedspi.aims.media;

import java.util.List;
import java.util.ArrayList;

public class Book extends Media {

	private List<String> authors = new ArrayList<String>();
	public Book() {
    }
    public Book(String title) {
        super(title);
    }
    public Book(String title, String category) {
        super(title, category);
    }
    public Book(String title, String category, List<String> authors) {
        super(title, category);
        this.authors = authors;
    }
	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	public void addAuthor(String authorName) {
		if(authors.contains(authorName)==false) authors.add(authorName); 
	}
	public void removeAuthor(String authorName) {
		if(authors.size()>0&&authors.contains(authorName)==true) authors.remove(authorName);
	}
}
