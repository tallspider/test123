// SUBWAY TIMING
import java.io.*;

class Subway{

   Stop[] stops;

   public Subway(Stop[] stops){
      this.stops = stops;
   }
   
   public Subway(){
   
   }
   
   public int getTime(int from, int to){
      return stops[from].getTime(to);
   }
   
   public void remove(int index){
   
      Stop[] newStops = new Stop[stops.length-1];
      
      for (int i = 0 ; i < newStops.length ; i ++){
      
         if (i < index){
            newStops[i] = stops[i]; 
         }
         else if (i >= index){
            newStops[i] = stops[i+1];
         }
         
      }
      
      for (int i = 0 ; i < newStops.length ; i++){
         newStops[i].remove(index);
      }
      
      
      stops = newStops;
   }
   
   public void exportFile(String fileName){
   
      try{
         BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
         
         String line;
         
         for (int i = 0 ; i < this.stops.length ; i++){
         
            line = stops[i].getName();
         
            for (int a = 0; a < this.stops.length ; a++){
               line += " " + this.getTime(i,a) + " ";
            }
            
            out.write(line);
            out.newLine();
         }
      
         out.close();
      }
      catch(IOException iox){
      
      }
   }
   
   public void importFile(String filename){
   
      try{
         BufferedReader in = new BufferedReader(new FileReader(filename));
         
         int numStop;
         int[][] fromTimeTo;
         String[] stopName;
         String[] info;
         String input;
         
         input = in.readLine();
         info = input.split(" ");
         
         numStop = info.length - 1;
         fromTimeTo = new int[numStop][numStop];
         stopName = new String[numStop];
         
         stopName[0] = info[0];
         for (int i = 0 ; i < info.length-1 ; i++){
            fromTimeTo[0][i] = Integer.parseInt(info[i+1]);
         }
         
         for (int i = 1 ; i < numStop ; i++){
         
            input = in.readLine();
            info = input.split(" ");
         
            stopName[i] = info[0];
            for (int a = 0 ; a < info.length-1 ; a++){
               fromTimeTo[i][a] = Integer.parseInt(info[a+1]);
            }
         }
         
         this.stops = new Stop[numStop];
         
         for (int i = 0 ; i < numStop; i++){
         
            this.stops[i] = new Stop(stopName[i], fromTimeTo[i]);
         
         }
         
      }
      catch(IOException iox){
      
      }
   }  

   public String toString(){
   
      String output = "";
      String line;
         
      for (int i = 0 ; i < this.stops.length ; i++){
         
         line = i + "." + stops[i].getName();
         
         for (int a = 0; a < this.stops.length ; a++){
            line += " " + this.getTime(i,a) + " ";
         }
         output += line + "\n";
      }
   
      return output;
   }
}

class Stop{

   String stopName;
   int[] timeTo;

   public Stop(String stopName, int[] timeTo){
   
      this.stopName = stopName;
      this.timeTo = timeTo;
   }
   
   public int getTime(int index){
      return timeTo[index];
   }
   
   public String getName(){
      return stopName;
   }
   
   public void remove(int index){
   
      int[] newTime = new int[this.timeTo.length - 1];
      
      for (int i = 0; i < newTime.length; i++){
      
         if (i < index){
            newTime[i] = this.getTime(i);
         }
         else if (i >= index){
            newTime[i] = this.getTime(i + 1);
         }
      }
      
      this.timeTo = newTime;
   }
}
