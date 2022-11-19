package items;

import logic.GameElement;
import logic.GameEngine;
import pt.iscte.poo.utils.Point2D;

public class Treasure extends GameElement implements Pickable{
	
	public Treasure(Point2D position) {
		super(position);
	}
	
	@Override
	public String getName() {
		return "Treasure";
	}

	@Override
	public int getLayer() {
		return 1;
	}
	
	public void pick() {
		GameEngine.getInstance().getGui().setMessage("Congratulations!!! YOU WON!");
		GameEngine.getInstance().getGui().dispose();
	}
	
	@Override
	public String toString() {
		return getName();
	}
}
