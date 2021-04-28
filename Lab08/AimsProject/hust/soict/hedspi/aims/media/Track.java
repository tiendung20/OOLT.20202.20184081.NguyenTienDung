package hust.soict.hedspi.aims.media;

public class Track implements Playable, Comparable<Track> {
	private String title;
    private int length;
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	public Track(String title) {
		this.title = title;
	}
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
		}
	public boolean equals(Object ob) {
		Track tra = (Track) ob;
		if(this.title.equalsIgnoreCase(tra.title) && length == tra.length) {
			return true;
		}
		else return false;
	}
	
	public int compareTo(Track tra) {
		if(this.title.compareToIgnoreCase(tra.title) == 0) {
			return 0;
		} 
		else if (this.title.compareToIgnoreCase(tra.title) > 0) {
			return 1;
		} 
		else {
			return -1;
		}
	}
}
