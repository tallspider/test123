//time first, THEN number of stops
import java.io.*;
import java.util.*;
public class simulation {
	public static void main(String[] args)throws IOException, InterruptedException{
		Subway line1 = new Subway("line1.txt"); //for(int i = 0; i < line1.numStops; i++) System.out.println(line1.names[i]);
		//Subway line2 = new Subway("line2.txt"); //for(int i = 0; i < line1.numStops; i++) System.out.println(line1.names[i]);
		//Subway line3 = new Subway("line3.txt"); //for(int i = 0; i < line1.numStops; i++) System.out.println(line1.names[i]);
		//Subway line4 = new Subway("line4.txt"); //for(int i = 0; i < line1.numStops; i++) System.out.println(line1.names[i]);
		
		//for(int i = 0; i < 32; i++)System.out.println(TTCGreen.names[i]);
		/*while(true){
			line1.sim(0, 31);
			line1.sim(31, 0);
		}
		*/
		int[] result = line1.sim("Yorkdale", "Dupont");
		System.out.println(result[0]);
		
	}
}

class Subway{
	int numStops;
	int[] times;
	String[] names;
	Stop[] line;
	String lineName;
	int lineNum;
	
	public Subway(String fname) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader(fname));
		StringTokenizer st;
		numStops = Integer.parseInt(f.readLine());
		times = new int[numStops];
		names = new String[numStops];
		line = new Stop[numStops];
		lineName = f.readLine();
		lineNum = Integer.parseInt(f.readLine());
		String s;
		int i = 0;
		while( (s = f.readLine()) != null){
			st = new StringTokenizer(s);
			names[i] = st.nextToken(); 
			times[i] = Integer.parseInt(st.nextToken());
			i++;
		}
		line[0] = new Stop(names[0], null, null, 0, times[0], 0);
		for(int j = 1; j < numStops; j++)
			line[j] = new Stop(names[j], line[j-1], null, times[j-1], times[j], j);
		for(int j = 0; j < numStops-1; j++){
			line[j].next = line[j+1];
		}
		f.close();
	}
	
	int[] sim(int id1, int id2) throws InterruptedException, IOException{
		if(id1 <= -1 || id2 <= -1 || id1 >= numStops || id2 >= numStops) return new int[]{-1, -1};
		if(id1 < id2) return goFwd(line[id1], line[id2]);
		return goBwd(line[id1], line[id2]);
	}
	
	int[] sim(Stop s1, Stop s2) throws InterruptedException, IOException{
		int id1 = s1.id;
		int id2 = s2.id;
		if(id1 == -1 || id2 == -1) return new int[]{-1, -1};
		if(id1 < id2) return goFwd(line[id1], line[id2]);
		return goBwd(line[id1], line[id2]);
	}
	int[] sim(String st1, String st2) throws InterruptedException, IOException{
		int id1 = findByName(st1);
		int id2 = findByName(st2);
		if(id1 == -1 || id2 == -1) return new int[]{-1, -1};
		if(id1 < id2) return goFwd(line[id1], line[id2]);
		return goBwd(line[id1], line[id2]);
	}
	
	int[] goFwd(Stop st1, Stop st2) throws InterruptedException, IOException{
		Stop at = st1;
		int ret = 0;
		int nstops = 0;
		System.out.println("At Station " + at.name);
		SendReq.sendReq(at.name, "post" + lineNum);
		while (at != st2){
			Thread.sleep(times[at.id] * 1000);
			
			ret += times[at.id];
			nstops++;
			at = at.next;
			System.out.println("At Station " + at.name);
			SendReq.sendReq(at.name, "post" + lineNum);
		}
		return new int[]{ret, nstops};
	}
	
	int[] goBwd(Stop st1, Stop st2) throws InterruptedException, IOException{
		Stop at = st1;
		int ret = 0;
		int nstops = 0;
		System.out.println("At Station " + at.name);
		SendReq.sendReq(at.name, "post" + lineNum);
		while (at != st2){
			Thread.sleep(times[at.id-1] * 1000);
			ret += times[at.id-1];
			nstops++;
			at = at.prev;
			System.out.println("At Station " + at.name);
			SendReq.sendReq(at.name, "post" + lineNum);
		}
		return new int[]{ret, nstops};
	}
	
	int findByName(String name){
		for(int i = 0; i < numStops; i++){
			if(names[i].equals(name)) return i;
		}
		return -1;
	}
}

class Stop{
	String name;
	Stop prev, next;
	int prevt, nextt;
	int id;
	
	public Stop(String n, Stop pr, Stop nx, int t1, int t2, int i){
		name = n;
		prev = pr;
		next = nx;
		prevt = t1;
		nextt = t2;
		id = i;
	}
}