package logic;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import pt.iscte.poo.gui.ImageMatrixGUI;
import pt.iscte.poo.observer.Observed;
import pt.iscte.poo.observer.Observer;
import structures.Room;

public class GameEngine implements Observer {

	public static final int GRID_HEIGHT = 11;
	public static final int GRID_WIDTH = 10;

	private static GameEngine INSTANCE = null;
	private ImageMatrixGUI gui = ImageMatrixGUI.getInstance();

	private List<Room> rooms = new ArrayList<>();
	private Room currentRoom;

	private int turns;

	public static GameEngine getInstance() {
		if (INSTANCE == null)
			INSTANCE = new GameEngine();
		return INSTANCE;
	}

	public ImageMatrixGUI getGui() {
		return gui;
	}

	public int getTurns() {
		return turns;
	}

	public void setTurns(int turns) {
		this.turns = turns;
	}

	private GameEngine() {
		gui.registerObserver(this);
		gui.setSize(GRID_WIDTH, GRID_HEIGHT);
		gui.go();
	}

	public Room getGurrentRoom() {
		return currentRoom;
	}

	public void start() { // init only once

		// rooms.add(new Room("testRoom2"));// Load every room?
		rooms.add(FileReader.createRoom("testRoom2"));// Load every room?
		currentRoom = rooms.get(0); // starting room

		gui.setStatusMessage("Good luck!");

		// gui.addImages(new HpBar().getComponents());//new HpBar?
		// gui.addImages(new ItemBar().getComponents());//new HpBar?

		gui.update();
	}

	@Override
	public void update(Observed source) {
		int keyPressed = ((ImageMatrixGUI) source).keyPressed();
		if (keyPressed >= KeyEvent.VK_LEFT && keyPressed <= KeyEvent.VK_DOWN) {
			Movement.keyPress(keyPressed); // moves Hero when arrow key is pressed
		}
		switch (keyPressed) {
		case KeyEvent.VK_1:
			currentRoom.getHero().dropItem(0);
			break;
		case KeyEvent.VK_2:
			currentRoom.getHero().dropItem(1);
			break;
		case KeyEvent.VK_3:
			currentRoom.getHero().dropItem(2);
			break;
		}

		currentRoom.moveEnemies();// only current room?

		gui.setStatusMessage("Turn: " + turns);
		gui.update();
	}
}
