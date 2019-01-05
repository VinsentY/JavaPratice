package four;

import java.util.Arrays;
import java.util.LinkedList;

class Player {
	private LinkedList<Integer> cards;
	
	private String name;
	
	public Player(Integer[] arr, String name) {
		cards = new LinkedList<>(Arrays.asList(arr));
		this.name = name;
	}

	public Integer play() {

		return cards.pollLast();
	}

	public void getCard(Integer[] arr) {
		
		if (arr==null) {
			return;
		}
		
		for (Integer i : arr) {
			cards.push(i);
		}
	}

	public boolean isLose() {
		return cards.isEmpty();
	}
	
	public void showCard() {
		System.out.println(name + " " + cards);
	}
}

class CardHeap {
	private LinkedList<Integer> cardHeap = new LinkedList<>();

	public Integer[] link(Integer c) {
		for (int i = 0; i < cardHeap.size(); i++) {
			if (cardHeap.get(i) == c) {
				cardHeap.push(c);
				Integer[] arr =  Arrays.copyOfRange(cardHeap.toArray(new Integer[0]), 0, i + 2);
				cardHeap.removeAll(Arrays.asList(arr));
				
				return arr;
			}
		}
		cardHeap.push(c);

		return null;

	}
	
	public void printCH() {
		System.out.println("CardHeap " + cardHeap );
	}
}

public class Game {
	Player one;
	Player two;

	CardHeap ch;

	int turn;

	boolean isOver;

	public Game() {
		one = new Player(new Integer[] { 2, 5, 9, 6, 3 }, "one");
		two = new Player(new Integer[] { 5, 9, 2, 3, 6 }, "two");

		ch = new CardHeap();

		turn = 1;

		isOver = false;
	}

	public void gameStart() {
		while (!isOver) {
			if (turn == 1) {
				one.getCard(ch.link(one.play()));
				one.showCard();
				isOver = one.isLose();
				turn = 2;
				// Integer c = one.play();
				// Integer[] arr = ch.link(c);
				// if (arr.length!=0) {
				// one.getCard(arr);
				// }
			} else {
				two.getCard(ch.link(two.play()));
				two.showCard();
				isOver = two.isLose();
				turn = 1;
			}
			
			ch.printCH();
		}
		
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.gameStart();
	}
}
