/*	Author: Jordan Wu
 * 	Date: 12/15/2014
 */

package pokemon;
import java.util.Random;
import java.util.Scanner;

public class GameApp {
	static final int MAX_ATTACK_MOVES = 4;
	static String myPokemon, opponentPokemon;
	static int pokemonChoice, battleOption, selectedMove, myHpBar, opponentHpBar;
	static int[] maxHP = new int[2];
	static int[] currentHP = new int[2];
	static int[] myMovesDamage = new int[MAX_ATTACK_MOVES];
	static int[] opponentMovesDamage = new int[MAX_ATTACK_MOVES];
	static String[] myPokemonAttackMove = new String[MAX_ATTACK_MOVES];
	static String[] opponentPokemonAttackMove = new String[MAX_ATTACK_MOVES];
	//Pokemon Arrays Name/Moves
   static String[] pokemonsName = {"Pikachu","Charmander","Bulbasaur", "Squirtle"};
	static String[] pikachuMoves = {"Thunder","Thunder Shock", "Discharge", "Tackle"};
	static String[] squirtleMoves = {"Water Gun","Bite", "Hydro Pump", "Tackle"};
	static String[] charmanderMoves = {"Ember","Dragon Rage", "Flamethrower", "Scratch"};
	static String[] bulbasaurMoves = {"Take Down","Vine Whip", "Razor Leaf", "Tackle"};
	static Random rand = new Random();
	static Scanner input = new Scanner(System.in);
   static String myType = "";
   static char hearts = '\u2665';//for amount of life
   static char mTHearts = '\u2661';//for loss of life

	public static void main(String[] args) {
      try {
		
		   //Runs entire game from here
         System.out.println("      POKEMON JAVA VERSION");
         System.out.println();
         System.out.println("_____________ * * ______________");
         System.out.println("____________*--O--*_____________");
         System.out.println("              * *");
         System.out.println();
         System.out.println("Welcome to the world of Pokemon.");
		   Thread.sleep(1000);
         gameMenu(); //this method is located at line 45
      }
      catch(Exception e) { 
         System.out.println("An error occured.");
      }  
	}
   
   //Starts the game with Menu
	private static void gameMenu() {
      try {
	      System.out.println("Choose your pokemon!");
	   	System.out.println("1 .. Pikachu");
	   	System.out.println("2 .. Charmander");
	   	System.out.println("3 .. Bulbasaur");
	   	System.out.println("4 .. Squirtle");
	   	System.out.println("0 .. End game");
	   	System.out.print("Your choice: ");
	   	pokemonChoice = input.nextInt();
	   	
         if(pokemonChoice == 0) {
            System.out.println("Thank you for playing Pokemon Java Version. We hope to see you soon.");
	   		System.exit(0);
	      }
	   		//Method located at line 394 (Checks if choices are between 0-4)
         else if(isThisPokemonValid(pokemonChoice) == false) {
			   System.out.println("Invalid pokemon please try again.");   
			   gameMenu();
			}
	      else {
   			getPokemon();// this method is located at line 84
            System.out.println();
            System.out.printf("You chose %s, the %s pokemon.%n", myPokemon, myType);
            Thread.sleep(1000);
            System.out.println();
   			System.out.printf("A wild %s appeared!%n", opponentPokemon);
            Thread.sleep(1000);
   			System.out.printf("%nGo! %s!%n", myPokemon);
            Thread.sleep(1000);
   			battleMode(); //this method is located at line 133
	      }
      }
      catch(Exception e) {
         System.out.println("An error occured.");
      }
	}
   
	//GetPokemon for both players
	private static void getPokemon() {
	   myPokemon = pokemonsName[pokemonChoice-1];
		opponentPokemon = pokemonsName[rand.nextInt(4)];
      
		switch(pokemonChoice){
         case 1: myType = Pikachu.getType();
            break;
         case 2: myType = Charmander.getType();
            break;
         case 3: myType = Bulbasaur.getType();
            break;
         case 4: myType = Squirtle.getType();
            break;   
      }
      
      //Method getHP is located at line 110
      getHp(opponentPokemon,maxHP, currentHP, 0);
		getHp(myPokemon,maxHP,currentHP, 1);
		//Method PokemonMoves is located at line 306
      getPokemonMoves(myPokemon, myPokemonAttackMove, myMovesDamage);
		getPokemonMoves(opponentPokemon, opponentPokemonAttackMove, opponentMovesDamage);
	}
   
   //Gets the correct pokemon Max/Min HP (0 opponent, 1 = myPokemon)
	private static void getHp(String s, int[] a,int[] b, int n) {
		
		if (s == pokemonsName[0]) {
			a[n] = Pikachu.hp;
			b[n] = Pikachu.hp;
		}
      
      else if (s == pokemonsName[1]) {
			a[n] = Charmander.hp;
			b[n] = Charmander.hp;
		}
      
       else if (s == pokemonsName[2]) {
			a[n] = Bulbasaur.hp;
			b[n] = Bulbasaur.hp;
		}
       else {
			a[n] = Squirtle.hp;
			b[n] = Squirtle.hp;
		}
	}
   
	private static void battleMode() {
      System.out.println("_____________________________");
  		System.out.println("         Battle Mode         ");
		System.out.println("_____________________________");
		display(); //method display is located at line 142
		battleOptions();//method battleOptions is located at line 156
	}
	
	private static void display() {
		
		System.out.print("               ");
      opponentPokemonName(opponentPokemon);
      System.out.print("         ");
		opponentHpBar(); //located at line 284
      System.out.print("                    ");
		System.out.printf("%s / %s%n", currentHP[0], maxHP[0]);
		myPokemonName(myPokemon);
		myHpBar();// located at line 263
		System.out.printf("%s / %s%n", currentHP[1], maxHP[1]);
      System.out.println();
	}

	private static void battleOptions() {

		System.out.println("                    1 . FIGHT");
	   System.out.println("                    2 .. ITEM");
	   System.out.println("                    3 .. PKMN");
	   System.out.println("                    4 ... RUN");
	   System.out.print("Your choice: ");
	   battleOption = input.nextInt();
	   
      if(isThisValidBattleOption(battleOption) == false) {
	      System.out.println("Invaild option please try again");
	   	battleOptions();
	   }
	   else{
	      options(battleOption);
	   }
	   		
	}

	private static void options(int battleOption) {
		// TODO Auto-generated method stub
      switch(battleOption){
         case 1: 
            fight();
            break;
         case 2: 
            items();
            break;
         case 3: 
            pkmn();
            break;
         case 4: 
            run();
            break;
        default: System.out.println("Invalid input.");
     }
	}

	private static void fight() {
		// TODO Auto-generated method stub
		System.out.println("Attack Moves");
		System.out.println("------------");
		showMyPokemonMoves();
		selectPokemonMoves();
	}
     
	private static void selectPokemonMoves() {
      try {
         System.out.print("Your choice: ");
   		selectedMove = input.nextInt();
   		if (selectedMove < 5 && selectedMove >0) {
   			System.out.printf("%s used %s!%n", myPokemon, myPokemonAttackMove[selectedMove-1] );
   			calculate(myMovesDamage,selectedMove-1,currentHP,0);
   			selectedMove = rand.nextInt(4);
            Thread.sleep(1000);
   			System.out.printf("Enemy %s used %s!%n",opponentPokemon,opponentPokemonAttackMove[selectedMove]);
   			Thread.sleep(1000);
            calculate(opponentMovesDamage,selectedMove,currentHP,1);
   			battleMode();
   		} 
         else {
   			System.out.println("Invalid move please try again");
   			showMyPokemonMoves();
            selectPokemonMoves();
   		}
   	}
      catch(Exception e) {
        System.out.println("An error occured.");
      }  
   }

	private static void calculate(int[] a,int n1, int[] b, int n2) {
		// TODO Auto-generated method stub
		if(b[n2] - a[n1] < 0) {
			b[n2] = 0;
			checkWhoWon();
		}
      else {
			b[n2] = b[n2] - a[n1];
		}
	}
   
	private static void checkWhoWon() {
		// TODO Auto-generated method stub
		display();
		if(currentHP[0] == 0) {
			System.out.printf("Enemy %s fainted!%n", opponentPokemon);
			System.out.printf("%s has gained %d EXP Points!", myPokemon, rand.nextInt(455)+13);
         
		}
      else {
			System.out.printf("Your %s fainted!%n", myPokemon);
			System.out.println("You are out of usable pokemon.");
			System.out.println("You blacked out.");
		}
      System.out.println();
      System.out.println();
		gameMenu();
	}
   
	private static void showMyPokemonMoves() {
		for(int i = 0; i < 4; i++) {
		System.out.printf("%s %s%n", i + 1, myPokemonAttackMove[i]);
		}
	}

	private static void myHpBar() {
		// TODO Auto-generated method stub
	   System.out.print("hp: ");
		myHpBar = (int)currentHP[1] * 10 / maxHP[1];
		for(int i = 0; i < myHpBar; i++) {
			System.out.print(hearts);
		}
		if(myHpBar == 0) {
			System.out.print(hearts);
		}
		for(int j = 0; j < 10 - myHpBar;j++){
			System.out.printf("%c", mTHearts);
		}
		System.out.println();
	}
   
	private static void myPokemonName(String s) {
		// TODO Auto-generated method stub
		System.out.printf("%s%n", myPokemon);
	}

	private static void opponentHpBar() {
		// TODO Auto-generated method stub
		System.out.print("hp: ");
		opponentHpBar = (int)currentHP[0]*10/maxHP[0];
		for(int i = 0; i < opponentHpBar; i++) {
			System.out.printf("%c", hearts);
		}
		if(opponentHpBar == 0) {
			System.out.printf("%c", hearts);
		}
		for(int j = 0; j < 10 - opponentHpBar;j++) {
			System.out.printf("%c", mTHearts);
		}
      
		System.out.println();
	}

	private static void opponentPokemonName(String s) {
		// TODO Auto-generated method stub
		System.out.printf("%14s%n", opponentPokemon);
	}
   
   //Get (Pokemon, PokemonAttackMove, MovesDamage)
	private static void getPokemonMoves(String s, String[] a, int[] b) {
		
		if (s == pokemonsName[0]) {
			pikachuMoves(a,b);
		}
      else if (s == pokemonsName[1]) {
			charmanderMoves(a,b);
		} 
      else if (s == pokemonsName[2]) {
			bulbasaurMoves(a,b);
		} 
      else {
			squirtleMoves(a,b);
		}
	}
   
   //Squirtles Moves
	private static void squirtleMoves(String[] a, int[] b) {
		
		for(int i = 0; i < 4; i++) {
			a[i] = squirtleMoves[i];
		}
		b[0] = Squirtle.waterGun;
		b[1] = Squirtle.bite;
		b[2] = Squirtle.hydroPump;
		b[3] = Squirtle.tackle;
	}

	private static void bulbasaurMoves(String[] a, int[] b) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 4; i++) {
			a[i] = bulbasaurMoves[i];
		}
		b[0] = Bulbasaur.takeDown;
		b[1] = Bulbasaur.vineWhip;
		b[2] = Bulbasaur.razorLeaf;
		b[3] = Bulbasaur.tackle;
	}

	private static void charmanderMoves(String[] a, int[] b) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 4; i++) {
			a[i] = charmanderMoves[i];
		}
		b[0] = Charmander.ember;
		b[1] = Charmander.dragonRage;
		b[2] = Charmander.flamethrower;
		b[3] = Charmander.scratch;
	}

	private static void pikachuMoves(String[] a, int[] b) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 4; i++) {
			a[i] = pikachuMoves[i];
		}
		b[0] = Pikachu.thunder;
		b[1] = Pikachu.thunderShock;
		b[2] = Pikachu.discharge;
		b[3] = Pikachu.tackle;
	}
   
   //No items
	private static void items() {
		// TODO Auto-generated method stub
		System.out.println("Inventory is currently empty");
		battleOptions();
	}

	private static void pkmn() {
		// TODO Auto-generated method stub
		System.out.println("You do not have any other pokemon");
		battleOptions();
	}

	private static void run() {
		// TODO Auto-generated method stub
		System.out.println("Got away safely!");
      gameMenu();
	}

	private static boolean isThisValidBattleOption(int BattleOption) {
		// TODO Auto-generated method stub
		if(battleOption < 5 && battleOption > 0) {
			return true;
		}
      else
		   return false;
	}

	private static boolean isThisPokemonValid(int choice) {
		   if (choice < 5 && choice >= 0) {
			   return true;
		   }
		   else {
			   return false;
		   }
	}
	}
