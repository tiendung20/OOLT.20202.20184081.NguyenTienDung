package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
	
	private String artist;
	
	private ArrayList<Track> tracks = new ArrayList<>();

	public CompactDisc() {
		super();
	}
	
	public CompactDisc(int id, String title, String category, float cost, String artist) {
		super(title, category, id);
		this.cost = cost;
		this.artist = artist;
	}

	public String getArtist() {
		return artist;
	}
	
	public void addTrack(Track track) {
		if (tracks.contains(track)) {
			System.out.println("Already exist.");
		}
		else {
			tracks.add(track);
			System.out.println("Add success.");
		}
	}
	
	public void removeTrack(Track track) {
		if (!tracks.contains(track)) {
			System.out.println("Does not exist.");
		}else {
			tracks.remove(track);
			System.out.println("Remove success.");
		}
	}
	
	public int getLength() {
		int totalLength = 0;
		for(Track tra : this.tracks) {
			totalLength += tra.getLength();
		}
		return totalLength;
	}
	
	public int getNumberOfTrack() {
		return tracks.size();
	}
	
	public void play() {
		System.out.printf("%-35s %-15s %-15s\n", "Title", "Disk","Length");
		for (Track track : tracks) {
			System.out.printf("%-35s %-15d %-15d\n",track.getTitle(),tracks.size(),track.getLength());
		}
	}
	
	@Override
	public int compareTo(Media ob) {
		CompactDisc CD = (CompactDisc) ob;
		if (CD instanceof CompactDisc) {
			if (this.getNumberOfTrack() > CD.getNumberOfTrack()) {
				return 1;
			}
			else if (this.getNumberOfTrack() < CD.getNumberOfTrack()) {
				return -1;
			}
			else {
				if (this.getLength() > CD.getLength()) {
					return 1;
				}
				else if (this.getLength() < CD.getLength()) {
					return -1;
				}
				else {
					return super.compareTo(ob);
				}
			}
		}
		else {
			new Exception("Error");
			return 500;
		}
	}

}
