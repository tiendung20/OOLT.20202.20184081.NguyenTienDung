package AimsProject;

public class Order {

	public static final int MAX_NUMBERS_ORDERED = 10;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered>=MAX_NUMBERS_ORDERED) System.out.println("The order is almost full");
		else {
			this.itemsOrdered[this.qtyOrdered] = disc;
			System.out.println("The disc has been added");
			this.qtyOrdered++;
		}
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int i,j,kt=this.qtyOrdered;
		for(i=0;i<this.qtyOrdered;i++) {
			if(this.itemsOrdered[i].getTitle().equals(disc.getTitle())) {
				for(j=i;j<this.qtyOrdered-1;j++) {
					this.itemsOrdered[j] = this.itemsOrdered[j+1];
				}
				this.qtyOrdered--;
				break;
			}
		}
		if(kt == this.qtyOrdered) System.out.println("Disc not found");
		else System.out.println("The disc has been removed");
	}
	public float totalCost() {
		int i;
		float total = 0;
		for(i=0;i<this.qtyOrdered;i++) {
			total += this.itemsOrdered[i].getCost();
		}
		return total;
	}

}
