package hust.soict.hedspi.aims.media;
import hust.soict.hedspi.aims.PlayerException;

public class Track implements Playable, Comparable<Object> {

	private String title;
	private int length;

	public Track() {
		// TODO Auto-generated constructor stub
	}

	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	public void play() throws PlayerException {
		if (this.getLength() <= 0) {
			System.err.println("Must >= 0");
			throw new PlayerException("ERR: DVD length is non-positive!");
		} else {
			System.out.println(this.getTitle());
			System.out.println(this.getLength());
		}
	}

	public String play1() throws PlayerException {
		String str = "";
		if (this.getLength() <= 0) {
			System.err.println("Must >= 0");
			throw new PlayerException("ERR: DVD length is non-positive!");
		} else {
			str += this.getTitle() + "\n";
			str += this.getLength() + "\n";
			return str;
		}
	}

	@Override
	public boolean equals(Object obj) {
		Track track = (Track) obj;
		if (track instanceof Track) {
			if (track.getTitle().equals(this.getTitle()) && track.getLength() == this.getLength()) {
				return true;
			}
		}
		return false;
	}
	@Override
	public int compareTo(Object o) {
		Track track = (Track) o;
		if (track instanceof Track) {
			if (track.length > this.length) {
				return -1;
			}else if (track.length < this.length) {
				return 1;
			}else {
				return 0;
			}
		}else {
			return 500;
		}
	}

}
