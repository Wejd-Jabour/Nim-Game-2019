import java.util.Scanner;

class NIM
{
	static int stickPile1;
	static int stickPile2;
	static int stickPile3;
	static int stickPile4;
	
	static String player1;
	static String player2;
	
	static int player1Score = 0;
	static int player2Score = 0;
	
	static int playerPile;
	static int playerTake;
	
	static Scanner in = new Scanner(System.in);
	
	static int turn = 1;
		
	static int retry = 1;	
			
	public static void main(String[] args)
	{
		
		playerNames();
	
		pileRandom();
		
		scroll();
		
		
		while (retry == 1)
		{
			player1Pile();
			
			player1Takes();
			
			pileCheck();
			
			retry();
			
			player2Pile();
			
			player2Takes();
			
			pileCheck();
			
			retry();
			
		}
		
		
	}
	
	//Stores the players names
	
	public static void playerNames()
	{
		System.out.print("Player 1 what is your name? \t");
		player1 = in.next();
		
		System.out.print("Player 2 what is your name? \t");
		player2 = in.next();
		
	}
	
	//Generates random number of sticks for each pile
	
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
	
	//Player 1's turn
	
	public static void player1Pile()
	{
		boolean valid = false;
		while(valid = false)
		{
			numOfSticks();
			
			System.out.println(player1 + " Which pile would you like to take from?");
			playerPile = in.nextInt();
			
			if (playerPile == 1 && stickPile1 == 0)
			{
				scroll();
				System.out.println("INVALID ENTRY, TRY AGAIN");
			}
			else if (playerPile == 2 && stickPile2 == 0)
			{
				scroll();
				System.out.println("INVALID ENTRY, TRY AGAIN");
			}
			else if (playerPile == 3 && stickPile3 == 0)
			{
				scroll();
				System.out.println("INVALID ENTRY, TRY AGAIN");
			}
			else if (playerPile == 4 && stickPile4 == 0)
			{
				scroll();
				System.out.println("INVALID ENTRY, TRY AGAIN");
			}
			else if (playerPile < 1 || playerPile > 4)
			{
				scroll();
				System.out.println("INVALID ENTRY, TRY AGAIN");
			}
			else
			{
				valid = true;
			}
		}
	}
	
	public static void player1Takes()
	{
		boolean valid = false;
		while( valid = false)
		{
			System.out.println("How many sticks, 1 - 3, do you want to take from pile" + playerPile);
			int playerTake = in.nextInt();
			
			if(playerTake < 1 || playerTake > 3)
			{
				scroll();
				System.out.println("INVALID ENTRY, TRY AGAIN");
			}
			else if (playerPile == 1 && playerTake > stickPile1)
			{
				scroll();
				System.out.println("INVALID ENTRY, TRY AGAIN");
			}
			else if (playerPile == 1)
			{
				stickPile1 = stickPile1 - playerTake;
				valid = true;
			}
			else if (playerPile == 2 && playerTake > stickPile2)
			{
				scroll();
				System.out.println("INVALID ENTRY, TRY AGAIN");
			}
			else if (playerPile == 2)
			{
				stickPile2 = stickPile2 - playerTake;
				valid = true;
			}
			else if (playerPile == 3 && playerTake > stickPile3)
			{
				scroll();
				System.out.println("INVALID ENTRY, TRY AGAIN");
			}
			else if (playerPile == 3)
			{
				stickPile3 = stickPile3 - playerTake;
				valid = true;
			}
			else if (playerPile == 4 && playerTake > stickPile4)
			{
				scroll();
				System.out.println("INVALID ENTRY, TRY AGAIN");
			}
			else if (playerPile == 4)
			{
				stickPile4 = stickPile4 - playerTake;
				valid = true;
			}
		}
		
		turn++;
		
		scroll();
	}
	
	public static void player2Pile()
	{
		boolean valid = false;
		while(valid = false)
		{
			numOfSticks();
			
			System.out.println(player2 + " Which pile would you like to take from?");
			playerPile = in.nextInt();
			
			if (playerPile == 1 && playerPile > stickPile1 )
			{
				scroll();
				System.out.println("INVALID ENTRY, TRY AGAIN");
			}
			else if (playerPile == 2 && playerPile > stickPile2)
			{
				scroll();
				System.out.println("INVALID ENTRY, TRY AGAIN");
			}
			else if (playerPile == 3 && playerPile > stickPile3)
			{
				scroll();
				System.out.println("INVALID ENTRY, TRY AGAIN");
			}
			else if (playerPile == 4 && playerPile > stickPile4)
			{
				scroll();
				System.out.println("INVALID ENTRY, TRY AGAIN");
			}
			else if (playerPile < 1 || playerPile > 4)
			{
				scroll();
				System.out.println("INVALID ENTRY, TRY AGAIN");
			}
			else
			{
				valid = true;
			}
		}
	}
	
	public static void player2Takes()
	{
		boolean valid = false;
		while( valid = false)
		{
			System.out.println("How many sticks, 1 - 3, do you want to take from pile" + playerPile);
			int playerTake = in.nextInt();
			
			if(playerTake < 1 || playerTake > 3)
			{
				scroll();
				System.out.println("INVALID ENTRY, TRY AGAIN");
			}
			else if (playerPile == 1 && playerTake > stickPile1)
			{
				scroll();
				System.out.println("INVALID ENTRY, TRY AGAIN");
			}
			else if (playerPile == 1)
			{
				stickPile1 = stickPile1 - playerTake;
				valid = true;
			}
			else if (playerPile == 2 && playerTake > stickPile2)
			{
				scroll();
				System.out.println("INVALID ENTRY, TRY AGAIN");
			}
			else if (playerPile == 2)
			{
				stickPile2 = stickPile2 - playerTake;
				valid = true;
			}
			else if (playerPile == 3 && playerTake > stickPile3)
			{
				scroll();
				System.out.println("INVALID ENTRY, TRY AGAIN");
			}
			else if (playerPile == 3)
			{
				stickPile3 = stickPile3 - playerTake;
				valid = true;
			}
			else if (playerPile == 4 && playerTake > stickPile4)
			{
				scroll();
				System.out.println("INVALID ENTRY, TRY AGAIN");
			}
			else if (playerPile == 4)
			{
				stickPile4 = stickPile4 - playerTake;
				valid = true;
			}
		}
		
		turn++;
		
		scroll();
	}
	
	
	
	public static void pileCheck()
	{
		if(stickPile1  == 0 && stickPile2  == 0 && stickPile3  == 0 && stickPile4  == 0 && turn == 1)
		{
			System.out.println("Congratulations " + player1 + " you win!!!");
			player1Score++;
		}
		
		else if(stickPile1  == 0 && stickPile2  == 0 && stickPile3  == 0 && stickPile4  == 0 && turn == 2)
		{
			System.out.println("Congratulations " + player2 + " you win!!!");
			player2Score++;
		}
	}
	
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
			else
			{
				System.out.println("THE FINAL SCORE IS:");
				System.out.println(player1 + ": " + player1Score);
				System.out.println(player2 + ": " + player2Score);
			}
		}
	}	
	
	
	
	
	
	
	public static void scroll()
	{
		for(int i = 0; i < 60; i++)
		{
			System.out.println();
		}
	}
}

