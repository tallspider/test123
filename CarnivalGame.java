abstract class CarnivalGame{
   protected GameConfig config;
}

abstract class GameConfig{
   
}

class Balloons extends CarnivalGame{
   public Balloons(){
      config = new BalloonsConfig();
   }
}

class BalloonsConfig extends GameConfig{
   
}