package items;

import logic.GameElement;
import pt.iscte.poo.utils.Point2D;

public class Sword extends GameElement implements Pickable {

	private int layer = 1;

	public Sword(Point2D position) {
		super(position);
	}

	@Override
	public String getName() {
		return "Sword";
	}

	@Override
	public int getLayer() {
		return layer;
	}
}
