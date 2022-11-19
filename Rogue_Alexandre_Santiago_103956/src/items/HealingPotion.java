package items;

import logic.GameElement;
import pt.iscte.poo.utils.Point2D;

public class HealingPotion extends GameElement implements Pickable {

	private boolean isPicked = false;
	private int layer = 1;

	public HealingPotion(Point2D position) {
		super(position);
	}

	@Override
	public String getName() {
		if (isPicked) {
			layer = 0;
			return "Floor";
		}
		return "HealingPotion";
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
		return "HealingPotion";
	}
}
