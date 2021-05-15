package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import javax.naming.directory.InvalidAttributesException;
import hust.soict.hedspi.aims.PlayerException;

public class CompactDisc extends Disc implements Playable{
	
	private String artist;
	
	private ArrayList<Track> tracks = new ArrayList<>();

	public CompactDisc() {
		super();
	}
	
	public CompactDisc(int id, String title, String category, float cost, String artist) throws Exception {
		super(title, category, id);
		this.cost = cost;
		this.artist = artist;
		if (cost >= 0) {
			this.cost = cost;
		} else {
			throw new InvalidAttributesException("Cost>=0");
		}
	}

	public String getArtist() {
		return artist;
	}
	public void play() throws PlayerException {
		if (this.getLength() <= 0) {
			System.err.println("Must >= 0");
			throw new PlayerException("ERR: CD length is non-positive!");
		} else {
			System.out.println(tracks.size());
			System.out.println(getLength());
			for (Track track : tracks) {
				track.play();
			}
		}
	}
	public String play1() throws PlayerException {
		String str = "";
		if (this.getLength() <= 0) {
			System.err.println("Must >= 0");
			throw new PlayerException("ERR: CD length is non-positive!");
		} else {
			str += tracks.size()+ "\n";
			str += getLength() + "\n";
			for (Track track : tracks) {
				try {
					str += track.play1();
				} catch (PlayerException e) {
					throw e;
				}
			}
		}
		return str;
	}
	
	public void addTrack(Track track) throws Exception {
		if (tracks.contains(track)) {
			System.out.println("Already exist.");
			throw new Exception("Already exist.");
		}
		else {
			tracks.add(track);
			System.out.println("Add success.");
		}
	}
	
	public void removeTrack(Track track) throws Exception {
		if (!tracks.contains(track)) {
			System.out.println("Does not exist.");
			throw new Exception("Does not exist.");
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
