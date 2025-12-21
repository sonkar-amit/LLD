package snake.ladder;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
	private Board board;
	private Dice dice;
	private int size = 10;
	
	private Deque<Player> players = new LinkedList<Player>();
	private Player winner;
	
	Game() {
		initializeGame();
	}
	
	private void initializeGame() {
		this.board = new Board(size, 5, 6);
		this.dice = new Dice(1);
		
		addPlayers();
	}
	
	private void addPlayers() {
		Player player1 = new Player(1, 1);
		Player player2 = new Player(2, 1);
		
		this.players.add(player1);
		this.players.add(player2);
	}
	
	public void play() {
		while(winner == null) {
			// Player1 starts playing
			Player player = players.poll();
			players.add(player);
			
			System.out.println("player"+player.getId()+ " current position is "+player.getCurrentPosition());
			
			int diceNumber = dice.rollDice();
			int newPosition = player.getCurrentPosition() + diceNumber;
			
			if(newPosition >= size*size) {
				newPosition = size*size;
			}
			
			System.out.println("player"+player.getId()+ " got the "+diceNumber + " in dice");
			
			Cell cell = board.getCell(newPosition);
			
			if(cell.getJump() != null) {
				if(cell.getJump().getStart() > cell.getJump().getEnd() ) {
					System.out.println("player"+player.getId()+ " got bitten by snake at "+cell.getJump().getStart());
					
					player.setCurrentPosition(cell.getJump().getEnd());
					
					System.out.println("player"+player.getId()+ " reached to cell "+cell.getJump().getEnd()+ " after bitten by snake");
				}
				
				if(cell.getJump().getStart() < cell.getJump().getEnd() ) {
					System.out.println("player"+player.getId()+ " got the ladder at "+cell.getJump().getStart());
					
					player.setCurrentPosition(cell.getJump().getEnd());
					
					System.out.println("player"+player.getId()+ " reached to cell "+cell.getJump().getEnd()+ " after climbing the ladder");
				}
			} else {
				player.setCurrentPosition(newPosition);
				System.out.println("player"+player.getId()+ " reached to "+newPosition + " with help of only dice rolling");
			}
			
			if(player.getCurrentPosition() >= size*size) {
				winner = player;
			}
		}
		
		System.out.println("Winner is player"+winner.getId());
	}
}
