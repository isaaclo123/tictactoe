import java.util.Scanner;

public class tictactoe {
	
	public static String character = "O";
	
	public static Boolean game = false;
	
	public static String[] array = new String[9];
	
	public static int line;
	
	public static int stalemate;
	
	public static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) throws InterruptedException {
		
		for (int i = 0; i <= 8; i++) {
			
			array[i] = Integer.toString(i);
			
		}
		
		while (game == false) {
			
			print();
			System.out.println("It is " + character + "'s turn:");
			line = in.nextInt();
			
			if (array[line] != "O" && array[line] != "X") {
				
				array[line] = character;
				stalemate = stalemate + 1;
				checkwin();
				
				if (game == false){
					
					if (character.equals("O")) {
						
						character = "X";
						
				}
				
				else if (character.equals("X")) {
						
						character = "O";
						
				}
				
			}
			else {
				
				System.out.println("Invalid input. Please try again.");
				line = in.nextInt();
				
			}
			
			
		}
			
		}
		
		print();
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.print(character + " has won" + "\n\n");
		System.exit(1);
		
	}
	
	public static void checkwin(){
		
		for (int i = 0; i <= 6; i = i + 3) {
			
			if ((array[i] + array[i + 1] + array[i + 2]).equals(character + character + character)) {
			
				game = true;
				
			}
		}
		
		for (int i = 0; i <= 2; i++) {
			
			if ((array[i] + array[i + 3] + array[i + 6]).equals(character + character + character)) {
			
				game = true;
				
			}
		}
		
		if ((array[0] + array[4] + array[8]).equals(character + character + character)) {
			
			game = true;
			
		}
		
		if ((array[2] + array[4] + array[6]).equals(character + character + character)) {
			
			game = true;
			
		}
		
			
		if (stalemate == 9 && game == false) {
				
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.print("stalemate" + "\n\n");
			System.exit(1);
			
		}
		
	}
	
	public static void print(){
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
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
	
	
}


