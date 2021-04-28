package hust.soict.hedspi.aims.media;

public abstract class Media implements Comparable<Media> {
	protected String title;
	protected String category;
	protected float cost;
	protected int id;
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public float getCost() {
		return cost;
	}
	public int getId() {
		return id;
	}
	public Media() {
	}
	public Media(int id) {
		this.id = id;
	}
	public Media(int id, String title) {
		this.id = id;
		this.title = title;
	}
	public Media(int id, String title, String category) {
		this.id = id;
		this.title = title;
		this.category = category;
	}
	public Media(int id, String title, String category, float cost) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public boolean equals(Object object) {
		Media ob = (Media) object;
		if(this.id==ob.id) {
			return true;
		}
		else return false;
	}
	@Override
	public int compareTo(Media o) {
		// TODO Auto-generated method stub
		return 0;
	}
}