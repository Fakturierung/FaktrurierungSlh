package entity;

public class CounterSequence {
	
	protected static long number;
	
	static {
		number = 1000L;
	}
	public static long getAndIncrement(){
		return number++;		
	}

}
