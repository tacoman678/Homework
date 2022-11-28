public class Timer {
	private static long start;
	private static long stop;
	public static void startTimer() {
		start = System.currentTimeMillis();
	}
	public static void stopTimer() {
		stop = System.currentTimeMillis();
	}
	public long getStart() {
		return start;
	}
	public long getStop() {
		return stop;
	}
	public long getTimeElapsed() {
		return stop-start;
	}
}
