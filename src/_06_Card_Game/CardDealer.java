package _06_Card_Game;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class CardDealer {
	enum Rank {
		TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10),
		ACE(11);

		private int rank;

		private Rank(int rank) {
			this.rank = rank;
		}

		public int getRank() {
			return this.rank;
		}
	}

	enum Suit {
		SPADES, CLUBS, HEARTS, DIAMONDS;
	}

	static ArrayList<Card> deck;
	Suit[] suits = Suit.values();
	Rank[] ranks = Rank.values();
	Random rand = new Random();
	static ArrayList<Card> pHand = new ArrayList<Card>();
	static ArrayList<Card> dHand = new ArrayList<Card>();

	public CardDealer() {
		deck = new ArrayList<Card>();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				deck.add(new Card(ranks[j], suits[i]));
			}
		}
		Shuffle();
	}

	public static void main(String[] args) {
		new CardDealer();
		String[] options = { "yes", "yes" };
		JOptionPane.showOptionDialog(null, "You are going to play blackjack.", "yes", 0, 0, null, options, options);
		Blackjack();
	}

	public void Shuffle() {
		ArrayList<Integer> range = new ArrayList<Integer>();
		ArrayList<Card> newDeck = new ArrayList<Card>();
		for (int i = 0; i < 52; i++) {
			range.add(i);
		}
		for (int i = 0; i < 52; i++) {
			int cardIndex = range.get(rand.nextInt(range.size()));
			range.remove(new Integer(cardIndex));
			newDeck.add(deck.get(cardIndex));
		}

		deck = newDeck;
	}
	static int statPTotal;
	static int statDTotal;
	public static void Blackjack() {
		for (int i = 0; i < 2; i++) {
			draw(dHand);
			draw(pHand);
		}
		int pHandTotal = pHand.get(0).getRank().rank + pHand.get(1).getRank().rank;
		int dHandTotal = dHand.get(0).getRank().rank + dHand.get(1).getRank().rank;
		statPTotal = pHandTotal;
		statDTotal = dHandTotal;
		
		
		String message = "Your deck: " + pHand.get(0) + ", " + pHand.get(1) + "\nHand Total: " + pHandTotal
				+ "\nDealer's Card: " + dHand.get(0);
		String[] options = { "Hit", "Stand" };

		while (pHandTotal <= 21) {
			message = "Your deck: " + pHand.get(0) + ", " + pHand.get(1) + "\nHand Total: " + pHandTotal
					+ "\nDealer's Card: " + dHand.get(0);
			int choice = JOptionPane.showOptionDialog(null, message, "Jack Black", 0, 0, null, options, options);

			switch (choice) {
			case 0:
				draw(pHand);
				pHandTotal += pHand.get(pHand.size() - 1).getRank().rank;
				if (pHandTotal > 21) {
					reset("Bust! Your hand total was " + pHandTotal + ". Would you like to play again?");
				} 
				else {}
				break;
			case 1:
				while (dHandTotal <= 21) {
					if (deck.get(0).getRank().rank + dHandTotal > 21) {
						break;
					}
					else {
						draw(dHand);
						dHandTotal += dHand.get(dHand.size() - 1).getRank().rank;
					}
				}
				if(pHandTotal>dHandTotal) {
					reset("Your Hand: " + pHandTotal + "\nDealer's Hand: " + dHandTotal + "\nCongratulations! Would you like to play again?");
				}
				else {
					reset("Your Hand: " + pHandTotal + "\nDealer's Hand: " + dHandTotal + "\nYou lost! Better luck next time. Would you like to play again?");
				}
			}
		}

	}
	public static void reset(String message) {
		String[] resOptions = { "yes", "no" };
		int restart = JOptionPane.showOptionDialog(null, message,
				"Jack Black", 0, 0, null, resOptions, resOptions);
		switch(restart) {
		case 0:
			for (int i = 0; i < pHand.size(); i++) {
				deck.add(pHand.get(i));
			}
			for (int i = 0; i < dHand.size(); i++) {
				deck.add(dHand.get(i));
			}
			pHand.clear();
			dHand.clear();
			statPTotal = 0;
			statDTotal = 0;
			Blackjack();
		case 1:
			System.exit(0);
		}
	}
	public static void draw(ArrayList<Card> hand) {
		Card topCard = deck.get(0);
		hand.add(topCard);
		deck.remove(0);
		deck.add(topCard);
	}
}
