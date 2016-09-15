import java.util.Scanner;

public class Prison1
	{

		static String [][] shopLayout = new String[5][5];
		static int penance = 3;
		static int transgressions = 0;
		static int heroX = 1;
		static int heroY = 2;
		static int treasureX = 0;
		static int treasureY = 0;
		static int villianX = 0;
		static int villianY = 0;
		public static void main(String[] args)
			{
				makeShop();
				generateBoard();
			}
	public static void rememberTransgressions()
	{
		transgressions++;
		penance=penance*transgressions;
	}
	public static void makeShop()
	{
		for (int row = 0; row < shopLayout.length; row++)
		{
			for (int col = 0; col < shopLayout[0].length; col++)
				{
					shopLayout[row][col]="   ";
					shopLayout[heroX][heroY] = " H ";
				}
		}
		for (int i = 0; i < shopLayout.length; i++)
			{
				shopLayout[0][i]= " # ";
				shopLayout[i][0]= " # ";
				shopLayout[4][i] = " # ";
				shopLayout[i][4] = " # ";
			}
	}
	public static void generateBoard()
	{
		if (shopLayout[treasureX][treasureY]==shopLayout[heroX][heroY])
			{
				System.out.println("You win!");
				System.exit(0);
			}
		makeShop();
		for (int row = 0; row < shopLayout.length; row++)
			{
				for (int col = 0; col < shopLayout[0].length; col++)
					{
						System.out.print(shopLayout[row][col]);
					}
				System.out.println();
			}
		move();
	}
	
	public static void move()
	{
		for (int i=0; i<=penance; i++)
			{
				i++;
				int movesLeft = penance-i;
		Scanner userChoice = new Scanner(System.in);
		System.out.println();
		System.out.println("You have " + movesLeft + " moves until you are released.");
		String direction = userChoice.nextLine();
			if (direction.equalsIgnoreCase("North") || direction.equalsIgnoreCase("N"))
				{
					if (shopLayout[heroX-1][heroY].equals("   ") || shopLayout[heroX-1][heroY].equals(" T "))
						{
							heroX -= 1;
							System.out.println("You have moved north!");
							i++;
							generateBoard();
						}
					else if (shopLayout[heroX-1][heroY].equals(" # "))
						{
							System.out.println("That is a wall. You cannot move there.");
							i++;
							generateBoard();
						}
				}
			if (direction.equalsIgnoreCase("South") || direction.equalsIgnoreCase("S"))
				{
					if (shopLayout[heroX+1][heroY].equals("   ") || shopLayout[heroX+1][heroY].equals(" T "))
						{
							heroX += 1;
							System.out.println("You have moved south!");
							i++;
							generateBoard();
						}
					else if (shopLayout[heroX+1][heroY].equals(" # "))
						{
							System.out.println("That is a wall. You cannot move there.");
							i++;
							generateBoard();
						}
				}
			if (direction.equalsIgnoreCase("West") || direction.equalsIgnoreCase("W"))
				{
					if (shopLayout[heroX][heroY-1].equals("   ") || shopLayout[heroX][heroY+1].equals(" T "))
						{
							heroY -= 1;
							System.out.println("You have moved west!");
							i++;
							generateBoard();
						}
					else if (shopLayout[heroX][heroY-1].equals(" # "))
						{
							System.out.println("That is a wall. You cannot move there.");
							i++;
							generateBoard();
						}
				}
			if (direction.equalsIgnoreCase("East") || direction.equalsIgnoreCase("E"))
				{
					if (shopLayout[heroX][heroY+1].equals("   ") || shopLayout[heroX][heroY+1].equals(" T "))
						{
							heroY += 1;
							System.out.println("You have moved east!");
							i++;
							generateBoard();
						}
					else if (shopLayout[heroX][heroY+1].equals(" # "))
						{
							System.out.println("That is a wall. You cannot move there.");
							i++;
							generateBoard();
						}
				}
			else
				{
					System.out.println("You cannot do that!");
					generateBoard();
				}
	}
		
	}
	}