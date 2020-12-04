
public class Hornet extends Insect {
	//fields
	private int damage; 
	
	//constructor
	public Hornet(Tile p, int hp, int d) {
		//position and healthPoints are private fields in Insect
		super(p,hp);
		this.damage = d;
		
	}
	
	private int getDamage() {
		return damage;
	}
	
	public boolean takeAction(){
		boolean first = true;
		if((this.getPosition()).getBee() != null) {
			(this.getPosition()).getBee().takeDamage(this.damage);
			first = true;
		}
		else if( this.getPosition().isOnThePath()){
			super.setPosition((super.getPosition()).towardTheHive());
			first = true;
		}
		else if((this.getPosition()).isHive()) {
			first = false;
		}
		return first;
	}
	
	public boolean equals(Object obj2) {
		if(super.equals(obj2)) {
			if(((Hornet) obj2).getDamage() == this.damage) {
				return true;
			}
			return false;
		}
		return false;
	}
	
}
