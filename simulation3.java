import java.io.IOException;

public class simulation3 {
	public static void main(String[] args)throws IOException, InterruptedException{
		//Subway line1 = new Subway("line1.txt"); //for(int i = 0; i < line1.numStops; i++) System.out.println(line1.names[i]);
		//Subway line2 = new Subway("line2.txt"); //for(int i = 0; i < line1.numStops; i++) System.out.println(line1.names[i]);
		Subway line3 = new Subway("line3.txt"); //for(int i = 0; i < line1.numStops; i++) System.out.println(line1.names[i]);
		//Subway line4 = new Subway("line4.txt"); //for(int i = 0; i < line1.numStops; i++) System.out.println(line1.names[i]);
		
		//for(int i = 0; i < 32; i++)System.out.println(TTCGreen.names[i]);
		/*while(true){
			line1.sim(0, 31);
			line1.sim(31, 0);
		}
		*/
		int[] result = line3.sim(0, 5);
		System.out.println(result[0]);
		
	}
}
