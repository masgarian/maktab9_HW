package ir.maktab.hw7.model;

public class Bingo {

	Player[] players;

	public Bingo() {
		// TODO Auto-generated constructor stub
	}

	public Bingo(Player[] players) {
		this.players = players;
	}

	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}

	public String paly(int number) {

		String res = "";
		for (int i = 0; i < players.length; i++) {
			players[i].markNumber(number);
			res += players[i].isWinner();
		}
		return res;
	}
}
