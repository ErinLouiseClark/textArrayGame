import java.util.Scanner;

public class Level2
	{

		static String [][] shopLayout = new String[11][11];
		static int heroX = 1;
		static int heroY = 5;
		static int treasureX = 0;
		static int treasureY = 0;
		static int villianX = 0;
		static int villianY = 0;
		public static void main(String[] args)
			{
				introduction();
			}
	public static void introduction()
	{
		heroX = 1;
		heroY = 5;
		treasureX = 0;
		treasureY = 0;
		villianX = 0;
		villianY = 0;
		Scanner userChoice = new Scanner(System.in);
		System.out.println("Way to go hero! That was sort of impressive. (Not really)");
		System.out.println("That treasure was pretty small, actually just 3 golden coins, but I think you have the hang of it.");
		System.out.println("Let's get to the big guns. I've been watching this much bigger treasure for a while now.");
		System.out.println("Unfortunately, this treasure belongs to a dragon. He will come after you. Use your guile to outsmart him.");
		System.out.println("Are you courageous enough to go after it?");
		System.out.println("(1) Of course I am!");
		System.out.println("(2) A dragon? Are you kidding me. NO!");
		int choice = userChoice.nextInt();
		if (choice == 1)
			{
			System.out.println("I knew that you were the one for the job!");
			generateVillian();
			makeShop();
			addTreasure();
			generateBoard();
			}
		else if  (choice == 2)
			{
			System.out.println("I have misjudged you. Go back to finding mediocre treasure peasant.");
			Level1.introduction();
			}
		else
			{
				System.out.println("I can't hear what your saying, but it sounds like a yes!");
				generateVillian();
				makeShop();
				addTreasure();
				generateBoard();
			}
	}
	public static void makeShop()
	{
		for (int row = 0; row < shopLayout.length; row++)
		{
			for (int col = 0; col < shopLayout[0].length; col++)
				{
					shopLayout[row][col]="   ";
					shopLayout[heroX][heroY] = " H ";
					shopLayout[treasureX][treasureY] = " T ";
					shopLayout[treasureX+1][treasureY] = " # ";
					shopLayout[treasureX][treasureY+1] = " # ";
					shopLayout[villianX][villianY] = " D ";
						if (treasureX >= 1)
							{
								shopLayout[treasureX][treasureY-1] = " # ";
							}
				}
		}
		for (int i = 0; i < shopLayout.length; i++)
			{
				shopLayout[0][i]= " # ";
				shopLayout[i][0]= " # ";
				shopLayout[10][i] = " # ";
				shopLayout[i][10] = " # ";
			}
	}
	public static void addTreasure()
	{
		treasureX = (int)(Math.random()*3)+6;
		treasureY = (int)(Math.random()*9);
		boolean goodSpace = false;
		if(shopLayout[treasureX][treasureY].equals("   "))
			{
				goodSpace = true;
			}
		
		if (goodSpace)
			{
				shopLayout[treasureX][treasureY] = " T ";
			}
		else
			{
				addTreasure();
			}
	}
	public static void generateVillian()
	{
		villianX = (int)(Math.random()*3)+6;
		villianY = (int)(Math.random()*9);
		shopLayout[villianX][villianY] = " D ";

	}
	public static void generateBoard()
	{
		if (shopLayout[treasureX][treasureY]==shopLayout[heroX][heroY])
			{
				System.out.println("You win!");
				System.exit(0);
			}
		villianMove();
		makeShop();
		for (int row = 0; row < shopLayout.length; row++)
			{
				for (int col = 0; col < shopLayout[0].length; col++)
					{
						System.out.print(shopLayout[row][col]);
					}
				System.out.println();
			}
		if (heroX == villianX && heroY == villianY)
			{
				System.out.println("You have lost! You have been sent to prison!");
				Prison1.rememberTransgressions();
				Prison1.makeShop();
				Prison1.generateBoard();
				introduction();
			}
		move();
	}
	
	public static void move()
	{
		Scanner userChoice = new Scanner(System.in);
		System.out.println();
		System.out.println("Which way would you like to move, hero?");
		System.out.println("North, South, East, or West?");
		String direction = userChoice.nextLine();
			if (direction.equalsIgnoreCase("North") || direction.equalsIgnoreCase("N"))
				{
					if (shopLayout[heroX-1][heroY].equals("   ") || shopLayout[heroX-1][heroY].equals(" T "))
						{
							heroX -= 1;
							System.out.println("You have moved north!");
							generateBoard();
						}
					else if (shopLayout[heroX-1][heroY].equals(" # "))
						{
							System.out.println("That is a wall. You cannot move there.");
							generateBoard();
						}
				}
			if (direction.equalsIgnoreCase("South") || direction.equalsIgnoreCase("S"))
				{
					if (shopLayout[heroX+1][heroY].equals("   ") || shopLayout[heroX+1][heroY].equals(" T "))
						{
							heroX += 1;
							System.out.println("You have moved south!");
							generateBoard();
						}
					else if (shopLayout[heroX+1][heroY].equals(" # "))
						{
							System.out.println("That is a wall. You cannot move there.");
							generateBoard();
						}
				}
			if (direction.equalsIgnoreCase("West") || direction.equalsIgnoreCase("W"))
				{
					if (shopLayout[heroX][heroY-1].equals("   ") || shopLayout[heroX][heroY+1].equals(" T "))
						{
							heroY -= 1;
							System.out.println("You have moved west!");
							generateBoard();
						}
					else if (shopLayout[heroX][heroY-1].equals(" # "))
						{
							System.out.println("That is a wall. You cannot move there.");
							generateBoard();
						}
				}
			if (direction.equalsIgnoreCase("East") || direction.equalsIgnoreCase("E"))
				{
					if (shopLayout[heroX][heroY+1].equals("   ") || shopLayout[heroX][heroY+1].equals(" T "))
						{
							heroY += 1;
							System.out.println("You have moved east!");
							generateBoard();
						}
					else if (shopLayout[heroX][heroY+1].equals(" # "))
						{
							System.out.println("That is a wall. You cannot move there.");
							generateBoard();
						}
				}
			else
				{
					System.out.println("You cannot do that!");
					generateBoard();
				}
	}
	public static void villianMove()
	{
		int randomChoice = (int)(Math.random()*2);
		if (randomChoice==0)
			{
		if (heroX > villianX)
			{
				villianX += 1;
			}
		else if (heroX < villianX)
			{
				villianX -= 1;
			}
		else if (heroY > villianY)
			{
				villianY += 1;
			}
		else if (heroY < villianY)
			{
				villianY -= 1;
			}
			}
		if (randomChoice==1)
			{
				if (heroY > villianY)
					{
						villianY += 1;
					}
				else if (heroY < villianY)
					{
						villianY -= 1;
					}
				else if (heroX > villianX)
					{
						villianX += 1;
					}
				else if (heroX < villianX)
					{
						villianX -= 1;
					}
			}
		
	}
}