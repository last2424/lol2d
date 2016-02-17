package Start;

public class Time {
	public static final long SECOND = 1000000000L;
	private static double delta;
	private static long lasttime = System.nanoTime();
	public static void Update(){
		
		long startTime = System.nanoTime();
		long passedTime = startTime-lasttime;
		delta = passedTime/(double)SECOND;
		lasttime = startTime;
	}
	public static double getDelta() {
		return delta;
	}
}
