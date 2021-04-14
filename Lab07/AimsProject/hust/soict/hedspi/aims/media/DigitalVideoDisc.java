package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc {
	public DigitalVideoDisc(int id) {
		super(id);
	}
	public DigitalVideoDisc(int id, String title) {
		super(id,title);
	}
	public DigitalVideoDisc(int id, String title, String category) {
		super(id,title,category);
	}
	public DigitalVideoDisc(int id, String title, String category, float cost) {
		super(id,title,category,cost);
	}
	public DigitalVideoDisc(int id, String title, String category, float cost, String director) {
		super(id,title,category,cost,director);
	}
	public DigitalVideoDisc(int id, String title, String category, float cost, String director, int length) {
		super(id,title,category,cost,director,length);
	}
	public boolean search(String title) {
		String[] word1 = title.toLowerCase().split("\\s");
		String Title = getTitle();
		String[] word2 = Title.toLowerCase().split("\\s");
		int kt = 0;
		for (@SuppressWarnings("unused") String str1 : word1) {
			for (@SuppressWarnings("unused") String str2 : word2) {
				if (word1.equals(word2) == true) {
					kt++;
					if (kt == word1.length) {
						return true;
					}
				}
			}
		}
		return false;
	}
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
		}
}
