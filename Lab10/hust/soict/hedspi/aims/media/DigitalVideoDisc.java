package hust.soict.hedspi.aims.media;
import javax.naming.directory.InvalidAttributesException;
import hust.soict.hedspi.aims.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable{

	public DigitalVideoDisc() {}
	
	public DigitalVideoDisc(String title, int id) {
		super(title, id);
	}
	
	public DigitalVideoDisc(String title, String category, int id) {
		super(title, category, id);
	}

	public DigitalVideoDisc(String title, String category, String director, int id) {
		super(title, category,director, id);
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost, int id) throws Exception {
		super(title, category, director, length,cost, id);
	}
	
	public boolean search(String title) {
		String[] token = title.toLowerCase().split("\\s");
		String discTitle = getTitle();
		int check = 0;
		String[] tokenSearch = discTitle.toLowerCase().split("\\s");
		for (String string : token) {
			for (String string2 : tokenSearch) {
				if (string.equals(string2) == true) {
					check++;
					if (check == token.length) {
						return true;
					}
				}
			}
		}
		return false;
	}
	public void play() throws PlayerException {
		if (this.getLength() <= 0)
			try {
				{
					System.err.println("Must >= 0");
					throw new PlayerException("ERR: DVD length is non-positive!");
				}
			} catch (PlayerException e) {
				e.printStackTrace();
			}
		else {
			System.out.println(this.getLength());
			System.out.println(this.getTitle());
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
	public int compareTo(Media ob) {
		DigitalVideoDisc DVD = (DigitalVideoDisc) ob;
		if (DVD instanceof DigitalVideoDisc) {
			if (this.getCost() < DVD.getCost()) {
				return -1;
			}
			else if (this.getCost() > DVD.getCost()) {
				return 1;
			}
			else {
				if (this.getLength() < DVD.getLength()) {
					return -1;
				}
				else if (this.getLength() > DVD.getLength()) {
					return 1;
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
