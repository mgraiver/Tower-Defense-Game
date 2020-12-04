
public class TankyBee extends HoneyBee{
	//fields
	private int damage;
	private int armor;
	
	//constructor
	public TankyBee(Tile p, int d, int a) {
		super(p,30,3);
		this.damage = d;
		this.armor = a;
	}
	private int getDamage() {
		return damage;
	}
	private int getArmor() {
		return armor;
	}
	
	public boolean takeAction() {
		boolean first = false;
		if(this.getPosition() != null && (this.getPosition()).getNumOfHornets() != 0) {
			(this.getPosition()).getHornet().takeDamage(this.damage);
			first = true;
		}
		return first;
	}
	public void takeDamage(int d) {
		double multiplier = 100/(100+((double)this.armor));
		int actualDamage = (int)(damage*multiplier);
		super.takeDamage(actualDamage); 
		
	}
	
	public boolean equals(Object obj1) {
		if(super.equals(obj1)) {
			if(((TankyBee) obj1).getDamage() == this.damage && ((TankyBee)obj1).getArmor() == this.armor) {
				return true;
			}
			return false;
		}
		return false;
	}

}
