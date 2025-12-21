package snake.ladder;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
	private Cell[][] board;
	
	Board(int boardSize, int numberOfSnakes, int numberOfLadders) {
		initializeBoard(boardSize);
		addSnakesAndLadders(numberOfSnakes, numberOfLadders);
	}
	
	private void initializeBoard(int size) {
		this.board = new Cell[size][size];
		
		int count = 1;
		for(int i = 0; i<size; i++) {
			for(int j = 0; j<size; j++) {
				Cell cell = new Cell(count);
				this.board[i][j] = cell;
				count++;
			}
		}
	}
	
	private void addSnakesAndLadders(int numberOfSnakes, int numberOfLadders) {
		while(numberOfSnakes > 0) {
			int start = ThreadLocalRandom.current().nextInt(1, board.length*board.length-1);
			int end = ThreadLocalRandom.current().nextInt(1, board.length*board.length-1);
			
			if(end >= start) {
				continue;
			}
			
			Jump snake = new Jump(start, end);
			Cell snakeHead = getCell(start);
			
			snakeHead.setJump(snake);
			
			numberOfSnakes--;
			
		}
		
		while(numberOfLadders > 0) {
			int start = ThreadLocalRandom.current().nextInt(1, board.length*board.length-1);
			int end = ThreadLocalRandom.current().nextInt(1, board.length*board.length-1);
			
			if(start >= end) {
				continue;
			}
			
			Jump ladder = new Jump(start, end);
			Cell ladderStart = getCell(start);
			
			ladderStart.setJump(ladder);
			
			numberOfLadders--;
			
		}
	}
	
	public Cell getCell(int cellId) {
		int row = cellId / board.length;
		int col = cellId % board.length;
		
		return board[row == board.length ? row-1:row][col];
	}
	
}
