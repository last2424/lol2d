package Start;

public class Time {
	public static final long SECOND = 1000000000L;
	private static double delta;
	private static long lasttime = 0;
	public static void Update(){
		if(lasttime ==0)
			lasttime = System.nanoTime();
		long startTime = System.nanoTime();
		long passedTime = startTime-lasttime;
		delta = passedTime/SECOND;
		lasttime = startTime;
	}
	public static double getDelta() {
		return delta;
	}
}
