package pokemon;
import java.util.Random;

public class Pikachu {
   static Random rand = new Random();
   static int hp = 500;
   private static String type = "electric";
   static int thunder = rand.nextInt(100) + 25;
   static int thunderShock = rand.nextInt(80) + 10;
   static int discharge = rand.nextInt(100) + 1;
   static int tackle = rand.nextInt(20) + 40;
   
   public static String getType() {
      return type;
   }
}	