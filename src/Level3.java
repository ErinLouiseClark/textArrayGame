import java.util.Scanner;

public class Level3
	{

		static String [][] shopLayout = new String[21][21];
		static int heroX = 1;
		static int heroY = 11;
		static int treasureX = 0;
		static int treasureY = 0;
		static int villianX = 0;
		static int villianY = 0;
		static int villian2X = 0;
		static int villian2Y = 0;
		public static void main(String[] args)
			{
				//introduction();
				generateVillian();
				makeShop();
				addTreasure();
				generateBoard();
			}
	public static void introduction()
	{
		Scanner userChoice = new Scanner(System.in);
		System.out.println("Nice! That was pretty good! Now I think that you are ready for the real treasure.");
		System.out.println("Now that we are finished with the child's play why don't we go after the king's gold.");
		System.out.println("Are you ready for your biggest steal yet?");
		System.out.println("(1) Yes");
		System.out.println("(2) No, and where is the gold from the dragon?");
		int choice = userChoice.nextInt();
		if (choice == 1)
			{
				System.out.println("Great, let's go.");
			}
		else if  (choice == 2)
			{
				System.out.println("You are in too deep. All the treasure that you steal is mine!");
				System.out.println("If you don't want to steal the king's gold, then I'll tell him about YOUR plot.");
				System.out.println("(1) My plot? You were the one who plotted to steal the gold in the first place.");
				System.out.println("(2) Alright, but I want a cut of the king's treasure");
				int choice2 = userChoice.nextInt();
					if (choice2==1)
						{
							System.out.println("You are right, I was the one who made the plot. I guess we'll never see the king's gold.");
							System.out.println("Two days later, two guards roughly seized you from your home.");
							System.out.println("After a quick trial, you were convicted of treason and put in a dingy cell.");
							Prison1.makeShop();
							Prison1.generateBoard();
						}
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
					shopLayout[villianX][villianY] = " G ";
					shopLayout[villian2X][villian2Y] = " G ";
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
				shopLayout[20][i] = " # ";
				shopLayout[i][20] = " # ";
			}
	}
	public static void addTreasure()
	{
		treasureX = (int)(Math.random()*5)+15;
		treasureY = (int)(Math.random()*5)+10;
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
		villianX = (int)(Math.random()*5)+15;
		villianY = (int)(Math.random()*5)+10;
		shopLayout[villianX][villianY] = " G ";
		villian2X = (int)(Math.random()*5)+15;
		villian2Y = (int)(Math.random()*5)+15;
		shopLayout[villian2X][villian2Y] = " G ";
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
		if (heroX == villian2X && heroY == villian2Y)
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
			if (direction.equalsIgnoreCase("W"))
				{
					if (shopLayout[heroX-1][heroY].equals("   ") || shopLayout[heroX-1][heroY].equals(" T "))
						{
							heroX -= 1;
							System.out.println("You have moved up!");
							generateBoard();
						}
					else if (shopLayout[heroX-1][heroY].equals(" # "))
						{
							System.out.println("That is a wall. You cannot move there.");
							generateBoard();
						}
				}
			if (direction.equalsIgnoreCase("S"))
				{
					if (shopLayout[heroX+1][heroY].equals("   ") || shopLayout[heroX+1][heroY].equals(" T "))
						{
							heroX += 1;
							System.out.println("You have moved down!");
							generateBoard();
						}
					else if (shopLayout[heroX+1][heroY].equals(" # "))
						{
							System.out.println("That is a wall. You cannot move there.");
							generateBoard();
						}
				}
			if (direction.equalsIgnoreCase("A"))
				{
					if (shopLayout[heroX][heroY-1].equals("   ") || shopLayout[heroX][heroY+1].equals(" T "))
						{
							heroY -= 1;
							System.out.println("You have moved left!");
							generateBoard();
						}
					else if (shopLayout[heroX][heroY-1].equals(" # "))
						{
							System.out.println("That is a wall. You cannot move there.");
							generateBoard();
						}
				}
			if (direction.equalsIgnoreCase("D"))
				{
					if (shopLayout[heroX][heroY+1].equals("   ") || shopLayout[heroX][heroY+1].equals(" T "))
						{
							heroY += 1;
							System.out.println("You have moved right!");
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
	if (randomChoice==1)
		{
	if (heroX > villian2X)
		{
			villian2X += 1;
		}
	else if (heroX < villian2X)
		{
			villian2X -= 1;
		}
	else if (heroY > villian2Y)
		{
			villian2Y += 1;
		}
	else if (heroY < villian2Y)
		{
			villian2Y -= 1;
		}
		}
	if (randomChoice==0)
		{
			if (heroY > villian2Y)
				{
					villian2Y += 1;
				}
			else if (heroY < villian2Y)
				{
					villian2Y -= 1;
				}
			else if (heroX > villian2X)
				{
					villian2X += 1;
				}
			else if (heroX < villian2X)
				{
					villian2X -= 1;
				}
		}
	
}
}