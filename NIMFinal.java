/**This program is a two player game called NIM in which players 
 * take turns picking up sticks.  The game begins with various 
 * numbers of sticks in 4 piles.  On any turn, a player must choose
 * a pile and remove one ormore sticks from that pile (up to 3).  
 * The object of the game is to force your opponent to pick up the 
 * last stick in the last pile.
 * 
 * @author W. Jabour
 */
 
 
import java.util.Scanner;

class NIMFinal
{
	//These are for storing the number of sticks in the piles
	static int stickPile1;
	static int stickPile2;
	static int stickPile3;
	static int stickPile4;
	
	//This is for storing the players names
	static String p1;
	static String p2;
	
	//This is to keep track of the score and the amount of times each player wins
	static int p1Score = 0;
	static int p2Score = 0;
	
	//This is used to store the pile the player wants to take the sticks from
	static int p1pile;
	static int p2pile;
	
	//This is used to keep track of whose turn it is
	static int turn = 1;
	
	//This is used to restart the game
	static int retry = 1;	
	
	//This allows the use of user input in every method
	static Scanner in = new Scanner(System.in);
		
	public static void main(String[] args)
	{
		
		playerNames();
	
		pileRandom();
		
		scroll();
		
		
		while (retry == 1)
		{
			player1Turn();
				
			retry();
			
			if(retry == 1)
			{
				player2Turn();			
				
				retry();
			}
		}
		
		
	}
		
	//Asks players for names and stores them
	
	public static void playerNames()
	{
		System.out.print("Player 1 what is your name? \t");
		p1 = in.next();
		
		System.out.print("Player 2 what is your name? \t");
		p2 = in.next();
		
	}
	
	//Generates random number of sticks for each pile from 4 - 5
	
	public static void pileRandom()
	{
		stickPile1 = (int)(Math.random() * 5 + 4);
		stickPile2 = (int)(Math.random() * 5 + 4);
		stickPile3 = (int)(Math.random() * 5 + 4);
		stickPile4 = (int)(Math.random() * 5 + 4);
	}
	
	//Method that displays the current number of sticks in every pile
	
	public static void numOfSticks()
	{
	
		System.out.print("Stick pile 1 has " + stickPile1 + " sticks: \t" );
		for(int i = 0; i < stickPile1; i++)
		{
			System.out.print("|");
		}
		System.out.println();
		
		
		System.out.print("Stick pile 2 has " + stickPile2 + " sticks: \t" );
		for(int i = 0; i < stickPile2; i++)
		{
			System.out.print("|");
		}
		System.out.println();
		
		
		System.out.print("Stick pile 3 has " + stickPile3 + " sticks: \t" );
		for(int i = 0; i < stickPile3; i++)
		{
			System.out.print("|");
		}
		System.out.println();
		
		
		System.out.print("Stick pile 4 has " + stickPile4 + " sticks: \t" );
		for(int i = 0; i < stickPile4; i++)
		{
			System.out.print("|");
		}
		System.out.println();
	}
	
	/**Player 1's turn
	 * First it asks the player to choose a pile, then the computer checks to see if it is a valid answer
	 * Then, it asks the player for how many sticks they would like to take, then the computer checks to 
	 * see if it is a valid answer
	 * Finally, it checks to see if the game is lost
	 */
	
	public static void player1Turn()
	{
		int correctPile = 1;
		int correctSticks = 1;
		
		while(correctPile == 1 || correctSticks == 1)
		{
			numOfSticks();
			
			System.out.println(p1 + " Which pile would you like to take from?");
			p1pile = in.nextInt();
			
			if (p1pile == 1 && stickPile1 == 0)
			{
				scroll();
				System.out.println("INVALID ENTRY, TRY AGAIN");
			}
			else if (p1pile == 2 && stickPile2 == 0)
			{
				scroll();
				System.out.println("INVALID ENTRY, TRY AGAIN");
			}
			else if (p1pile == 3 && stickPile3 == 0)
			{
				scroll();
				System.out.println("INVALID ENTRY, TRY AGAIN");
			}
			else if (p1pile == 4 && stickPile4 == 0)
			{
				scroll();
				System.out.println("INVALID ENTRY, TRY AGAIN");
			}
			else if (p1pile < 1 || p1pile > 4)
			{
				scroll();
				System.out.println("INVALID ENTRY, TRY AGAIN");
			}
			else
			{
				correctPile++;
			}
			
			if(correctPile == 2)
			{
				System.out.println("How many sticks, 1 - 3, do you want to take from " + p1pile);
				int p1take = in.nextInt();
				
				if(p1take < 1 || p1take > 3)
				{
					scroll();
					System.out.println("INVALID ENTRY, TRY AGAIN");
					correctPile--;
				}
				else if (p1pile == 1 && p1take > stickPile1)
				{
					scroll();
					System.out.println("INVALID ENTRY, TRY AGAIN");
					correctPile--;
				}
				else if (p1pile == 1)
				{
					stickPile1 = stickPile1 - p1take;
					correctSticks++;
				}
				else if (p1pile == 2 && p1take > stickPile2)
				{
					scroll();
					System.out.println("INVALID ENTRY, TRY AGAIN");
					correctPile--;
				}
				else if (p1pile == 2)
				{
					stickPile2 = stickPile2 - p1take;
					correctSticks++;
				}
				else if (p1pile == 3 && p1take > stickPile3)
				{
					scroll();
					System.out.println("INVALID ENTRY, TRY AGAIN");
					correctPile--;
				}
				else if (p1pile == 3)
				{
					stickPile3 = stickPile3 - p1take;
					correctSticks++;
				}
				else if (p1pile == 4 && p1take > stickPile4)
				{
					scroll();
					System.out.println("INVALID ENTRY, TRY AGAIN");
					correctPile--;
				}
				else if (p1pile == 4)
				{
					stickPile4 = stickPile4 - p1take;
					correctSticks++;
				}
				
			}
		}
				
				
		
		
		turn++;
		
		scroll();
		
		if(stickPile1  == 0 && stickPile2  == 0 && stickPile3  == 0 && stickPile4  == 0 && turn == 2)
		{
			System.out.println("Congratulations " + p2 + " you win!!!");
			p2Score++;
			System.out.println("THE CURRENT SCORE IS ");
			System.out.println(p1 + ": " + p1Score);
			System.out.println(p2 + ": " + p2Score);
			System.out.println();
		}	
	}
	
	/**Player 2's turn
	 * First it asks the player to choose a pile, then the computer checks to see if it is a valid answer
	 * Then, it asks the player for how many sticks they would like to take, then the computer checks to 
	 * see if it is a valid answer
	 * Finally, it checks to see if the game is lost
	 */
	
	public static void player2Turn()
	{
		int correctPile = 1;
		int correctSticks = 1;
		
		while(correctPile == 1 || correctSticks == 1)
		{
			numOfSticks();
			
			System.out.println(p2 + " Which pile would you like to take from?");
			p2pile = in.nextInt();
			
			if (p2pile == 1 && stickPile1 == 0)
			{
				scroll();
				System.out.println("INVALID ENTRY, TRY AGAIN");
			}
			else if (p2pile == 2 && stickPile2 == 0)
			{
				scroll();
				System.out.println("INVALID ENTRY, TRY AGAIN");
			}
			else if (p2pile == 3 && stickPile3 == 0)
			{
				scroll();
				System.out.println("INVALID ENTRY, TRY AGAIN");
			}
			else if (p2pile == 4 && stickPile4 == 0)
			{
				scroll();
				System.out.println("INVALID ENTRY, TRY AGAIN");
			}
			else if (p2pile < 1 || p2pile > 4)
			{
				scroll();
				System.out.println("INVALID ENTRY, TRY AGAIN");
			}
			else
			{
				correctPile++;
			}
			
			if(correctPile == 2)
			{
				System.out.println("How many sticks, 1 - 3, do you want to take from " + p2pile);
				int p2take = in.nextInt();
				
				if(p2take < 1 || p2take > 3)
				{
					scroll();
					System.out.println("INVALID ENTRY, TRY AGAIN");
					correctPile--;
				}
				else if (p2pile == 1 && p2take > stickPile1)
				{
					scroll();
					System.out.println("INVALID ENTRY, TRY AGAIN");
					correctPile--;
				}
				else if (p2pile == 1)
				{
					stickPile1 = stickPile1 - p2take;
					correctSticks++;
				}
				else if (p2pile == 2 && p2take > stickPile2)
				{
					scroll();
					System.out.println("INVALID ENTRY, TRY AGAIN");
					correctPile--;
				}
				else if (p2pile == 2)
				{
					stickPile2 = stickPile2 - p2take;
					correctSticks++;
				}
				else if (p2pile == 3 && p2take > stickPile3)
				{
					scroll();
					System.out.println("INVALID ENTRY, TRY AGAIN");
					correctPile--;
				}
				else if (p2pile == 3)
				{
					stickPile3 = stickPile3 - p2take;
					correctSticks++;
				}
				else if (p2pile == 4 && p2take > stickPile4)
				{
					scroll();
					System.out.println("INVALID ENTRY, TRY AGAIN");
					correctPile--;
				}
				else if (p2pile == 4)
				{
					stickPile4 = stickPile4 - p2take;
					correctSticks++;
				}
				
			}
		}
				
			
		
		turn--;
		
		scroll();
		
		if(stickPile1  == 0 && stickPile2  == 0 && stickPile3  == 0 && stickPile4  == 0 && turn == 1)
		{
			System.out.println("Congratulations " + p1 + " you win!!!");
			p1Score++;
			System.out.println("THE CURRENT SCORE IS ");
			System.out.println(p1 + ": " + p1Score);
			System.out.println(p2 + ": " + p2Score);
			System.out.println();
		}
		
	}
	
	
	//This method only runs when the game is complete and asks the players if they would like to play again
	
	public static void retry()
	{
		
		if(stickPile1  == 0 && stickPile2  == 0 && stickPile3  == 0 && stickPile4  == 0)
		{
			System.out.println("If you would like to try again press 1, if not press 2");
			retry = in.nextInt();
				
			if(retry == 1)
			{
				pileRandom();
				scroll();
			}
			else if(retry == 2)
			{
				System.out.println("THE END! THE FINAL SCORE IS " + p1Score + " POINTS FOR " + p1 + " AND " + p2Score + " POINTS FOR " + p2);
			}
		}
	}	
	
	
	
	
	
	//This method is used to clear the board after every turn
	public static void scroll()
	{
		for(int i = 0; i < 60; i++)
		{
			System.out.println();
		}
	}
}


