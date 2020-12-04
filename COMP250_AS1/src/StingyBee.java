public class StingyBee extends HoneyBee{
	//fields
	private int damage;
	
	//constructor 
	public StingyBee(Tile p, int d) {
		super(p,10,1);
		this.damage = d;
	}
	
	private int getDamage() {
		return this.damage;
	}
	
	public boolean takeAction() {
		Tile newPosition;
	//is the bee on the path or the hive
		if((this.getPosition()).isOnThePath() || (this.getPosition()).isHive()) {
			//if the bee is on the path or the hive, then is there a hornet on this tile and is it not the nest
			if((this.getPosition()).getNumOfHornets() != 0 && !(this.getPosition()).isNest()) {
				(this.getPosition()).getHornet().takeDamage(this.damage);
			}
			//if there are no hornets on the tile but its not the nest
			if((this.getPosition()).getNumOfHornets() == 0 && !(this.getPosition()).isNest()) {
				newPosition = (this.getPosition()).towardTheNest();
				//keep moving forward toward the nest as long as there are no hornets on the path and its not the nest
				while (true) {
					if (newPosition.isNest()) {
						break;
					}
					if (newPosition.getNumOfHornets() != 0 ) {
						break;
				}
					newPosition = (this.getPosition()).towardTheNest();
				}
				
				//if there are hornets on the tile and its not the nest
				if(!(newPosition.isNest()) && (newPosition.getNumOfHornets() != 0 )) {
					(newPosition.getHornet()).takeDamage(this.damage);
					 return false;
				}
				//if there are hornets on the tile but it is the nest
				if((newPosition.isNest())) {
					 return true;
				}
			}
		}
		return false;
	}
	
	public boolean equals(Object obj1) {
		if(super.equals(obj1)) {
			if(((StingyBee) obj1).getDamage() == this.damage) {
				return true;
			}
			return false;
		}
		return false;
	}

}

