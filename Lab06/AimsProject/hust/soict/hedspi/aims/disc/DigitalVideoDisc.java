package hust.soict.hedspi.aims.disc;

import hust.soict.hedspi.aims.media.Media;

public class DigitalVideoDisc extends Media {
	private String director;
	private int length;
	public DigitalVideoDisc() {};	
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
	}
	public DigitalVideoDisc(String category, String title) {
		super();
		this.category = category;
		this.title = title;
	}
	public DigitalVideoDisc(String director, String category, String title) {
		super();
		this.director = director;
		this.category = category;
		this.title = title;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}
	public boolean search(String title) {
		String[] s = this.title.split("\\s");
		String[] s1 = title.split("\\s");
		int i,j = 0;
		for(i=0;i<s1.length;i++) {
			for(String w:s) {
				if(s1[i].equalsIgnoreCase(w)) {
					j++;
					break;
				}
			}
		}
		if(i==j) return true;
		else return false;
	}
}
