package mechanics;

public class Counter {//Counts for the story increments
	
	private int count;
	public int getCount(){
		return count;
	}
	
	public void increment(){
		count += 1; 
	}
	void reset(){
		count = 0; 
	}
}
