package pokemon;
import java.util.Random;

public class Bulbasaur {
   static Random rand = new Random();
	static int hp = 520;
   private static String type = "grass";
	static int takeDown = rand.nextInt(80) + 10;
	static int vineWhip = rand.nextInt(50) + 25;
	static int razorLeaf = rand.nextInt(100) + 1;
	static int tackle = rand.nextInt(20) + 40;   
     
   public static String getType(){
      return type;
   }
}