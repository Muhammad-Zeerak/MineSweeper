package Assignments;

import java.util.*; // import library before using

public class simulator 
{
	public static void main (String args[])
	{
		int row, column;
		float probability;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter number of rows: ");
		row = input.nextInt();
		System.out.print("Enter number of columns: ");
		column = input.nextInt();
		System.out.print("Enter number of probability: ");
		probability = input.nextFloat();
		
		Random rand = new Random();
		
		boolean array[][] = new boolean[row][column];
		char a[][] = new char[row][column];
		int b[][] = new int [row][column];
		
		int s = (int) (probability * row * column);
		
		for(int i = 0; i < row; i++) // assigning occupied or not and in 2nd if true * if false -
		{
			for (int j = 0 ; j < column; j++)
			{
					array[i][j] = false;
			}
		}
		
		int c, d;
		for (int counter = 1; counter <= s; counter++) // assigning bombs
		{
					c = rand.nextInt(row);
					d = rand.nextInt(column);
					array[c][d] = true;
		}

		for(int i = 0; i < row; i++) // assigning * and - to true and false respectively
		{
			for (int j = 0 ; j < column; j++)
			{
				if(array[i][j] == true)
					a[i][j] = '*';
				else if(array[i][j] == false)
					a[i][j] = '-';
			}
		}
		
		for(int i = 0; i < row; i++) // printing first result
		{
			for (int j = 0 ; j < column; j++)
			{
				System.out.print(a[i][j] + "  ");
			}
			System.out.print("\n");	
		}
		
		System.out.print("\n\n");	
		
		for(int i = 0; i < row; i++) // assigning 0
		{
			for (int j = 0 ; j < column; j++)
			{
				b[i][j] = 0;
			}
		}
		
		for(int i = 0; i < row; i++) // assigning numbers to each
		{
			int r = row - 1;
			for (int j = 0 ; j < column; j++)
			{
				if(a[i][j] =='*')
				{
					if(i == 0 && j == 0) // first row
					{
							b[i][j + 1]++;
							b[i + 1][j]++;
							b[i + 1][j + 1]++;
					}
					if(i == 0 && j > 0 && j < column - 1)
					{
						b[i][j + 1]++;
						b[i + 1][j]++;
						b[i][j - 1]++;
						b[i + 1][j + 1]++;
						b[i + 1][j - 1]++;
					}
					if(i == 0 && j == column - 1)
					{
						b[i + 1][j]++;
						b[i][j - 1]++;
						b[i + 1][j - 1]++;
					}
					
					if(i == r && j == 0) // last row
					{
						b[i][j + 1]++;
						b[i - 1][j]++;
						b[i - 1][j + 1]++;
					}
					if(i == r &&  j > 0 && j < column - 1)
					{
						b[i][j + 1]++;
						b[i - 1][j]++;
						b[i][j - 1]++;
						b[i - 1][j + 1]++;
						b[i - 1][j - 1]++;
					}
					if(i == r && j == column - 1)
					{
						b[i][j - 1]++;
						b[i - 1][j]++;
						b[i - 1][j - 1]++;
					}
					
					if (i > 0 && i < r && j == 0) // in middle
					{
						b[i][j + 1]++;
						b[i - 1][j]++;
						b[i + 1][j]++;
						b[i - 1][j + 1]++;
						b[i + 1][j + 1]++;
					}
					if(i > 0 && i < r && j == column - 1)
					{
						b[i + 1][j]++;
						b[i - 1][j]++;
						b[i][j - 1]++;
						b[i - 1][j - 1]++;
						b[i + 1][j - 1]++;
					}
					if(i > 0 && i < r && j > 0 && j < column - 1)
					{
						b[i][j - 1]++;
						b[i - 1][j]++;
						b[i][j + 1]++;
						b[i + 1][j]++;
						b[i - 1][j + 1]++;
						b[i + 1][j + 1]++;
						b[i - 1][j - 1]++;
						b[i + 1][j - 1]++;
					}
				}
			}
		}
		
		for(int i = 0; i < row; i++) // printing second result
		{
			for (int j = 0 ; j < column; j++)
			{
				if (a[i][j] =='*')
					System.out.print(a[i][j] + "  ");
				else if (a[i][j] =='-')
					System.out.print(b[i][j] + "  ");
			}
			System.out.print("\n");	
		}
	}
}

