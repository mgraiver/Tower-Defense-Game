
public abstract class HoneyBee extends Insect{
	//fields
	
	//how much bee costs in food
	private int beeCost;
	
	//constructor
	//position & healthpoints = private fields from Insect
	public HoneyBee(Tile p, int hp, int bc) {
		super(p,hp);
		this.beeCost = bc;
	}
	
	//other methods
	

	public int getCost() {
		return this.beeCost;
	}
	
	public boolean equals(Object obj2) {
		if(super.equals(obj2))
		{
			if( ((HoneyBee)obj2).getCost() == this.beeCost) {
				return true;
			}
			return false;
		}
		return false;
	}
	
}
