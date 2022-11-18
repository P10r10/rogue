package logic;

import characters.Bat;
import characters.Hero;
import characters.Living;
import characters.Skeleton;
import items.Pickable;
import pt.iscte.poo.utils.Direction;
import pt.iscte.poo.utils.Point2D;
import pt.iscte.poo.utils.Vector2D;
import structures.Floor;
import structures.Room;

public class Movement {
	private static Room room = GameEngine.getInstance().getGurrentRoom();
	private static Hero hero = room.getHero();

	public static void keyPress(int key) {
		int turns = GameEngine.getInstance().getTurns();
		Point2D heroPosition = hero.getPosition();
		Point2D destination = heroPosition.plus(Direction.directionFor(key).asVector());

		//System.out.println(room.elementAt(destination));//DEBUG REMOVE
		if (room.elementAt(destination) instanceof Living) {
			Colision.withEnemy(room.elementAt(destination));
		} else if (room.elementAt(destination) instanceof Pickable && hero.canCarry()) {
			((Pickable) room.elementAt(destination)).pick();
			hero.addInventory((Pickable) room.elementAt(destination));
			room.removeGameElement(room.elementAt(destination));
			hero.setPosition(destination);
		} else if (room.elementAt(destination) instanceof Floor) {
			hero.setPosition(destination);
		}
		GameEngine.getInstance().setTurns(++turns);// every key increases turn
	}

	public static void move(GameElement element) {
		Point2D heroPosition = hero.getPosition();
		Vector2D directionToHero = element.getPosition().directionTo(heroPosition).asVector();
		Point2D destination = element.getPosition().plus(directionToHero);

		if (GameEngine.getInstance().getTurns() % 2 == 0) {
			if (element instanceof Skeleton) {
				return; // Skeleton doesn't move 50% of turns
			}
			if (element instanceof Bat) {// Bat moves randomly 50% of turns
				destination = element.getPosition().plus(Direction.random().asVector());
			}
		}
		if (hero.getPosition().equals(destination)) {
			Colision.withHero(element);
		} else if (room.elementAt(destination) instanceof Living) {
			//do nothing because monsters don't collide with each other
		} else if (room.elementAt(destination) instanceof Pickable || room.elementAt(destination) instanceof Floor) {
			element.setPosition(destination);
		}
	}
}
