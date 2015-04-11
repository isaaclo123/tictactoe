import java.util.Random;
import java.util.Scanner;

public class tictactoe {
	
	public static String character;
	
	public static String player;
	
	public static Boolean game = false;
	
	public static String[] array = new String[9];
	
	public static int line;
	
	public static String bot;
	
	public static String input;
	
	public static int counter;
	
	public static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) throws InterruptedException {
		
		//initializes keyboard input
		
		Scanner keyboard = new Scanner(System.in);		
		
		//prints title
		
		System.out.println("TIC-TAC-TOE");
		System.out.println("Copyright Isaac Lo 2015");
		keyboard.nextLine();
		clear();
		
		// initializes the tic-tac-toe array with values from 0 to 8
		
		initializearray();
		
		//prompts for number of players
		
		System.out.println("Input the number of players:");
		input = keyboard.nextLine();
		String playernumber = input;
		
		if (input.equals("1")) {
			

			System.out.println("Would you like to start? (y/n)");
			input = keyboard.nextLine();
			
				//if player would like to start, the player variable is set to "O"
			
				if (input.equals("y")) {
					
					player = "O";
					bot = "X";
					character = player; 
					
				}
				
				//if the player would not like to start, the bot variable is set to "X"
				
				else if (input.equals("n")) {
					
					player = "X";
					bot = "O";
					character = bot;
					
				}
				
				//error management
				
				else {
					
					System.out.println("Invalid input. Please try again. (y/n)");
					input = keyboard.nextLine();
					
				}
			
		}
		
		//while the game is still going (false) (uses a while loop)
		
		while (game == false) {
			
		if (playernumber.equals("1")) {
			
		//if the character variable is the player, then it prompts for input
			
		if (character.equals(player)) {
			
			print();
			System.out.println("It is " + character + "'s turn:");
			line = in.nextInt();
			
		}
		
		//otherwise, the character variable runs the bot function
		
		else if (character.equals(bot)) {
		
			bot();
			
		}
		
		}
		
		//otherwise, if it's a two player game
		
		else if (playernumber.equals("2")){
			
			//sets the character to "O"
			
			character = "O";
			
		}
		
			//if the tic-tac-toe grid is not marked
			
			if (array[line] != "O" && array[line] != "X") {
				
				//sets the array grid to the character selected and increases game counter, then checks for win
				
				array[line] = character;
				counter = counter + 1;
				checkwin();
				
				//if the game is still going, then the character switches, allowing for the other player or bot to move
				
				if (game == false){
					
					if (character.equals("O")) {
						
						character = "X";
						
				}
				
				else if (character.equals("X")) {
						
						character = "O";
						
				}
				
			}
				
				//error management
				
			else {
				
				System.out.println("Invalid input. Please try again.");
				line = in.nextInt();
				
			}
			
			
		}
			
		}
		
		//if the while(game == true) loop is broken, someone has won, and it displays the winner"
		
		print();
		System.out.print("\n\n" + character + " has won" + "\n\n");
		System.exit(1);
		
	}
	
	//checks if a win has occoured
	
	public static void checkwin(){
		
		//checks vertical rows for win
		
		for (int i = 0; i <= 6; i = i + 3) {
			
			if ((array[i] + array[i + 1] + array[i + 2]).equals(character + character + character)) {
			
				game = true;
				
			}
		}
		
		//checks horizontal rows for win
		
		for (int i = 0; i <= 2; i++) {
			
			if ((array[i] + array[i + 3] + array[i + 6]).equals(character + character + character)) {
			
				game = true;
				
			}
		}
		
		//checks diagonals for a win
		
		if ((array[0] + array[4] + array[8]).equals(character + character + character)) {
			
			game = true;
			
		}
		
		if ((array[2] + array[4] + array[6]).equals(character + character + character)) {
			
			game = true;
			
		}
		
		//if the game counter reaches 9, then in means a stalemate has occoured, and noone wins. the game displays "stalemate"
			
		if (counter == 9 && game == false) {
				
			System.out.print("\n\n" + "stalemate" + "\n\n");
			System.exit(1);
			
		}
		
	}
	
	//prints out tic-tac-toe grid
	
	public static void print(){
		
		clear();
		System.out.println("   |   |   ");
		System.out.println(" " + array[0] + " | " + array[1] + " | " + array[2] + " ");
		System.out.println("___|___|___");
		System.out.println("   |   |   ");
		System.out.println(" " + array[3] + " | " + array[4] + " | " + array[5] + " ");
		System.out.println("___|___|___");
		System.out.println("   |   |   ");
		System.out.println(" " + array[6] + " | " + array[7] + " | " + array[8] + " ");
		System.out.println("   |   |   " + "\n");
		
	}
	
	//bot code
	
	public static void bot() {
		
			//initializes randome number generator
			
			Random randomGenerator = new Random();
			
			//it the bot goes first, it will always choose the center grid, the 5th grid
			
			if (bot.equals("0") && counter == 0) {
				
				line = 5;
				
			}
			
			//otherwise, the bot will generate random numbers until it fins a non-taken space
			
			else {
				
				while (character.equals(bot)) {
					
					line = randomGenerator.nextInt(8);
					
				}				
				
			}
			

		}
	
	//initializes the array from 0 to 8
	
	public static void initializearray() {
		
		for (int i = 0; i <= 8; i++) {
			
			array[i] = Integer.toString(i);
			
		}
		
	}
	
	//clears the screen by printing out whitespace
	
	public static void clear(){
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		
	}
	
	
}


