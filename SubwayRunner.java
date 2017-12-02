import java.util.Scanner;

public class SubwayRunner{

   public static void main(String[]args){
   
      String filename = "Timing.txt";
      Scanner input = new Scanner(System.in);
   
      Subway s = new Subway();
      s.importFile(filename);
      
      int from,to,time;
      
      
      for (int i = 0 ; i < s.stops.length ; i++){
         System.out.println(i + "." + s.stops[i].getName());
      }
      
      System.out.println("enter current stop");
      from = input.nextInt();
      System.out.println("enter destination");
      to = input.nextInt();
      
      time = s.getTime(from,to);
      
      System.out.println("Time to get there: " + time + " minutes");
      
   }
}