package snake.ladder;

public class Cell {
	private int id;
	private Jump jump;
	
	Cell(int id) {
		this.id = id;
	}

	public Jump getJump() {
		return jump;
	}

	public void setJump(Jump jump) {
		this.jump = jump;
	}

	public int getId() {
		return id;
	}
}
