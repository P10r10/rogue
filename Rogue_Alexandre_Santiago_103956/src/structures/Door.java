package structures;

import logic.GameElement;
import pt.iscte.poo.utils.Point2D;

public class Door extends GameElement {

	private String destination;
	private int x_dest;
	private int y_dest;
	private boolean isOpen = false;
	private String key_id;

	public Door(Point2D position, String destination, int x_dest, int y_dest, String key_id) {
		super(position);
		this.destination = destination;
		this.x_dest = x_dest;
		this.y_dest = y_dest;
		this.key_id = key_id;
		if (key_id == null) {
			isOpen = true;
		}
	}

	@Override
	public String getName() {
		if (isOpen) {
			return "DoorOpen";
		}
		return "DoorClosed";
	}
	
	@Override
	public int getLayer() {
		return 3;
	}
}
