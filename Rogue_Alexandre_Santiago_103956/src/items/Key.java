package items;

import logic.GameElement;
import logic.GameEngine;
import pt.iscte.poo.utils.Point2D;

public class Key extends GameElement implements Pickable {
	
	private String id;
	//private boolean isPicked = false;
	private int layer = 1;

	public Key(Point2D position, String id) {
		super(position);
		this.id = id;
	}

	@Override
	public String getName() {
//		if (isPicked) {
//			layer = 0;
//			return "Floor";
//		}
		return "Key";
	}
	
	@Override
	public int getLayer() {
		return layer;
	}
	
	public void pick() {
	//	isPicked = true;
		Point2D position = GameEngine.getInstance().getGurrentRoom().getHero().getNextFreeSlot();
		if (position != null) {
			setPosition(position);
		}
	}
	
	@Override
	public String toString() {
		return "Key";
	}
}
