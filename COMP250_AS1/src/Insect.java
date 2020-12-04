
public abstract class Insect {
	
	//fields 
	private Tile position;
	private int healthPoints;
	
	//constructor
	public Insect(Tile p, int hp) {
		this.position = p;
		this.healthPoints = hp;
		if (position.addInsect(this) == false) {
			throw new IllegalArgumentException("Bee on tile");
			}
	}
	
	//other methods
	public final Tile getPosition() {
		return this.position;
	}
	
	public final int getHealth() {
		//retrieves health points of this insect
		return this.healthPoints;
	}
	
	public void setPosition(Tile p) { 
		this.position = p;
	}
	
	public void takeDamage(int damageTaken) {
		
		int actualDamage = damageTaken;
		if((this instanceof HoneyBee) && (this.position).isHive() == true)
		{
			actualDamage = (int)((0.90)*((double)damageTaken));
		}
		this.healthPoints = this.healthPoints - actualDamage;
		if(this.healthPoints <= 0);
		{
		this.position.removeInsect(this); 	
		}
	}
	public abstract boolean takeAction();
	
	public boolean equals(Object obj1) {
		if(obj1 instanceof Insect)
		{
			Insect t = (Insect)obj1;
			if(this.position == t.getPosition()) {
				if(this.healthPoints == t.getHealth()) {
					return true;
				}
				return false;
			}
			return false;
		}
		else {
			return false;
		}
	}
	

}
