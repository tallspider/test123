import java.io.*;

class SubwayLine{

   LineStop[] line;
   
   public SubwayLine(){
   
   }

   public void ImportFrom (String fileName){
   
      try{
      
         int numStops = 0;
      
         BufferedReader t = new BufferedReader(new FileReader (fileName));
         
         while (t.readLine() != null){
            numStops++;
         }
         
         t.close();
         
         BufferedReader in = new BufferedReader(new FileReader (fileName));
         
         this.line = new LineStop[numStops];
         String input;
         String[] data;
         
         for (int i = 0 ; i < numStops; i ++){
            input = in.readLine();
            data = input.split(" ");
            
            line[i] = new LineStop(data[0],Integer.parseInt(data[1]));
         }
         
         in.close();
      }
      catch(IOException iox){
      
      }
   }

   public String toString(){
   
      String out = "";
   
      for (int i = 0 ; i < line.length; i ++){
         out += this.line[i].getName() + " " + this.line[i].getTime() + "\n";
      }
      return out;
   }

}

class LineStop{

   String name;
   int timeToNextStop;
   
   public LineStop(String name, int time){
      this.name = name;
      this.timeToNextStop = time;
   }
   
   public String getName(){
      return this.name;
   }
   
   public int getTime(){
      return this.timeToNextStop;
   }
}