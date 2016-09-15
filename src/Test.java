import java.util.Scanner;

public class Test
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
				generateVillian();
				makeShop();
				addTreasure();
				generateBoard();
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
					shopLayout[villianX][villianY] = " V ";
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
		shopLayout[villianX][villianY] = " V ";

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
				System.out.println("You have lost! The villian has caught you!");
				System.exit(0);
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