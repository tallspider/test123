import java.io.IOException;

public class Main {
	public static int destination;
	public static int preStop;
	public static boolean done = false;
	public static int currentStop;			//where the train of the line i want to ride is
	private static int myStop;				//where i am right now
	public static int line;						//the train i want to be on
	public static boolean onTrain = false;		//if i am on the train 
	
	public static boolean initialized = false;
	
	public static void main(String[] args) {
		Thread start = new Thread() {
			public void run() {
				while (true) {
					if (initialized) {
						beginJourney();
						return;
					}
				}
			}
		};
		
		start.start();

	}
	
	public int getLine() {
		return line;
	}
	
	public static void initialize(int line, int myStop, int destination) {
		SubwayBefore sub = new SubwayBefore();
		sub.ImportFrom("line");
		Main.line = line;
		Main.myStop = myStop;
		Main.destination = destination;

		Main.preStop = sub.before(line, myStop, destination);
		
		initialized = true;
	}
	
	public static String getCurrentStop() {
		return NameToNumberConverter.IntToString(line, currentStop);
	}
	
	
	private static void beginJourney() {

		Thread lineThread = new Thread() {
			public void run() {
				try {
					while (true) {
						currentStop = NameToNumberConverter.StringToInt(line, ReceiveReq.receiveReq("get" + line));
						System.out.println(currentStop);
						Thread.sleep(500);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
	
		Thread myPosition = new Thread() {
			public void run() {
				while (!done)
					if (onTrain) {
						myStop = currentStop;
						if (myStop == preStop)
							alert();
					}
						
						
			}
		};
		
		Thread boardTrain = new Thread() {
			public void run() {
				while (!done) {
					while (!onTrain) {
						if (currentStop == myStop)
							onTrain = true;
							
					}
				}
			}
		};
		
		Thread isDone = new Thread() {
			public void run() {
				while (!done) {
					if (myStop == destination);
						done = true;
				}
			}
		};
		
		isDone.start();
		lineThread.start();
		myPosition.start();
		boardTrain.start();
	}
	
	private static void alert() {
		//method to alert user
	}
	
}
