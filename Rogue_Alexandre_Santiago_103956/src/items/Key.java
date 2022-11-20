package items;

import logic.GameElement;
import pt.iscte.poo.utils.Point2D;

public class Key extends GameElement implements Pickable {
	
	private String id;
	private int layer = 1;

	public Key(Point2D position, String id) {
		super(position);
		this.id = id;
	}

	@Override
	public String getName() {
		return "Key";
	}
	
	@Override
	public int getLayer() {
		return layer;
	}
}
