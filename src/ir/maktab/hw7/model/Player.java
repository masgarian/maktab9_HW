package ir.maktab.hw7.model;

import java.io.IOException;

public class Player {

	String name;
	Card[] cards;

	public Player() {
		// TODO Auto-generated constructor stub
	}

	public Player(String name, Card[] cards) {
		this.name = name;
		this.cards = cards;
	}

	public String getName() {
		return name;
	}

	public Card[] getCards() {
		return cards;
	}

	public String isWinner() {
		String res = "";

		for (int i = 0; i < cards.length; i++) {
			for (int j = 0; j < cards[0].getNumbers().length; j++) {
				for (int k = 0; k < cards[0].getNumbers()[0].length; k++) {
					try {
						if (!cards[i].isMarked(j, k))
							break;
						else if (k == 4) {
							res = name;
							System.out.println("winner card:");
							cards[i].dispCard();
						}
					} catch (IOException e) {
						System.out.println("check this function, e=" + e);
					}
				}
			}
		}

		return res;
	}

	public void markNumber(int number) {
		for (int i = 0; i < cards.length; i++) {
			if(cards[i].markNumber(number))
			{
				System.out.println(name+":");
				cards[i].dispCard();
			}
		}
	}
}
