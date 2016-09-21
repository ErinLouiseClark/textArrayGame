import java.util.Scanner;

public class Level1
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
		Scanner userChoice = new Scanner(System.in);
		System.out.println("Welcome hero, I have a task for you.");
		System.out.println("I have hidden a treasure in this field.");
		System.out.println("Use W to move up, A to move right, S to move down, and D to move left.");
		System.out.println("Are you ready to go after it?");
		System.out.println("(1) Of course I am!");
		System.out.println("(2) This is not worth my time.");
		int choice = userChoice.nextInt();
		if (choice == 1)
			{
			System.out.println("I knew that you were the one for the job!");
			makeShop();
			addTreasure();
			generateBoard();
			}
		else if  (choice == 2)
			{
				System.out.println("Well this is awkward. Um, see you later.");
			}
		else
			{
				System.out.println("I can't hear what your saying, but it sounds like a yes!");
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
		//public static void generateVillian()
		{
			villianX = (int)(Math.random()*3)+6;
			villianY = (int)(Math.random()*9);
			shopLayout[villianX][villianY] = " V ";

		}
		public static void generateBoard()
		{
			if (shopLayout[treasureX][treasureY]==shopLayout[heroX][heroY])
				{
					System.out.println("You have made it!");
					Level2.introduction();
				}
			//villianMove();
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
					System.out.println("You have lost! The dragon has eaten you!");
					System.exit(0);
				}
			move();
		}
		
		public static void move()
		{
			Scanner userChoice = new Scanner(System.in);
			System.out.println();
			System.out.println("Type in W, A, S, or D and press enter to make your move.");
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
	}
	}