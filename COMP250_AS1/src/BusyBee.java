
public class BusyBee extends HoneyBee {
	
	public BusyBee(Tile p) {
			super(p, 5, 2);	
		
	}
	
	public boolean takeAction() {
		(super.getPosition()).storeFood(2);
		return true;
	}

		
	}

