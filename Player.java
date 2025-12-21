package snake.ladder;

public class Player {
	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}

	private int id;
	private int currentPosition;
	
	Player(int id, int currentPosition) {
		this.id = id;
		this.currentPosition = currentPosition;
	}

	public int getId() {
		return id;
	}

	public int getCurrentPosition() {
		return currentPosition;
	}
}
