package pokemon;
import java.util.Random;

public class Charmander {
   static Random rand = new Random();
   static int hp = 565;
   private static String type = "fire";
	static int ember = rand.nextInt(80) + 10;
   static int dragonRage = rand.nextInt(50) + 25;
	static int flamethrower = rand.nextInt(100) + 1;
   static int scratch = rand.nextInt(20) + 40;
   
   public static String getType(){
      return type;
   }
}