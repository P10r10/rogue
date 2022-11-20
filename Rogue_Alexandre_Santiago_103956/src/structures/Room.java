package structures;

import java.util.ArrayList;
import java.util.List;

import characters.Hero;
import interfaces.Movable;
import interfaces.Pickable;
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
		GameEngine.getInstance().getGui().addImage(hero);
		GameEngine.getInstance().getGui().addImages(hero.getHpBar().getComponents());
	}

	public Hero getHero() {
		return hero;
	}

	public void removeGameElement(ImageTile gameElement) {
		elements.remove(gameElement);
	}
	/*remove*/
//	public List<GameElement> getElements(Point2D dest) {
//		List<GameElement> res = new ArrayList<>();
//		for (GameElement elem : elements) {
//			if (elem.getPosition().equals(dest)) {
//				res.add(elem);
//			}
//		}
//		return res;
//	}
	/*remove*/

	public void moveEnemies() {
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
		//System.out.println("ElementsAt: " + elementsAt);
		GameElement toReturn = null;
		// If 2 elements are in the same Point2D, assigns priority
		for (GameElement elementAt : elementsAt) {
			if (elementAt instanceof Movable) {
				return elementAt;
//				toReturn = elementAt;
			}
		}
		for (GameElement elementAt : elementsAt) {
			if (elementAt instanceof Pickable) {
				return elementAt;
//				toReturn = elementAt;
			}
		}
		for (GameElement elementAt : elementsAt) {
			if (elementAt instanceof Door) {
				return elementAt;
//				toReturn = elementAt;
			}
		}
		for (GameElement elementAt : elementsAt) {
			if (elementAt instanceof Wall) {
				return elementAt;
//				toReturn = elementAt;
			}
		}
		for (GameElement elementAt : elementsAt) {
			if (elementAt instanceof Floor) {
				return elementAt;
//				toReturn = elementAt;
			}
		}
//		if (toReturn != null) {
//			System.out.println("To return: " + toReturn);
//			return toReturn;
//		}
		return null;
	}

	@Override
	public String toString() {
		return name;
	}
}
