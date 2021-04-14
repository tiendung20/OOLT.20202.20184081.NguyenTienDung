package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc {
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	public String getArtist() {
		return artist;
	}
	public CompactDisc(int id) {
		super(id);
	}
	public CompactDisc(int id, String title) {
		super(id,title);
	}
	public CompactDisc(int id, String title, String category) {
		super(id,title,category);
	}
	public CompactDisc(int id, String title, String category, float cost) {
		super(id,title,category,cost);
	}
	public CompactDisc(int id, String title, String category, float cost, String director) {
		super(id,title,category,cost,director);
	}
	public CompactDisc(int id, String title, String category, float cost, String director, int length) {
		super(id,title, category, cost, director, length);
	}
	public CompactDisc(int id, String title, String category, float cost, String director, int length, String artist) {
		super(id,title, category, cost, director, length);
		this.artist = artist;
	}
	public CompactDisc(int id, String title, String category, float cost, String director, int length, String artist, List<Track> tracks) {
		super(id,title, category, cost, director, length);
		this.artist = artist;
		this.tracks = tracks;
	}
	public void addTrack(Track track) {
		String title = track.getTitle();
		int kt = 0;
		for(Track tra : this.tracks) {
			if(title.equals(tra.getTitle())) {
				kt = 1;
				break;
			}
		}
		if(kt==1) System.out.println("Already exist");
		else {
			tracks.add(track);
			System.out.println("Add success");
		}
	}
	public void removeTrack(Track track) {
		String title = track.getTitle();
		int kt = 0;
		for(Track tra : this.tracks) {
			if(title.equals(tra.getTitle())) {
				tracks.remove(tra);
				kt = 1;
				break;
			}
		}
		if(kt==0) System.out.println("Does not exist");
		else System.out.println("Remove success");
	}
	public int getLength() {
		int totalLength = 0;
		for(Track tra : this.tracks) {
			totalLength += tra.getLength();
		}
		return totalLength;
	}
	public void play() {
		System.out.printf("%-30s %-15s\n", "Title", "Length");
		for(Track tra : tracks) {
            System.out.printf("%-30s %-15d\n",tra.getTitle(),tra.getLength());
		}
	}
}
