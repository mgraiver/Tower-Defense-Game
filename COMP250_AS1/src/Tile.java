
public class Tile {
	//fields 
	private int food;
	private boolean hiveBuiltOnTile;
	private boolean nestBuiltOnTile;
	private boolean partOfPath;
	private Tile pathNestToHive;
	private Tile pathHiveToNest;
	private HoneyBee beeOnTile;
	private SwarmOfHornets hornetsOnTile;

	public Tile() {
		this.food = 0;
		this.hiveBuiltOnTile = false;
		this.nestBuiltOnTile = false;
		this.partOfPath = false;
		this.pathNestToHive = null;
		this.pathHiveToNest = null;
		this.beeOnTile = null;
		this.hornetsOnTile = new SwarmOfHornets();

	}
	
	public Tile(int f, boolean ht, boolean nt, boolean path, Tile nh, Tile hn, HoneyBee bt, SwarmOfHornets hort) {
		this.food = f;
		this.hiveBuiltOnTile=ht;
		this.nestBuiltOnTile = nt;
		this.partOfPath = path;
		this.pathNestToHive = nh;
		this.pathHiveToNest = hn;
		this.beeOnTile = bt;
		this.hornetsOnTile = hort;
		
	}
	
	public boolean isHive() {
		return this.hiveBuiltOnTile;
	}
	
	public boolean isNest() {
		return this.nestBuiltOnTile;
	}
	//updates field indicating if there's bee on tile
	public void buildHive() {
		hiveBuiltOnTile = true;
	}
	
	public void buildNest() {
		nestBuiltOnTile = true;	
		
	}
	
	public boolean isOnThePath() {
		return this.partOfPath;
	}
	
	public Tile towardTheHive(){
			return this.pathNestToHive;
	}
	
	public Tile towardTheNest(){
			return this.pathHiveToNest;
	}
	
	public void createPath(Tile h, Tile n) {
		this.pathNestToHive = h;
		this.pathHiveToNest= n;
		this.partOfPath=true;
	}	

	public int collectFood() {
		int newFood = food;
		food = 0;
		return newFood;
	}
	
	public void storeFood(int f) {
		this.food += f;
		
	}
	
	public HoneyBee getBee() {
		return this.beeOnTile;
	}
	
	public Hornet getHornet() {
		return this.hornetsOnTile.getFirstHornet();
	}
	
	public int getNumOfHornets() {
		return hornetsOnTile.sizeOfSwarm();
	}
	
	public boolean addInsect(Insect i) {
		if((i instanceof HoneyBee) && this.getBee() == null && this.isNest() == false) {
			this.beeOnTile = (HoneyBee) i;
			return true;
		}
		//Hornet is added if there is a hornets nest or bee hive or if its on the path from the nest to the hive
		else if((i instanceof Hornet) && (this.isHive() || this.isNest() || this.isOnThePath())) {
			(this.hornetsOnTile).addHornet((Hornet)i);
			
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean removeInsect(Insect oldI) {
		if(oldI instanceof BusyBee) {
			this.beeOnTile = null;
			return true;
		}
		if(oldI instanceof Hornet) {
			return (this.hornetsOnTile).removeHornet((Hornet)oldI);
		}
		else {
			return false;
		}
	}
	

		
}
