package logic;

import java.util.ArrayList;
import java.util.List;

import pt.iscte.poo.gui.ImageTile;
import pt.iscte.poo.utils.Point2D;

public class ItemBar {
	private List<ImageTile> items = new ArrayList<>();

	public ItemBar() {
//		items.add(new Item(new Point2D(5, 10)));
//		items.add(new Item(new Point2D(6, 10)));
//		items.add(new Item(new Point2D(7, 10)));
//		items.add(new Item(new Point2D(8, 10)));
//		items.add(new Item(new Point2D(9, 10)));
	}

	public List<ImageTile> getComponents() {
		return items;
	}
	
	public void addItem(ImageTile image) {
		items.add(image);//HERE
	}

	private class Item implements ImageTile {

		private Point2D position;

		public Item(Point2D position) {
			this.position = position;
		}

		@Override
		public String getName() {
			return "Black";
		}

		@Override
		public Point2D getPosition() {
			return position;
		}

		@Override
		public int getLayer() {
			return 1;
		}
	}
}
