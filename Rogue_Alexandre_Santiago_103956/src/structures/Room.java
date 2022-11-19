package structures;

import java.util.ArrayList;
import java.util.List;

import characters.Hero;
import characters.Movable;
import items.Pickable;
import logic.GameElement;
import logic.GameEngine;
import pt.iscte.poo.gui.ImageTile;
import pt.iscte.poo.utils.Point2D;

public class Room {

	private String name;
	private List<GameElement> elements;
	private Hero hero = Hero.getInstance();// added review

	public Room(String name, List<GameElement> elements) {
		this.name = name;
		this.elements = elements;
		for (ImageTile image : elements) {
			GameEngine.getInstance().getGui().addImage(image);
		}
		GameEngine.getInstance().getGui().addImage(hero);// ATENÇÃO!!!!!
	}

	public Hero getHero() {
		return hero;
	}

	public void removeGameElement(ImageTile gameElement) {
		elements.remove(gameElement);
	}

	public void moveEnemies() {// Make private?
		for (ImageTile gameElement : elements) {
			if (gameElement instanceof Movable)
				((Movable) gameElement).move();
		}
	}

	public GameElement elementAt(Point2D position) {
		List<GameElement> elementsAt = new ArrayList<>();
		for (GameElement element : elements) {
			if (position.equals(element.getPosition())) {
				elementsAt.add(element);
			}
		}
		GameElement toReturn = null;
		// If 2 elements are in the same Point2D, assigns priority
		for (GameElement elementAt : elementsAt) {
			if (elementAt instanceof Movable) {
				toReturn = elementAt;
			}
			if (elementAt instanceof Pickable) {
				toReturn = elementAt;
			}
			if (elementAt instanceof Door) {
				toReturn = elementAt;
			}
			if (elementAt instanceof Wall) {
				toReturn = elementAt;
			}
			if (elementAt instanceof Floor) {
				toReturn = elementAt;
			}
		}
		if (toReturn != null)
			return toReturn;
		return null;
	}

	@Override
	public String toString() {
		return name;
	}
}