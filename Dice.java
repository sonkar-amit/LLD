package snake.ladder;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
	private static final int MIN_VAL = 1;
	private static final int MAX_VAL = 6;
	
	private int numberOfDice;
	
	Dice(int numberOfDice) {
		this.numberOfDice = numberOfDice;
	}
	
	public int rollDice() {
		int diceCount = numberOfDice;
		int totalValue = 0;
		while(diceCount > 0) {
			int rolledNumber = ThreadLocalRandom.current().nextInt(MIN_VAL, MAX_VAL);
			totalValue = totalValue + rolledNumber;
			diceCount--;
		}
		
		return totalValue;
	}
}
