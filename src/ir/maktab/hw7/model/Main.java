package ir.maktab.hw7.model;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Card[] cards1 = new Card[2];
		for (int i=0;i<cards1.length ; i++) {
			cards1[i] = new Card();
			cards1[i].fillRandom(3, 5);
			cards1[i].dispCard();
		}
		cards1[1].dispCard();
		Card[] cards2 = new Card[2];
		for (int i=0;i<cards2.length ; i++) {
			cards2[i] = new Card();
			cards2[i].fillRandom(3, 5);
			cards2[i].dispCard();
		}

		Player[] players = new Player[2];
		players[0] = new Player("player1", cards1);
		players[1] = new Player("player2", cards2);

		Bingo g = new Bingo(players);

		String winners = "";
int cnt=0;
		while (winners.equals("")) {
			Random rnd = new Random();
			int number=rnd.nextInt(90) + 1;
			System.out.println("round: "+((cnt++)+1)+"   number: "+number);
			winners = g.paly(number);
		}
		System.out.println(winners);
		
	}

}
