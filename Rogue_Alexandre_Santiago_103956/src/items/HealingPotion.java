package items;

import logic.GameElement;
import pt.iscte.poo.utils.Point2D;

public class HealingPotion extends GameElement implements Pickable {

	private int layer = 1;

	public HealingPotion(Point2D position) {
		super(position);
	}

	@Override
	public String getName() {
		return "HealingPotion";
	}

	@Override
	public int getLayer() {
		return layer;
	}
}
