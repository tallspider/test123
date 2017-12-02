import java.io.*;

class SubwayBefore{

   Line[] lines;
   
   public SubwayBefore(){
      lines = new Line[4];
   }
   
   public void ImportFrom(String fileName){
   
      for (int i = 0 ; i < lines.length ; i++){
         lines[i] = new Line();
         lines[i].ImportFrom(fileName + (i+1) + ".txt");
      }
   }
  
   public Stop before(int line, int from, int to){
      return lines[line].before(from,to);
   }
   
   public String toString(){
   
      String out = "";
      
      for (int i = 0 ; i < lines.length ; i++){
         out += lines[i];
      }
      
      return out;
   }
}

class Line{

   Stop[] stops;
   String name;
   int lineNum;
   
   public Line(){
   
   }

   public void ImportFrom(String fileName){
   
      try{
      
         BufferedReader in = new BufferedReader(new FileReader(fileName));
         
         int numStop = Integer.parseInt(in.readLine());
         this.name = in.readLine();
         int lineNum = Integer.parseInt(in.readLine());
         
         this.stops = new Stop[numStop];
         
         for (int i = 0 ; i < numStop ; i++){
            stops[i] = new Stop(in.readLine().split(" ")[0]);
         }
      }
      catch(IOException iox){
      System.out.println("ERRRRROR");
      }
   }
   
   public Stop before(int from, int to){
   
      if (from > to){
         return stops[to + 1];
      }
      else {
         return stops[to - 1];
      }
   }
   
   public String toString(){
   
      String out = "";
   
      out += this.name + "\n\n";
   
      for (int i = 0 ; i < stops.length; i ++){
         out += stops[i] + "\n";
      }
      return out;
   }
}

class Stop{

   String name;

   public Stop(String name){
      this.name = name;
   }
   
   public String toString(){
      return name;
   }
}