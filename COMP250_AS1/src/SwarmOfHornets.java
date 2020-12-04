
public class SwarmOfHornets {
	
	private Hornet[] swarm;
	private int sizeOfSwarm;
	
	
	//A constructor that takes no inputs and creates an empty swarm. 
	public SwarmOfHornets(){
		this.swarm = new Hornet[0];
	}
	
	public int sizeOfSwarm(){
		return this.sizeOfSwarm;
	}
	
	public Hornet[] getHornets() {
		if (sizeOfSwarm == 0)
			return null;
		else
			return this.swarm;
		
	}
	
	public Hornet getFirstHornet() {
		if (sizeOfSwarm == 0)
			return null;
		else
			return this.swarm[0];
	
	}
		
	
	public void addHornet(Hornet h) {
		//create new array w size of swarm +1
		sizeOfSwarm ++;
		Hornet[] newSwarm = new Hornet[this.sizeOfSwarm];
		//copy old swarm to newswarm
		int i=0;
		while( i < this.swarm.length ) {
			//last position will be null
			newSwarm[i] = this.swarm[i];
			i++;
		}
		//put h in last index of new swarm 
		newSwarm[sizeOfSwarm-1] = h;
		//switch reference
		this.swarm = newSwarm;
		
	}
	
	private void remove(Hornet[] h) {
		//new swarm = old swarm w/ index 1 less
		Hornet[] newSwarm = new Hornet[this.sizeOfSwarm()-1];
		//i = index for old swarm
		//j = index for new swarm
		int i =0;
		int j =0;
		//set values of new swarm to values of old
		while (i < h.length) {
			if ((h[i] != null )) {
			newSwarm[j] = h[i];
			i++;
			j++;
			}
			else {
				//if null increase index of oldswarm by 1
				i++;
			}
		}	
		this.swarm = newSwarm;
		}

	
	public boolean removeHornet(Hornet h){
		boolean isHornetThere = false;
		for(int i = 0; i < swarm.length; i++) {
			//check how to compare
			if(h == this.swarm[i]) {
				isHornetThere = true;
				this.swarm[i]= null;
				remove(swarm);
				sizeOfSwarm--;
			}
	}
		return isHornetThere;
}

}






