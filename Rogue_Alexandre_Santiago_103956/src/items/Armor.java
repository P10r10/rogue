package items;

import logic.GameElement;
import pt.iscte.poo.utils.Point2D;

public class Armor extends GameElement implements Pickable {

	private boolean isPicked = false;
	private int layer = 1;

	public Armor(Point2D position) {
		super(position);
	}

	@Override
	public String getName() {
		if (isPicked) {
			layer = 0;
			return "Floor";
		}
		return "Armor";
	}

	@Override
	public int getLayer() {
		return layer;
	}

	public void pick() {
		isPicked = true;
	}

	@Override
	public String toString() {
		return "Armor";
	}
}