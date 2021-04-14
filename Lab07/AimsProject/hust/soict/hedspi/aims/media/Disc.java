package hust.soict.hedspi.aims.media;

public class Disc extends Media {
	protected String director;
	protected int length;
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public Disc(int id) {
		super(id);
	}
	public Disc(int id, String title) {
		super(id,title);
	}
	public Disc(int id, String title, String category) {
		super(id,title,category);
	}
	public Disc(int id, String title, String category, float cost) {
		super(id,title,category,cost);
	}
	public Disc(int id, String title, String category, float cost, String director) {
		super(id,title,category,cost);
		this.director = director;
	}
	public Disc(int id, String title, String category, float cost, String director, int length) {
		super(id,title,category,cost);
		this.director = director;
		this.length = length;
	}
}
