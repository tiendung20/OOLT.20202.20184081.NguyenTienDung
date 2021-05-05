package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Book extends Media{

	private List<String> authors = new ArrayList<String>();
	private String content;
	public List<String> contentTokens = new ArrayList<>();
	public Map<String, Integer> wordFrequency = new TreeMap<>();
	
	public Book() {
	}
	public Book(int id, String title) {
		super(title, id);
	}
	
	public Book(String title, String category, int id) {
		super(title, category, id);
	}
	public Book(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}
	
	public Book(String title,float cost, String category, List<String> authors, int id) {
		super(id, title, category,cost);
		if (authors.size() != 0) {
			this.authors = authors;
		}
		else {
			System.out.println("Authors list is empty.");
		}
	}

	public boolean addAuthor(String authorName) {
		if (authors.contains(authorName)) {
			System.out.println("Can not add author.");
			return false;
		}
		else {
			authors.add(authorName);
			System.out.println("Added author.");
			return true;
		}
	}
	public boolean removeAuthor(String authorName) {
		if (authors.size() == 0) {
			System.out.println("Can not remove author.");
			return false;
		}
		else if (!authors.contains(authorName)) {
			System.out.println("Can not remove author.");
			return false;
		}
		else {
			authors.remove(authorName);
			System.out.println("Removed author.");
			return true;
		}
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void processContent() {
		this.contentTokens.addAll(Arrays.asList(this.content.split("[\\p{Punct}\\s]+")));
		Collections.sort(contentTokens);
		
		Iterator<String> iterator = contentTokens.iterator();
		while (iterator.hasNext()) {
			String string = iterator.next();
			if (wordFrequency.containsKey(string) == false) {
				wordFrequency.put(string, 1);
			}else {
				int count = wordFrequency.get(string);
				count++;
				wordFrequency.put(string, count);
			}
		}
	}
	
	@Override
	public String toString() {
		
		String str = "";
		str += "Id: "+this.id+"\n";
		str += "Title: "+this.title+"\n";
		str += "Authors: ";
		for (String author : this.authors) {
			str += author + ", ";
		}
		str += "\n";
		str += "Cost: "+this.cost+"$\n";
		str += "Number of tokens: " + contentTokens.size() + "\n";
		for (Map.Entry<String, Integer> c : this.wordFrequency.entrySet()) {
			str += c.getKey() + " : "+ c.getValue() + "\n";
		}
		
		return str;
	}
}
