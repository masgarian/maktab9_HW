package ir.maktab.hw7.model;

import java.io.IOException;
import java.util.Random;

public class Card {
	int[][] numbers;
	boolean[][] mark;

	public int[][] getNumbers() {
		return numbers;
	}

	public void setNumbers(int[][] numbers) {
		this.numbers = numbers;
	}

	public boolean[][] getMark() {
		return mark;
	}

	public void setMark(boolean[][] mark) {
		this.mark = mark;
	}

	public Card() {
		// TODO Auto-generated constructor stub
	}

	public Card(int[][] numbers) {
		super();
		this.numbers = numbers;
		mark = new boolean[numbers.length][numbers[0].length];
	}

	public int getNumber(int row, int column) throws IOException {
		try {
			return numbers[row - 1][column - 1];
		} catch (Exception e) {
			throw new IOException("out of range arg");
		}
	}

	public boolean isMarked(int row, int column) throws IOException {
		try {
			return mark[row][column];
		} catch (Exception e) {
			throw new IOException("out of range arg");
		}
	}

	public boolean markNumber(int number) {
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers[0].length; j++) {
				if (numbers[i][j] == number) {
					mark[i][j] = true;
					return true;
				}
			}
		}
		return false;
	}

	public void fillRandom(int row, int column) {
		numbers = new int[row][column];
		mark = new boolean[row][column];
		Random rnd = new Random();
		int cnt = 0;
		int[] temp = new int[row * column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				while (numbers[i][j] == 0) {
					int n = rnd.nextInt(90) + 1;
					for (int k = 0; k < cnt; k++)
						if (temp[k] == n) {
							n = 0;
						}
					if (n != 0) {
						temp[cnt] = n;
						numbers[i][j] = n;
						cnt++;
					}
				}
			}
		}

	}

	public void dispCard() {
		try {
			for (int j = 0; j < numbers[0].length; j++)
				System.out.print("+---");
			System.out.println("+");

			for (int i = 0; i < numbers.length; i++) {
				for (int j = 0; j < numbers[0].length; j++) {
					System.out.print("|" + String.format("%1$2d", numbers[i][j]));
					if (mark[i][j])
						System.out.print("#");
					else
						System.out.print(" ");
				}
				System.out.println("|");
			}
			for (int j = 0; j < numbers[0].length; j++)
				System.out.print("+---");
			System.out.println("+");

		} catch (NullPointerException e) {
			System.out.println("card has not been initialized");
		}
	}
}
