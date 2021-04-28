package hust.soict.hedspi.aims.media;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.text.html.HTMLDocument.Iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Book extends Media {

	private List<String> authors = new ArrayList<String>();
	private String content;
	public List<String> contentTokens = new ArrayList<>();
	private Map<String, Integer> wordFrequency = new TreeMap<>();
	public Book(int id) {
		super(id);
	}
    public Book(int id, String title) {
        super(id,title);
    }
    public Book(int id, String title, String category) {
        super(id,title, category);
    }
    public Book(int id, String title, String category,float cost) {
        super(id,title, category,cost);
    }
    public Book(int id, String title, String category, List<String> authors) {
        super(id,title, category);
        this.authors = authors;
    }
	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
		processContent();
	}
	public void addAuthor(String authorName) {
		if(authors.contains(authorName)==false) authors.add(authorName); 
	}
	public void removeAuthor(String authorName) {
		if(authors.size()>0&&authors.contains(authorName)==true) authors.remove(authorName);
	}
	public void processContent() {
		contentTokens.addAll(Arrays.asList(content.split("\\s+")));
        Collections.sort(contentTokens);
        Iterator<String> iterator = contentTokens.iterator();
        while(iterator.hasNext()) {
            String string = iterator.next();
            if (!wordFrequency.containsKey(string)) {
                wordFrequency.put(string, 1);
            }else {
                int a = wordFrequency.get(string);
                a++;
                wordFrequency.put(string, a);
            }
        }
	}
}
