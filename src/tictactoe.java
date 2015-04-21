import java.util.Random;
import java.util.Scanner;

public class tictactoe {
	
	public static String character;
	
	public static String player;
	
	public static Boolean game = false;
	
	public static String playernumber;
	
	public static String[] array = new String[9];
	
	public static int line;
	
	public static String bot;
	
	public static String input;
	
	public static int counter = 0;
	
	public static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) throws InterruptedException {
		
		//prints title
		
		System.out.println("TIC-TAC-TOE");
		System.out.println("Copyright Isaac Lo 2015");
		System.out.println("Press any key to continue...");
		in.nextLine();
		clear();
		game();
		
		
		
	}
	
	public static void game() {
		
		//resets variables
		
		//resets error management boolean
		
		boolean playervalid = false;
		game = false;
		counter = 0;
		
		
		// initializes the tic-tac-toe array with values from 0 to 8
		
				initializearray();
				
				//clears screen
				
				clear();
				
				//prompts for number of players
				
				System.out.println("Input the number of players (1/2)");
				playernumber = in.nextLine();
			
				//while loop is terminated on correct input
				
				playervalid = false;
				
				while (playervalid == false) {
				
				if (playernumber.equals("1")) {
					

					System.out.println("Would you like to start? (y/n)");
					input = in.nextLine();
					
						//if player would like to start, the player variable is set to "O"
					
						if (input.equals("y")) {
							
							player = "O";
							bot = "X";
							character = player; 
							playervalid = true;
							
						}
						
						//if the player would not like to start, the bot variable is set to "X"
						
						else if (input.equals("n")) {
							
							player = "X";
							bot = "O";
							character = bot;
							playervalid = true;
							
						}
						
						//error management
						
						else {
							
							System.out.println("Invalid input. Please try again. (y/n)");
							input = in.nextLine();
							
						}
			
				}
				
				//if it's a two player game, the character "O" goes first
				
					else if (playernumber.equals("2")){
							
							character = "O";
							playervalid = true;
							
						}
				
				// error management
				
						else {
							
							System.out.println("Invalid input. Please try again. (1/2)");
							playernumber = in.nextLine();
							
						}
						
				}
				
				
				//while the game is still going (false) (uses a while loop)
				
				while (game == false) {
			
				//
					
				if (playernumber.equals("1")) {
					
				//if the character variable is the player, then it prompts for input, otherwise the bot code inputs
								
				if (player.equals(character)) {
					
					print();
					System.out.println("It is " + player + "'s turn: (0-8)");
					playerinput();
				
				}
				
				//bot
				
				else if (bot.equals(character)) {
					
					bot();
					
				}
				
				}
				
				else if (playernumber.equals("2")) {
					
					print();
					System.out.println("It is " + character + "'s turn: (0-8)");
					playerinput();
					
				}
				
				//
				
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
					
				}
					
				}
				
				//if the while(game == true) loop is broken, someone has won, and it displays the winner"
				
				print();
				System.out.print("\n\n" + character + " has won" + "\n\n");
				continueorexit();
		
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
		
		//if the game counter reaches 9, then in means a stalemate has occoured, and noone wins. the game displays "stalemate" and exits the program
			
		if (counter == 9 && game == false) {
			
			print();
			System.out.print("\n\n" + "stalemate" + "\n\n");
			continueorexit();
			
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
		
			String[] playerwin = {(" " + player + player), (player + " " + player), (player + player + " ")};
					
			//initializes random number generator
			
			Random randomGenerator = new Random();
			
			//the bot first generates a random number. it can be overwritten later
			
			line = randomGenerator.nextInt(8);
		
			//if the bot goes first, it will always choose the center grid, the 5th grid
			
			if (counter == 0 && bot.equals("O")) {
				
				line = 4;
				
			}
	
			//now checks for any potential wins by the player
			
			else {
				
				//horizontal rows check
									
				for (int i = 0; i <= 2; i++) {
					
					for (int x = 0; x <= 2; x++) {
						
						if ((array[i] + array[i + 3] + array[i + 6]).equals(playerwin[x])) {
							
							line = i + (3 * x);
							
						}
						
					}
					
				}
				
				//vertical rows check
				
				for (int i = 0; i <= 6; i = i + 3) {
					
					for (int x = 0; x <= 2; x++) {
						
						if ((array[i] + array[i + 1] + array[i + 2]).equals(playerwin[x])) {
							
							line = i + x;
							
						}
						
					}
					
				}
					
			}
			
	//	}
		
	}
	
	//initializes the array from 0 to 8
	
	public static void initializearray() {
		
		for (int i = 0; i <= 8; i++) {
			
			array[i] = Integer.toString(i);
			
		}
		
	}
	
	//prompts user if they want to continue playing or exit
	
	public static void continueorexit() {
		
		//creates another error management boolean
		
		Boolean continuevalid = false;
		
		System.out.println("\n" + "Would you like to continue? (y/n)");
		input = in.nextLine();
		
		while (continuevalid == false) {
			
			if (input.equals("y")) {
				
				game();
				continuevalid = true;
				
			}
			else if (input.equals("n")) {
				
				//exit
				System.exit(1);
				
			}
			else {
				System.out.println("\n" + "Invalid input. Would you like to continue? (y/n)");
				input = in.nextLine();
			}
			
		}
		
		continuevalid = false;
		
	}
	
	public static void playerinput() {
		
		//makes new error management boolean "valid"
		
		Boolean inputvalid = false;
		
		while (inputvalid == false) {
			
			input = in.nextLine();
			
		//error management
		
		try {
			line = Math.round(Integer.parseInt(input));
			inputvalid = true;
		}
		catch (java.lang.NumberFormatException line) {
			System.out.println("Invalid input. Please try again. (0-8)");
		}
		
		//makes sure the number entered can be put into the array, and if it's even an integer
		
		if (line < 0 || line > 8) {
			
			inputvalid = false;
			System.out.println("Invalid input. Please try again. (0-8)");
			line = Integer.parseInt(input);
		}
		
		}
		
		//resets error management boolean
		
		inputvalid = false;
		
	}
	
	//clears the screen by printing out whitespace
	
	public static void clear(){
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		
	}
	
	
}