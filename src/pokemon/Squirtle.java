package pokemon;
import java.util.Random;

public class Squirtle {
   static Random rand = new Random();
   static int hp = 565;
   private static String type = "water";
   static int waterGun = rand.nextInt(80) + 10;
   static int bite = rand.nextInt(50) + 25;
   static int hydroPump = rand.nextInt(100) + 1;
   static int tackle = rand.nextInt(20) + 40;   
     
   public static String getType(){
      return type;
   }
}